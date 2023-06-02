package asd;

/*BorderLayout는 컨테이너의 영역을 동서남북 중앙의 5개 영역으로 분할하며, 컴포넌트들은 이 영역들 중 하나에 배치됩니다. 
 이 레이아웃에서 colorpanel은 중앙에 배치되기 때문에 setPreferredSize()로 크기를 변경해도 동작하지 않습니다.*/

//일단 만들긴 만들었는데;;; 색있는 패널크기가 넘 작은디 왜 안커지는지 몰겠음,, 나중에 다시 시도 ㅜ 
import java.awt.*;
import javax.swing.*;

public class java extends JFrame{
	JLabel red,yellow,green,blue;
	JPanel r,y,g,b,lpanel,colorpanel;
	//생성자 메서드
	public java() {
		
		red=new JLabel("Red");
		yellow=new JLabel("Yellow");
		green=new JLabel("Green");
		blue=new JLabel("Blue");
		
		lpanel=new JPanel();
		r=new JPanel();
		y=new JPanel();
		g=new JPanel();
		b=new JPanel();
		
		lpanel.add(red);
		lpanel.add(yellow);
		lpanel.add(green);
		lpanel.add(blue);
		
		
		add(lpanel,BorderLayout.NORTH);
		r.setBackground(Color.RED);
		y.setBackground(Color.YELLOW);
		g.setBackground(Color.GREEN);
		b.setBackground(Color.BLUE);
		
		colorpanel= new JPanel();
		colorpanel.add(r);
		colorpanel.add(y);
		colorpanel.add(g);
		colorpanel.add(b);
		add(colorpanel, BorderLayout.CENTER);
		
		setTitle("4번");
		setSize(400,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		java j=new java();
	}
}

