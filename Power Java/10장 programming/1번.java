package asd;

import java.awt.*;
import javax.swing.*;

public class Java extends JFrame{
	
	int click;
	public Java() {
		
		click=0;
		JButton button =new JButton("버튼을 눌러보세요!");
		JLabel label= new JLabel("클릭 횟수:"+click);
		JPanel panel= new JPanel();
		
		panel.add(button);
		panel.add(label);
		
		
		add(panel);
		
		button.addActionListener(e->{
			click++;
			label.setText("클릭 횟수:"+click);
		});
		
		setSize(300,150);
		setTitle("1번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Java j= new Java();
	}
}