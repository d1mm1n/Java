//신호 변경 프로그램

package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Light extends JFrame {
	
	JButton button;
	int light=-1;
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawArc(40,30,100,100,0,360); 
			g.drawArc(140,30,100,100,0,360); 
			g.drawArc(240,30,100,100,0,360); 
			
			if(light==0) {
				g.setColor(Color.RED);
				g.fillOval(40,30,100,100);
			}
			else if(light==1) {
				g.setColor(Color.YELLOW);
				g.fillOval(140,30,100,100);
				
			}
			else if(light==2) {
				g.setColor(Color.GREEN);
				g.fillOval(240,30,100,100);
			}
		}
	}
	
	
	// 생성자
	public Light() {
		MyPanel panel= new MyPanel();
		button=new JButton("신호 변경");
		
		
		button.addActionListener(e->{
			light+=1;
			if(light==3) {
				light=0;
			}
			panel.repaint();
			
		});
		
		add(button,BorderLayout.SOUTH);
		add(panel,BorderLayout.CENTER);
		
		setSize(400,210);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Light l = new Light();

	}

}