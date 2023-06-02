package asd;

import java.awt.*;
import javax.swing.*;

public class Java extends JFrame{

	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(80,80,130,50);
			g.drawLine(180,80,130,50);
			g.drawRect(80, 80, 100, 100);
			g.drawRect(100,100,20,20);
			g.drawRect(140,100,30,60);
		}
		
	}
	
	public Java() {
		MyPanel panel =new MyPanel();
		
		
		
		add(panel);
		
		setSize(400,250);
		setTitle("1번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Java j= new Java();
	}
}