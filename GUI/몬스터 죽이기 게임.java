package asd;
//자바 GUI 프로그래밍에 필요한 패키지들을 임포트
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//JFrame 클래스를 상속받는 자식 클래스 MonsterGame 클래스를 생성
public class MonsterGame extends JFrame {
	//창 크기, 몬스터 객체의 사이즈, 속도를 정의
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MONSTER_SIZE = 70;
    private static final int MONSTER_SPEED = 1;
    
    //JPanel 타입의 인스턴스 gamePanel을  선언
    private JPanel gamePanel;
    //ArrayList 생성, 타입은 Monster 객체, 참조변수는 monsters
    private ArrayList<Monster> monsters;
    //점수를 저장할 필드 score을 선언
    private int score;
    //JLabel 타입 인스턴스 scoreLabel, GameClearLabel을 선언
    private JLabel scoreLabel, gameClearLabel;
    
    //생성자 메서드
    public MonsterGame() {
    	//SetTitle 메서드를 사용해 프레임 제목을 Monster Game으로 설정
        setTitle("Monster Game");
        //창을 닫을 시에 프로그램도 종료 되도록 명령어 작성
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //사용자가 창 크기를 임의로 조정하지 못하도록 고정
        setResizable(false);
        
        //JPanel 객체를 생성, gamePanel에 저장
        gamePanel = new JPanel() {
            @Override
            //그래픽 메서드 정의, Graphics를 매개변수로 받는다.
            protected void paintComponent(Graphics g) {
            	//부모 클래스를 호출
                super.paintComponent(g);
                //for반복문을 사용하여 ArrayList에서 하나씩 가져오기
                for (Monster monster : monsters) {
                	//isVisible은 가시성 확인 메서드, 몬스터가 화면에 보이는지 여부를 판단
                    if (monster.isVisible()) {
                    	//무작위 위치에 몬스터 객체를 그리기
                        g.drawImage(monster.getImage(), monster.getX(), monster.getY(), MONSTER_SIZE, MONSTER_SIZE, this);
                    }
                }
            }
        };
        //gamePanel의 배경색을 빨강색으로 설정
        gamePanel.setBackground(Color.RED);
        //gamePanel의 크기를 설정, new 를 사용하여 Dimension 객체를 생성 후 패널의 너비와 높이를 설정
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //gamePanel의 마우스 이벤트 처리 메서드, MouseAdapter 객체를 생성
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            //마우스 클릭 이벤트 처리, MouseEvent를 매개변수로 받아온다.
            public void mouseClicked(MouseEvent e) {
            	//리스트의 요소를 순회하기 위해 반복자를 생성
            	//Iterator은 자바 컬렉션 프레임 워크에서 컬렉션의 요소들을 순차적으로 접근하고 삭제하는데 사용되는 인터페이스
                Iterator<Monster> iterator = monsters.iterator();
                //반복문을 사용하여 Iterator이 순회할 요소가 남았는지를 확인
                //hasNext() 는 다음 요소가 있다면 true를 반환
                while (iterator.hasNext()) {
                	//다음 요소를 가져오고, 해당 요소를 Monster객체로 할당
                    Monster monster = iterator.next();
                    //마우스 클릭 이벤트가 발생 했을 대 클릭된 좌표가 monster의 경계영역 안에 위치하고, 몬스터가 보이는 경우에만 실행
                    if (monster.getBounds().contains(e.getPoint()) && monster.isVisible()) {
                    	//몬스터가 안보이도록 설정
                        monster.setVisible(false);
                        //점수를 가져와 저장
                        score += monster.getScore();
                        // 라벨에 보이기
                        scoreLabel.setText("Score: " + score);

                    }
                }
            }
        });
        
        //new 연산자를 사용하여 JLabel 객체를 생성, "Score:0" 텍스트를 보이기, scoreLabel에 저장
        scoreLabel = new JLabel("Score: 0");
        //scoreLabel의 폰트를 설정
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        //scorePanel을 gamePanel에 추가
        gamePanel.add(scoreLabel);
        
        //new 연산자를 사용하여 JLabel객체를 생성, Game Clear! 텍스트를 표시, gameClearLabel에 저장
        gameClearLabel = new JLabel("Game Clear!");
        //폰트 설정
        gameClearLabel.setFont(new Font("Arial", Font.BOLD, 36));
        //글자 색을 하얀색으로 설정
        gameClearLabel.setForeground(Color.WHITE);
        //게임이 클리어 되면 보이도록 초기 화면에서는 보이지 않기 때문에 setVisible을 false로 설정
        gameClearLabel.setVisible(false);
        //gameClearLabel 컴포넌트를 gamePanel에 추가
        gamePanel.add(gameClearLabel);
        
        
        //gamePanel을 프레임에 추가
        add(gamePanel);
        //프레임의 크기를 내부 컨텐츠에 맞게 자동으로 조정
        pack();
        //프레임을 화면의 가운데로 위치 시키는 역할, null을 매개변수로 전달하여 참조할 컴포넌트 없음을 의미
        setLocationRelativeTo(null);
    }
    //startGame 메서드를 생성
    public void startGame() {
    	
    	//new 연산자를 사용하여 ArrayList 객체를 생성, monster에 저장
        monsters = new ArrayList<>();
        //점수를 0으로 설정
        score = 0;
        
        //new연산자를 사용하여 Random객체를 생성
        Random random = new Random();
        //for 반복문을 사용하여 10개의 몬스터 객체를 생성
        for (int i = 0; i < 10; i++) {
        	//몬스터의 위치는 랜덤으로 생성 되도록 설정, 창 밖으로 벗어나지 않게 하기 위해 몬스터의 크기를 빼주기
            int x = random.nextInt(WIDTH - MONSTER_SIZE);
            int y = random.nextInt(HEIGHT - MONSTER_SIZE);
            //new 연산자를 사용하여 Monster객체를 생성, 참조 변수는 monster
            Monster monster = new Monster(x, y);
            //ArrayList에 몬스터 객체를 추가
            monsters.add(monster);
        }
        
        //스레드 설정
        //new 연산자를 사용하여 새로운 스레드를 생성, 람다식 사용
        Thread gameThread = new Thread(() -> {
        	//무한루프 를 사용하여 게임 로직이 무한히 반복되도록 구성
            while (true) {
            	//몬스터 움직이는 메서드 호출
                moveMonsters();
                //가시성 확인 후 삭제 메서드 호출
                removeInvisibleMonsters();
                //갱신
                repaint();
                //if문을 사용하여 만약 ArrayList 리스트가 비었다면 
                //gamePanel의 배경을 초록색으로 바꾸고 gameClearLabel을 보이도록 설정
                if (monsters.isEmpty()) {
                	gamePanel.setBackground(Color.GREEN);
                	gameClearLabel.setVisible(true);
                	setVisible(true);
                }try {
                	//스레드를 10밀리초 동안 일시 정지하는 역할
                	//게임 루프의 반복 간격을 제어, 10밀리초마다 게임 로직이 실행되고 화면이 업데이트 됨
                	//게임이 일정한 속도로 진행되는것을 보장하기 위해
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        });
        //스레드 시작
        gameThread.start();
    }
    
    //moveMonster 메서드를 생성
    private void moveMonsters() {
    	//for 반복문을 사용하여 ArrayList에서 객체를 하나씩 빼오기
        for (Monster monster : monsters) {
        	//getDX() 는 객체의 x방향 속도를 반환
        	//getDY()는 객체의 y방향 속도를 반환
            int dx = monster.getDX();
            int dy = monster.getDY();
            //getX()는 객체의 x좌표를 반환
            //getY()는 객체의 y좌표를 반환
            int x = monster.getX();
            int y = monster.getY();
            
            //몬스터 객체가 창을 넘어가지 않고 튕기도록 방향 설정
            if (x <= 0 || x >= WIDTH - MONSTER_SIZE) {
                dx = -dx;
            }
            if (y <= 0 || y >= HEIGHT - MONSTER_SIZE) {
                dy = -dy;
            }
            //이동
            x += dx;
            y += dy;
            
            //변경된 설정값 적용
            monster.setDX(dx);
            monster.setDY(dy);
            monster.setX(x);
            monster.setY(y);
        }
    }
    
    //removeInvisibleMonster 메서드를 생성, 삭제 역할을 하는 메서드
    private void removeInvisibleMonsters() {
    	//리스트를 순회하기 위해 Iterator 객체를 생성
    	//Iterator는 자바의 컬렉션을 순회하고 요소에 접근하는데 사용되는 인터페이스
        Iterator<Monster> iterator = monsters.iterator();
        //다음으로 이동
        while (iterator.hasNext()) {
            Monster monster = iterator.next();
            //객체가 보이지 않으면 삭제하기
            if (!monster.isVisible()) {
                iterator.remove();
                
            }
            
        }
    }
    
    //Monster 클래스를 생성
    private class Monster {
    	//필요한 필드들을 정의
        private Image image;
        private int x;
        private int y;
        private int dx;
        private int dy;
        private int score;
        private boolean visible;
        
        //생성자 메서드, x와 y를 매개변수로 받는다.
        public Monster(int x, int y) {
        	//매개변수를 필드에 저장
            this.x = x;
            this.y = y;
            
            //Math.random() 함수는 0 이상 1미만의 난수를 생성
            // 몬스터의 이동 방향을 무작위로 설정해주는 코드
            dx = (Math.random() < 0.5) ? -MONSTER_SPEED : MONSTER_SPEED;
            dy = (Math.random() < 0.5) ? -MONSTER_SPEED : MONSTER_SPEED;
            
            //new 연산자를 사용하여 ImageIcon 객체를 생성, 몬스터 이미지와 아이 이미지를 가져옵니다. 
            ImageIcon m8 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m8.jpg");
            ImageIcon m4 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m4.jpg");
            ImageIcon m2 = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m2.jpg");
            ImageIcon kid = new ImageIcon("C:\\Users\\hong\\Desktop\\img\\kid.jpg");
            
            //랜덤 객체 생성, 참조 변수는 r
            Random r = new Random();
            //0~13 의 난수를 생성하고 int타입 변수 rn에 저장
            int rn = r.nextInt(14);
            
            //0~3 의 난수가 발생하면 m2 몬스터 이미지의 객체를 가져옵니다.
            //점수는 2점으로 설정
            if (rn >= 0 && rn < 4) {
                image = m2.getImage();
                score = 2;
            }
            //4~7사이의 난수가 발생하면 m4몬스터 이미지의 객체를 가져옵니다.
            //점수는 4점으로 설정
            else if (rn >= 4 && rn < 8) {
                image = m4.getImage();
                score = 4;
            } 
          //8~9사이의 난수가 발생하면 kid 이미지의 객체를 가져옵니다.
            //점수는 -2점으로 설정
            else if (rn >= 8 && rn < 10) {
                image = kid.getImage();
                score = -2;
            } 
           //그외의 경우에는 m8 몬스터 이미지의 객체를 가져옵니다.
            //점수는 8점으로 설정
            else {
                image = m8.getImage();
                score = 8;
            }
            visible = true;
        }

        public Image getImage() {
            return image;
        }
        //생성자와 설정자 메서드들
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
        
        //getBounds 메서드는 몬스터 객체의 경계 영역을 나타내는 Rectangle 객체를 반환 하는 메서드 
        public Rectangle getBounds() {
            return new Rectangle(x, y, MONSTER_SIZE, MONSTER_SIZE);
        }
    }
    
    //메인 함수 
    public static void main(String[] args) {
    	//new 연산자를 사용하여 MonsterGame 객체를 생성
        MonsterGame game = new MonsterGame();
        //게임 시작하기!
        game.startGame();
        game.setVisible(true);
    }
}
