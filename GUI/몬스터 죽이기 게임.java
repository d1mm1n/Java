package asd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MonsterGame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MONSTER_SIZE = 50;
    private static final int MONSTER_SPEED = 1;

    private JPanel gamePanel;
    private List<Monster> monsters;
    private int score;
    private JLabel scoreLabel;

    public MonsterGame() {
        setTitle("Monster Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Monster monster : monsters) {
                    if (monster.isVisible()) {
                        g.drawImage(monster.getImage(), monster.getX(), monster.getY(), MONSTER_SIZE, MONSTER_SIZE, this);
                    }
                }
            }
        };
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Iterator<Monster> iterator = monsters.iterator();
                while (iterator.hasNext()) {
                    Monster monster = iterator.next();
                    if (monster.getBounds().contains(e.getPoint()) && monster.isVisible()) {
                        monster.setVisible(false);
                        score += monster.getScore();
                        scoreLabel.setText("Score: " + score);
                    }
                }
            }
        });

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gamePanel.add(scoreLabel);

        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
    }

    public void startGame() {
        monsters = new ArrayList<>();
        score = 0;

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(WIDTH - MONSTER_SIZE);
            int y = random.nextInt(HEIGHT - MONSTER_SIZE);
            Monster monster = new Monster(x, y);
            monsters.add(monster);
        }

        Thread gameThread = new Thread(() -> {
            while (true) {
                moveMonsters();
                removeInvisibleMonsters();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            int dx = monster.getDX();
            int dy = monster.getDY();
            int x = monster.getX();
            int y = monster.getY();

            if (x <= 0 || x >= WIDTH - MONSTER_SIZE) {
                dx = -dx;
            }
            if (y <= 0 || y >= HEIGHT - MONSTER_SIZE) {
                dy = -dy;
            }

            x += dx;
            y += dy;

            monster.setDX(dx);
            monster.setDY(dy);
            monster.setX(x);
            monster.setY(y);
        }
    }

    private void removeInvisibleMonsters() {
        Iterator<Monster> iterator = monsters.iterator();
        while (iterator.hasNext()) {
            Monster monster = iterator.next();
            if (!monster.isVisible()) {
                iterator.remove();
            }
        }
    }

    private class Monster {
        private Image image;
        private int x;
        private int y;
        private int dx;
        private int dy;
        private int score;
        private boolean visible;

        public Monster(int x, int y) {
            this.x = x;
            this.y = y;
            dx = (Math.random() < 0.5) ? -MONSTER_SPEED : MONSTER_SPEED;
            dy = (Math.random() < 0.5) ? -MONSTER_SPEED : MONSTER_SPEED;

            ImageIcon m8 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m8.jpg");
            ImageIcon m4 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m4.jpg");
            ImageIcon m2 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m2.jpg");

            Random r = new Random();
            int rn = r.nextInt(10);

            if (rn >= 0 && rn < 4) {
                image = m2.getImage();
                score = 2;
            } else if (rn >= 4 && rn < 8) {
                image = m4.getImage();
                score = 4;
            } else {
                image = m8.getImage();
                score = 8;
            }

            visible = true;
        }

        public Image getImage() {
            return image;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDX() {
            return dx;
        }

        public void setDX(int dx) {
            this.dx = dx;
        }

        public int getDY() {
            return dy;
        }

        public void setDY(int dy) {
            this.dy = dy;
        }

        public int getScore() {
            return score;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, MONSTER_SIZE, MONSTER_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MonsterGame game = new MonsterGame();
            game.startGame();
            game.setVisible(true);
        });
    }
}

/*몬스터 눌러도 삭제가 잘 안되는 이유
코드를 다시 살펴보니, 문제의 원인은 mouseClicked 이벤트 핸들러에서 break; 
문을 사용하여 루프를 종료하고 있기 때문입니다. break; 문을 사용하면 현재 반복문에서 탈출하게 되므로,
몬스터를 삭제한 후에 루프를 계속 진행하지 않게 됩니다.

해결 방법으로는 break; 문을 제거하고,
삭제된 몬스터가 있을 경우에도 루프를 계속해서 진행하도록 수정해야 합니다. 이를 위해 for 루프 대신 Iterator를 사용하여 삭제할 몬스터를 찾은 후,
삭제 작업을 마친 후에도 루프를 계속 진행할 수 있도록 해야 합니다.