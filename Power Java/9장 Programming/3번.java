package asd;

//이벤트 처리는 안함
import java.awt.*;
import javax.swing.*;

public class java extends JFrame{

	JButton a,b,c,d,e;
	JLabel label;
	JPanel panel;
	public java() {
		label= new JLabel("자바 호텔에 오신 것을 환영합니다. 숙박일수를 입력하세요.");
		panel= new JPanel();
		
		a= new JButton("1일");
		b= new JButton("2일");
		c= new JButton("3일");
		d= new JButton("4일");
		e= new JButton("5일");
		
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
		panel.add(e);
		//라벨 텍스트를 중앙 정렬
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		setTitle("3번");
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		java j= new java();
	}
	
}