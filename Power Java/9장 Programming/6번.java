package asd;

import java.awt.*;
import javax.swing.*;
// 아 도대체 배치 관리자 설정을 어케 하는거임??????
// 왜 난 예쁘게 안나오지 나중에 다시 고치겠음
public class Java extends JFrame {
    JLabel title, name, password, email, phone;
    JButton d, c;
    JPanel panel, bpanel;

    JTextField a = new JTextField(10);
    JTextField b = new JTextField(10);
    JTextField e = new JTextField(10);
    JTextField p = new JPasswordField(10);

    public Java() {
       

        bpanel = new JPanel();
        title = new JLabel("회원 등록하기");
        name = new JLabel("이름");
        password = new JLabel("패스워드");
        phone = new JLabel("전화번호");
        email = new JLabel("이메일");
        panel = new JPanel();

        d = new JButton("등록하기");
        c = new JButton("취소");

     
        panel.add(name);
        panel.add(a);
        panel.add(password);
        panel.add(p);
        panel.add(email);
        panel.add(b);
        panel.add(phone);
        panel.add(e);

        bpanel.add(d);
        bpanel.add(c);
        add(title, BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        add(bpanel,BorderLayout.SOUTH);

        setSize(500, 400);
        setTitle("6번");
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Java j = new Java();
    }
}
