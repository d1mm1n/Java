//숫자 추측 게임 만들기
package asd;

import java.util.*;

import java.awt.*;
import javax.swing.*;

public class NumGame extends JFrame {

	JPanel panel;
	JLabel label, hint;
	JTextField user;
	JButton again, exit, check;
	Random r = new Random();
	int com = r.nextInt(100) + 1;

	// 생성자
	public NumGame() {
		panel = new JPanel();
		label = new JLabel("숫자를 추측하시오: " + com);

		user = new JTextField(10);

		again = new JButton("새게임");
		exit = new JButton("종료");
		check = new JButton("검사 해보기");
		hint = new JLabel();

		check.addActionListener(e -> {
			int u = Integer.parseInt(user.getText());
			if (u == com) {
				hint.setText("정답 입니다!");
				user.setBackground(Color.GREEN);
			} else if (u > com) {
				hint.setText("너무 큽니다.");
				user.setBackground(Color.RED);
			} else {
				hint.setText("너무 작습니다.");
				user.setBackground(Color.YELLOW);
			}
		});

		again.addActionListener(e -> {
			com = r.nextInt(100) + 1;
			label.setText("숫자를 추측하시오: " + com);
			
		});
		exit.addActionListener(e -> {
			System.exit(0);
			
		});
		
		panel.add(label);
		panel.add(user);
		panel.add(again);
		panel.add(exit);
		panel.add(check);
		panel.add(hint);

		add(panel);
		setSize(330, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		NumGame ng = new NumGame();

	}

}