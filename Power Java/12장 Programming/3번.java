package asd;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Java extends JFrame{
	
	
	class MyPanel extends JPanel{
		int x,y;
		boolean drawRectangle;
		public MyPanel() {
			drawRectangle= false;
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					
					x=e.getX();
					y=e.getY();
					drawRectangle= true;
					repaint();
				}
			});
			//이거 못했음 잘 봐두기!
			 addMouseMotionListener(new MouseMotionAdapter() {
	                public void mouseDragged(MouseEvent e) {
	                    x = e.getX();
	                    y = e.getY();
	                    repaint();
	                }
	            });
		}
		protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("마우스를 클릭하면 사각형이 그려집니다!",10,10);
            if(drawRectangle) {
            	g.setColor(Color.RED);
                g.fillRect(x,y,50,50);
                g.drawRect(x, y, 50, 50);
            }
		}
		
	}
	
	public Java() {
		MyPanel panel =new MyPanel();
		
		add(panel);
		
		setSize(400,250);
		setTitle("3번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Java j= new Java();
	}
}