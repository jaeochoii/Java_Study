package Week12;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Problem6 extends JFrame {
    JLabel first, second, third, sameText;
    ImageIcon[] icons;

    Problem6() {
        setTitle("스레드를 가진 갬블링");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        setLayout(null);
        addKeyListener(new MyKeyAdapter());

        icons = new ImageIcon[5];
        for (int i = 0; i < 5; i++) {
            icons[i] = new ImageIcon("../image" + i + ".png");
        }

        first = new JLabel(icons[(int)(Math.random() * 4)], SwingConstants.CENTER);
        second = new JLabel(icons[(int)(Math.random() * 4)], SwingConstants.CENTER);
        third = new JLabel(icons[(int)(Math.random() * 4)], SwingConstants.CENTER);
        sameText = new JLabel("시작합니다.", SwingConstants.CENTER);

        first.setBackground(Color.PINK);
        first.setSize(100, 100);
        first.setLocation(40, 80);
        first.setOpaque(true);

        second.setBackground(Color.PINK);
        second.setSize(100, 100);
        second.setLocation(180, 80);
        second.setOpaque(true);

        third.setBackground(Color.PINK);
        third.setSize(100, 100);
        third.setLocation(320, 80);
        third.setOpaque(true);

        sameText.setSize(300, 50);
        sameText.setLocation(80, 200);

        add(first);
        add(second);
        add(third);
        add(sameText);

        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new Problem6();
    }

    class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '\n') {
                int firstIndex = (int) (Math.random() * 4);
                int secondIndex = (int) (Math.random() * 4);
                int thirdIndex = (int) (Math.random() * 4);

                first.setIcon(icons[firstIndex]);
                second.setIcon(icons[secondIndex]);
                third.setIcon(icons[thirdIndex]);

                if (firstIndex == secondIndex && secondIndex == thirdIndex) {
                    sameText.setText("축하합니다.");
                } else {
                    sameText.setText("아쉽군요");
                }
            }
        }
    }
}
