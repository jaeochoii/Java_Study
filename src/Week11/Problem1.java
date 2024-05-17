package Week11;

import javax.swing.*;
import java.awt.*;

class North extends JPanel {
    public North() {
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        setLayout(new FlowLayout());
        add(new JLabel("수식입력"));
        add(new JTextField(20));
    }
}

class Center extends JPanel {
    JButton b [] = { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };
    public Center() {
        setBackground(Color.white);
        setLayout(new GridLayout(4,4,5,5));
        for(int i = 0; i < 10; i++) {
            JButton num = new JButton(Integer.toString(i));
            add(num);
        }
        add(new JButton("CE"));
        add(new JButton("계산"));

        for(int i=0; i<b.length; i++) {
            b[i].setBackground(Color.CYAN);
            add(b[i]);
        }
    }
}

class South extends JPanel {
    public South() {
        setBackground(Color.YELLOW);
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("계산 결과"));
        add(new JTextField(15));
    }
}
public class Problem1 extends JFrame{
    public Problem1() {
        setTitle("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

        Container c = getContentPane(); // 컨텐트팬은 디폴트로 BorderLayout 배치 관리자.

        c.add(new North(), BorderLayout.NORTH);
        c.add(new Center(), BorderLayout.CENTER);
        c.add(new South(), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Problem1();
    }
}