//슬롯 머신 게임, 무명클래스로 이벤트 처리
package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SlotGame extends JFrame {
	
	JPanel panel;
	JLabel one, two, three;
	JButton button;
	Random rd= new Random();
	int a= rd.nextInt(10);
	int b= rd.nextInt(10);
	int c= rd.nextInt(10);
	// 생성자
	public SlotGame() {
		panel= new JPanel();
		button= new JButton("스핀");
		
		//폰트 설정하는 법 몰랐으니까 잘 알아두기
		Font font=new Font("Serif",Font.BOLD,200);
		
		//라벨 크기 설정, 폰트 설정법 까먹음
		one= new JLabel(""+a);
		two= new JLabel(""+b);
		three= new JLabel(""+c);
		
		one.setFont(font);
		two.setFont(font);
		three.setFont(font);
		
		//무명 클래스를 이용한 이벤트 처리코드 잘 알아두기 까먹었었음
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a= rd.nextInt(10);
				b= rd.nextInt(10);
				c= rd.nextInt(10);
				one.setText(""+a);
				two.setText(""+b);
				three.setText(""+c);
			}
		});
		
		
		panel.add(one);
		panel.add(two);
		panel.add(three);
		
		add(panel,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		SlotGame slot = new SlotGame();

	}

}