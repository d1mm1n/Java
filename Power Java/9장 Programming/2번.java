package asd;

//이벤트 처리는 안함
import java.awt.*;
import javax.swing.*;

public class java extends JFrame{
	JTextField text;
	JButton b;
	JLabel label;
	public java() {
		label= new JLabel("카운터 값");
		text= new JTextField(8);
		b= new JButton("증가");
		add(label);
		add(text);
		add(b);
		setLayout(new FlowLayout());
		setTitle("2번");
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		java j= new java();
	}
	
}