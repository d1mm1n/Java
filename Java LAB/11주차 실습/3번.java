//가위바위보 게임, 람다식을 사용하여 이벤트 처리
//가위:0 바위:1 보:2
package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RCP extends JFrame {
	
	JLabel title,u,c,vs;
	JButton user1,user2, user3, com1,com2,com3;
	
	JPanel user,computer;
	Random rd= new Random();
	int rand=rd.nextInt(3);
	// 생성자
	public RCP() {
		title = new JLabel("가위, 바위, 보 게임");
		vs=new JLabel("VS");
		u= new JLabel("사용자");
		c= new JLabel("컴퓨터");
		
		user1=new JButton("가위");
		user2=new JButton("바위");
		user3=new JButton("보");
		
		com1=new JButton("가위");
		com2=new JButton("바위");
		com3=new JButton("보");
		
		user= new JPanel();
		computer= new JPanel();
		
		//가위바위보를 하고 다음 가위바위보를 할 때 선택하는 버튼 말고 나머지 버튼은 색이 안들어오도록 
		// 근데 쫌 노가다로 함 이게 맞나?
		
		//가위
		user1.addActionListener(e->{
			rand=rd.nextInt(3);
			user2.setBackground(null);
			user3.setBackground(null);
			//비겼을 때
			if (rand==0) {
				user1.setBackground(Color.GREEN);
				com1.setBackground(Color.GREEN);
				com2.setBackground(null);
				com3.setBackground(null);
				
			}
			//졌을 때
			else if(rand==1) {
				user1.setBackground(Color.RED);
				com2.setBackground(Color.YELLOW);
				com1.setBackground(null);
				com3.setBackground(null);
				
			}
			//이겼을 때
			else {
				user1.setBackground(Color.YELLOW);
				com3.setBackground(Color.RED);
				com1.setBackground(null);
				com2.setBackground(null);
			}
			
		});
		//바위
		user2.addActionListener(e->{
			user1.setBackground(null);
			user3.setBackground(null);
			rand=rd.nextInt(3);
			//비겼을 때
			if (rand==1) {
				user2.setBackground(Color.GREEN);
				com2.setBackground(Color.GREEN);
				com1.setBackground(null);
				com3.setBackground(null);
			}
			//졌을 때
			else if(rand==2) {
				user2.setBackground(Color.RED);
				com3.setBackground(Color.YELLOW);
				com1.setBackground(null);
				com2.setBackground(null);
			}
			//이겼을 때
			else {
				user2.setBackground(Color.YELLOW);
				com1.setBackground(Color.RED);
				com2.setBackground(null);
				com3.setBackground(null);
			}
			
		});
		//보
		user3.addActionListener(e->{
			user1.setBackground(null);
			user2.setBackground(null);
			rand=rd.nextInt(3);
			//비겼을 때
			if (rand==2) {
				user3.setBackground(Color.GREEN);
				com3.setBackground(Color.GREEN);
				com1.setBackground(null);
				com2.setBackground(null);
			}
			//졌을 때
			else if(rand==0) {
				user3.setBackground(Color.RED);
				com1.setBackground(Color.YELLOW);
				com2.setBackground(null);
				com3.setBackground(null);
			}
			//이겼을 때
			else {
				user3.setBackground(Color.YELLOW);
				com2.setBackground(Color.RED);
				com1.setBackground(null);
				com3.setBackground(null);
			}
			
		});
		
		
		user.add(user1);
		user.add(user2);
		user.add(user3);
		user.add(u);
		
		computer.add(com1);
		computer.add(com2);
		computer.add(com3);
		computer.add(c);
		add(title,BorderLayout.NORTH);
		add(vs,BorderLayout.CENTER);
		add(user,BorderLayout.WEST);
		add(computer,BorderLayout.EAST);
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		RCP rcp = new RCP();

	}

}