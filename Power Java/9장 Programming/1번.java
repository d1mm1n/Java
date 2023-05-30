package asd;

import java.awt.*;
import javax.swing.*;

public class java extends JFrame{
	JLabel label;
	JButton yesbutton, nobutton;
	
	public java() {
		label= new JLabel("자바는 재밌나요?");
		yesbutton= new JButton("Yes");
		nobutton= new JButton("No");

        //new로 FlowLayout() 객체 만들어서 전달해주는거 잊지말기 new!!! 
		setLayout(new FlowLayout());
		add(label);
		add(yesbutton);
		add(nobutton);
		
		setSize(300,100);
		setTitle("1번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		java j= new java();
	}
	
}