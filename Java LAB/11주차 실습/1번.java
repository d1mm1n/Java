//차 움직이기 GUI 
package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MoveCar extends JFrame {
	
	JPanel panel,buttonpanel;
	JLabel car;
	JButton left, right;
	int x,y;
	// 생성자
	public MoveCar() {
		panel=new JPanel();
		buttonpanel=new JPanel();
		car= new JLabel(new ImageIcon("C:\\Users\\hong\\Desktop\\홍 과제 모음\\자바 LAB\\img\\car.png"));
		
		left= new JButton("LEFT");
		right= new JButton("RIGHT");
		
		panel.add(car,BorderLayout.CENTER);
		buttonpanel.add(left);
		buttonpanel.add(right);
		
		//내부 클래스 만들어서 이벤트 처리 했기 때문에 꼭 객체만들어 주기
		left.addActionListener(new MyListener());
		right.addActionListener(new MyListener());
		
		
		add(panel,BorderLayout.CENTER);
		add(buttonpanel,BorderLayout.SOUTH);
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	//내부 클래스 생성하는 거 잘 알아두기, 이미지 위치 변경 시 setLocation 사용하기 !!!!
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			x=car.getX();
			y=car.getY();
			if(e.getSource()==left) {
				car.setLocation(x-10,y);
			}
			else if(e.getSource()==right) {
				car.setLocation(x+10,y);
			}
		}
	}

	public static void main(String[] args) {
		MoveCar car = new MoveCar();

	}

}