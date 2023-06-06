//그림판 어플리케이션

package asd;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SimplePaint extends JFrame {
	
	JButton Black,Red,Clear; 
	int prevX,prevY,currX,currY;
	Color currentColor;
	boolean dragging;
	JPanel bpanel;
	
	class Canvas extends JPanel{
		
	}
	
	
	// 생성자
	public SimplePaint() {
		Canvas canvas= new Canvas();
		Black= new JButton("Black");
		Red=new JButton("Red");
		Clear=new JButton("Clear");
		bpanel= new JPanel();
		
		bpanel.add(Black);
		bpanel.add(Red);
		bpanel.add(Clear);
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				prevX=e.getX();
				prevY=e.getY();
				dragging=true;
			}
			
			public void mouseReleased(MouseEvent e) {
				dragging= false;
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(dragging) {
					currX=e.getX();
					currY=e.getY();
					Graphics g= canvas.getGraphics();
					g.setColor(currentColor);
					g.drawLine(prevX,prevY,currX,currY);
					prevX=currX;
					prevY=currY;
				}
			}
		});
		
		Black.addActionListener(e->{
			currentColor=Color.black;
		});
		Red.addActionListener(e->{
			currentColor=Color.RED;
		});
		Clear.addActionListener(e->{
			repaint();
		});
		
		
		
		add(canvas,BorderLayout.CENTER);
		add(bpanel,BorderLayout.SOUTH);
		
		setSize(500,410);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		SimplePaint l = new SimplePaint();

	}

}