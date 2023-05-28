package asd;
//JAVA GUI프로그래밍에 필요한 패키지들을 임포트
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

//JFrame 클래스를 상속받는 자식 클래스 SnowF 객체를 생성
public class SnowF extends JFrame {
	//랜덤 객체 생성
	Random random = new Random();
	//필요한 필드들 정의
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    int NUM_SNOWFLAKES = random.nextInt(100)+1;
    
    //ArrayList 인스턴스 생성, 타입은 Snowflake, 참조 변수 snowflakes
    private ArrayList<Snowflake> snowflakes;
    //JButton 타입의 인스턴스 pbutton, mbutton을 생성
    JButton pbutton, mbutton;
    
    //Snowflake 클래스 생성
    private class Snowflake {
    	//눈송이의 위치, 크기, 속도 필드를 생성
        private int x;
        private int y;
        private int size;
        private int speed;
        
        //생성자 메서드 Snowflake, 매개변수로는 위치 정보와 크기, 속도를 받는다.
        public Snowflake(int x, int y, int size, int speed) {
        	//받아오는 매개변수를 필드에 저장
            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = speed;
        }
        //fall 메서드 생성
        public void fall() {
        	//y의 위치를 증가
            y += speed;
            //창의 y축 크기를 넘기면 size를 -로 설정
            if (y > HEIGHT) {
                y = -size;
            }
        }
        //draw 메서드 생성, Graphics 객체를 매개변수로 받아옵니다.
        public void draw(Graphics g) {
        	//setColor메서드를 사용하여 Color을 하얀색으로 설정
            g.setColor(Color.WHITE);
            //원 채우기
            g.fillOval(x, y, size, size);
        }
    }
    
    //SnowF 생성자 메서드
    public SnowF() {
    	//창의 제목을 "Snowfall" 로 설정
        setTitle("Snowfall");
        //창 크기 설정
        setSize(WIDTH, HEIGHT);
        //창 닫을 시 프로그램도 종료 되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //new 연산자를 사용하여 ArrayList 객체를 생성 후 snowflakes에 저장
        snowflakes = new ArrayList<>();
        //for문을 사용하여 NUM_SNOWFLAKES 의 개수만큼 눈송이를 생성 (NUM_SNOWFLAKES는 난수)
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
        	//x, y, size, speed의 값을 난수로 설정
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int size = random.nextInt(10) + 5;
            int speed = random.nextInt(5) + 1;
            //Snowflake 객체를 생성, 매개변수 전달
            Snowflake snowflake = new Snowflake(x, y, size, speed);
            //snowflakes ArrayList에 추가
            snowflakes.add(snowflake);
        }
        
        //new 연산자를 사용하여 JPanel객체를 생성, 참조 변수는 panel
        JPanel panel = new JPanel() {
            @Override
            //paintComponent 메서드 생성, Graphics 객체를 받는다.
            protected void paintComponent(Graphics g) {
            	//부모 호출
                super.paintComponent(g);
                //뒷배경 그리기
                ImageIcon background = new ImageIcon("C:\\\\Users\\\\hong\\\\Desktop\\\\JavaSnow\\\\town.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
                
                //snowflakes 리스트에서 하나씩 꺼내서 그리기
                for (Snowflake snowflake : snowflakes) {
                    snowflake.draw(g);
                }
            }
        };
        //눈송이 추가 버튼 만들기,JButton 객체를 생성, pbutton에 저장
        pbutton=new JButton("눈송이 추가");
        //버튼 클릭시 이벤트 처리 메서드
        pbutton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		//0~30 까지 랜덤한 수를 발생시켜 추가 되는 눈송이의 갯수를 랜덤하게 설정
        		for(int i=0; i<random.nextInt(30);i++) {
        			int x = new Random().nextInt(WIDTH);
                    int y = 0;
                    int size = new Random().nextInt(10) + 5;
                    int speed = new Random().nextInt(5) + 1;
                    Snowflake snowflake = new Snowflake(x, y, size, speed);
                    snowflakes.add(snowflake);
        		}
                
        	}
        });
      //눈송이 삭제 버튼 만들기,JButton 객체를 생성, mbutton에 저장
        mbutton=new JButton("눈송이 삭제");
        //버튼 클릭시 이벤트 처리 메서드
        mbutton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
                if (!snowflakes.isEmpty()) {
                	//0~20 까지 랜덤한 수를 발생시켜 삭제 되는 눈송이의 갯수를 랜덤하게 설정
                	for(int i=0; i<random.nextInt(20); i++) {
                		snowflakes.remove(snowflakes.size() - 1);
                	}
                }
            }
        });
        //Timer 객체를 생성
        Timer timer = new Timer(30, e -> {
            for (Snowflake snowflake : snowflakes) {
                snowflake.fall();
            }
            panel.repaint();
        });
        timer.start();

       //객체들을 panel에 추가
        panel.add(pbutton);
        panel.add(mbutton);
        //panel을 프레임에 추가
        add(panel);
    }

    public static void main(String[] args) {
    	//객체 생성
    	SnowF snowfall = new SnowF();
    	//화면에 보이기
        snowfall.setVisible(true);
    }
}
