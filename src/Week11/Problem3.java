package Week11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Problem3 extends JFrame {
    public Problem3() {
        setTitle("Left/Right rotate");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel la = new JLabel("Love java");
        c.add(la);
        la.setFocusable(true);
        la.requestFocus();

        la.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    JLabel label = (JLabel)e.getSource();
                    StringBuffer text  = new StringBuffer(label.getText());
                    text = text.append(text.substring(0, 1));
                    label.setText(text.deleteCharAt(0).toString());
                }
            }
        });
    }
    public static void main(String[] args) {
        new Problem3();
    }
}
