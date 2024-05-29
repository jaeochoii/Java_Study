package Week12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Problem2 extends JFrame {
    Problem2(){
        setTitle("CheckBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox disableButton = new JCheckBox("버튼 비활성화");
        JCheckBox hideButton = new JCheckBox("버튼 감추기");
        JButton btn = new JButton("test button");
        c.add(disableButton);
        c.add(hideButton);
        c.add(btn);
        disableButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    btn.setEnabled(false);
                }
                else {
                    btn.setEnabled(true);
                }
            }
        });
        hideButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    btn.setVisible(false);
                }
                else {
                    btn.setVisible(true);
                }
            }
        });
        setSize(300, 200);
        setVisible(true);
    }


    public static void main(String args[]){
        new Problem2();
    }
}
