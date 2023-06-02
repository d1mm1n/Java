package asd;

import java.awt.*;
import javax.swing.*;

public class Java extends JFrame{

	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon img= new ImageIcon("C:\\Users\\hong\\Desktop\\img\\m2.jpg");
			Image i=img.getImage();
			g.drawImage(i,50, 50, null);
			g.drawString("홍지민", 200, 80);
			g.drawString("순천향대학교", 200, 100);
			g.drawString("CS 연구실", 200, 120);
		}
		
	}
	
	public Java() {
		MyPanel panel =new MyPanel();
		
		add(panel);
		
		setSize(400,250);
		setTitle("2번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Java j= new Java();
	}
}