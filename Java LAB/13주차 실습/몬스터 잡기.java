package asd;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class MonsterGame extends JFrame {

    private ArrayList<Monster> monsters = new ArrayList<>();
    private Image monsterImage;
    private JPanel panel;
    private static Random random = new Random();

    class Monster {
        private Image image;
        private int x;
        private int y;
        private int speedX;
        private int speedY;

        public Monster(Image image, int x, int y) {
            this.image = image;
            this.x = x;
            this.y = y;
            this.speedX = random.nextInt(3) + 1; // x축 이동 속도 (1~3)
            this.speedY = random.nextInt(3) + 1; // y축 이동 속도 (1~3)
        }

        public Image getImage() {
            return image;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move() {
            x += speedX;
            y += speedY;

            if (x <= 0 || x >= panel.getWidth() - image.getWidth(null)) {
                speedX = -speedX; // 벽에 부딪히면 방향 전환
            }

            if (y <= 0 || y >= panel.getHeight() - image.getHeight(null)) {
                speedY = -speedY; // 벽에 부딪히면 방향 전환
            }
        }
    }

    public MonsterGame() {
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Monster monster : monsters) {
                    g.drawImage(monster.getImage(), monster.getX(), monster.getY(), null);
                }
            }
        };

        ImageIcon icon = new ImageIcon("C:\\Users\\hong\\Desktop\\홍 과제 모음\\자바 LAB\\img\\m8.jpg");
        monsterImage = icon.getImage();

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int clickedX = e.getX();
                int clickedY = e.getY();

                Iterator<Monster> iterator = monsters.iterator();
                while (iterator.hasNext()) {
                    Monster monster = iterator.next();
                    int monsterX = monster.getX();
                    int monsterY = monster.getY();
                    int monsterWidth = monster.getImage().getWidth(null);
                    int monsterHeight = monster.getImage().getHeight(null);

                    if (clickedX >= monsterX && clickedX <= monsterX + monsterWidth &&
                            clickedY >= monsterY && clickedY <= monsterY + monsterHeight) {
                        iterator.remove();
                        repaint();
                        break; // 삭제 후에는 더 이상의 처리는 필요하지 않으므로 반복문을 종료합니다.
                    }
                }
            }
        });

        Timer timer = new Timer(10, e -> {
            for (Monster monster : monsters) {
                monster.move();
            }
            panel.repaint();
        });
        timer.start();

        setContentPane(panel);
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addMonster(int x, int y) {
    	for(int i=0; i<10;i++) {
    		Monster monster = new Monster(monsterImage, x, y);
            monsters.add(monster);
            
    	}
        
    }

    public static void main(String[] args) {
        MonsterGame monsterGame = new MonsterGame();
        monsterGame.addMonster(random.nextInt(10)+1, random.nextInt(10)+1);
    }
}
