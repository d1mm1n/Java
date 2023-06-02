package asd;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Java extends JFrame{
	
	JButton button =new JButton("색상 변경");
	class MyPanel extends JPanel{
		Random r= new Random();
		int R=r.nextInt(255)+1;
		int G=r.nextInt(255)+1;
		int B=r.nextInt(255)+1;
        Color c= new Color(R,G,B);
        
        MyPanel(){
        	 //button이 지역 변수로 선언 되어있으면 람다식에서 사용 못함!!!! 명심!!!!!!
            button.addActionListener(e->{
            	R=r.nextInt(255)+1;
        		G=r.nextInt(255)+1;
        		B=r.nextInt(255)+1;
                c= new Color(R,G,B);
    			repaint();
    		});	
            // setLayout(new BorderLayout()); 이 코드를 안적어서 BorderLayout 이 안먹혔었음!
            setLayout(new BorderLayout());
            add(button,BorderLayout.SOUTH);
        }
        public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.setColor(c);
    		g.fillRect(5, 5, 370, 180);
    	}
	}
	
	
	public Java() {
		MyPanel panel =new MyPanel();
		
		add(panel);
		
		setSize(400,250);
		setTitle("4번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Java j= new Java();
	}
}