package asd;

//bmi 계산기
//이벤트 처리는 안함
import java.awt.*;
import javax.swing.*;

public class java extends JFrame{
	
	JLabel label,m,kg;
	JPanel panel;
	JButton b;
	JTextField k, mm;
	
	public java() {
		panel=new JPanel();
		
		label=new JLabel("나의 BMI 지수는 얼마나 될까?");
		kg=new JLabel("나의 체중(kg)");
		m=new JLabel("나의 키(m)");
		b= new JButton("BMI 확인하기");
		
		k=new JTextField(10);
		mm=new JTextField(10);
		
		panel.add(label);
		panel.add(kg);
		panel.add(k);
		panel.add(m);
		panel.add(mm);
		panel.add(b);
		
		add(panel);
		
		setSize(250,200);
		setTitle("5번");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		java j=new java();
	}
}

