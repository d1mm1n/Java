//BMI 계산기 프로그램 
package asd;
import java.util.*;

import java.awt.*;
import javax.swing.*;

public class BMI extends JFrame{
		
		JPanel panel;
		JLabel label,k,mm,result;
		JTextField kg, m;
		JButton button;
		
		public BMI() {
			panel= new JPanel();	
			label= new JLabel("나의 BMI 지수는 얼마나 될까?");
			 k= new JLabel("나의 체중 (kg): ");
			 mm= new JLabel("나의 키 (m): ");
			 kg= new JTextField(10);
			 m= new JTextField(10);
			 button= new JButton("BMI 확인하기");
			 
		button.addActionListener(e->{
			//틀린부분: 아래의 문장을 작성 못함
			int kk=Integer.parseInt(kg.getText());
			double mmm=Double.parseDouble(m.getText());
			
			double bmi= kk/(mmm*mmm);
			result= new JLabel("BMI는 "+bmi+" 입니다.");
			panel.add(result);
			setVisible(true);
			
		});
		
		panel.add(label);
		panel.add(k);
		panel.add(kg);
		panel.add(mm);
		panel.add(m);
		panel.add(button);
		
		
		add(panel);
		setSize(350,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		BMI bmi=new BMI();
		
	}

}