//카운터 프로그램 
package asd;
import java.util.*;

import java.awt.*;
import javax.swing.*;

public class Count extends JFrame{
		
		int count=0;
		public Count() {
		JPanel panel= new JPanel();	
		JLabel label= new JLabel("카운터 값");
		JTextField f= new JTextField(10);
		JButton button= new JButton("증가");
		
		
		button.addActionListener(e->{
			count++;
			f.setText(count+"");
			
		});
		
		
		panel.add(label);
		panel.add(f);
		panel.add(button);
		
		
		add(panel);
		setSize(200,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		Count c=new Count();
	}

}