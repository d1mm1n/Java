//화씨 온도를 섭씨 온도로 변환해주는 애플리케이션 만들기
package asd;
import java.util.*;

import java.awt.*;
import javax.swing.*;

public class Convert extends JFrame{
	JLabel label1, label2;
	JTextField tf1,tf2;
	JPanel panel;
	JButton button;
	public Convert() {
		label1=new JLabel("화씨 온도");
		label2=new JLabel("섭씨 온도");
		tf1=new JTextField(10);
		tf2=new JTextField(10);
		button=new JButton("변환");
		
		button.addActionListener(e->{
			int f=Integer.parseInt(tf1.getText());
			double c=(f-32.0)*5.0/9.0;
			tf2.setText(""+c);
		});
		
		panel= new JPanel();
		panel.add(label1);
		panel.add(tf1);
		panel.add(label2);
		panel.add(tf2);
		panel.add(button);
		
		
		add(panel);
		setSize(200,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		Convert c=new Convert();
	}

}