package Week12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

class CenterPanel extends JPanel{

    private ImageIcon []images= {
            new ImageIcon("C:\\Temp/image0.jpg"),
            new ImageIcon("C:\\Temp/image3.jpg"),
    };
    private static Vector<ImageIcon> v=new Vector<ImageIcon>();
    private static JLabel jl;
    private static int idx=0;

    CenterPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i=0;i<images.length;i++) {
            v.add(images[i]);
        }

        jl=new JLabel(v.get(0));
        add(jl);
    }

    static void change_Left() {
        idx = idx-1 < 0 ? v.size() - 1 : idx - 1;
        jl.setIcon(v.get(idx));
    }

    static void change_Right() {
        idx = idx+1 == v.size() ? 0 : idx + 1;
        jl.setIcon(v.get(idx));
    }
}

class SouthPanel extends JPanel{

    private JButton []jbtn=new JButton[2];

    SouthPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.GRAY);

        jbtn[0]=new JButton(new ImageIcon("C:\\Temp/left.png"));
        jbtn[1]=new JButton(new ImageIcon("C:\\Temp/right.png"));

        add(jbtn[0]);
        add(jbtn[1]);

        jbtn[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CenterPanel.change_Left();
            }
        });

        jbtn[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CenterPanel.change_Right();
            }
        });
    }
}

public class Problem1 extends JFrame{

    Problem1(){
        setTitle("Problem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(new CenterPanel(),BorderLayout.CENTER);
        c.add(new SouthPanel(),BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new Problem1();
    }

}