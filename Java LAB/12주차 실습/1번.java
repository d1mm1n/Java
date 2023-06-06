//스마일 프로그램

package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SnowManFace extends JFrame {
	
	JPanel panel;
	JButton button1, button2;
	JLabel label;
	int stress=0;
	int a=180,b=-180,c=-180,d=180;
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.YELLOW);
			g.fillOval(20,30,200,200);
			g.setColor(Color.BLACK);
			g.drawArc(60,80,50,50,a,b); //왼쪽 눈
			g.drawArc(150,80,50,50,a,b); // 오른쪽 눈
			g.drawArc(70,130,100,70,c,d); //입
			
			if(stress<-10) {
				g.setColor(Color.GREEN);
				g.fillOval(20,30,200,200);
				g.setColor(Color.BLACK);
				g.drawArc(60,80,50,50,a,b); //왼쪽 눈
				g.drawArc(150,80,50,50,a,b); // 오른쪽 눈
				g.drawArc(70,130,100,70,c,d); //입
			}
			else if(stress>=10) {
				g.setColor(Color.RED);
				g.fillOval(20,30,200,200);
				g.setColor(Color.BLACK);
				g.drawArc(60,80,50,50,a,b); //왼쪽 눈
				g.drawArc(150,80,50,50,a,b); // 오른쪽 눈
				g.drawArc(70,130,100,70,c,d); //입
			}
			
		}
	}
	
	
	// 생성자
	public SnowManFace() {
		MyPanel mypanel= new MyPanel();
		add(mypanel,BorderLayout.CENTER);
		label= new JLabel("현재 스트레스 지수= "+stress);
		panel= new JPanel();
		button1= new JButton("선물");
		button2= new JButton("과제");
		
		//버튼 이벤트 처리 안에서 그래픽 객체 사용법 몰랐음 -> 공부하기
		//선물
		button1.addActionListener(e->{
			stress-=1;
			label.setText("현재 스트레스 지수= "+stress);
			a=180;
			b=-180;
			c=-180;
			d=180;
			//mypanel 참조해서 repaint 잊지 말기
			mypanel.repaint();
			
		});
		//과제
		button2.addActionListener(e->{
			stress+=1;
			label.setText("현재 스트레스 지수= "+stress);
			a=-180;
			b=180;
			c=180;
			d=-180;
			mypanel.repaint();
		});
		
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		
		add(panel,BorderLayout.SOUTH);
		setSize(300,310);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		SnowManFace s = new SnowManFace();

	}

}