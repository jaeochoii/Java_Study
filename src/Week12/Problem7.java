package Week12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePanel extends JPanel {
    private JLabel avatar = new JLabel("@");
    private JLabel monster = new JLabel("M");

    int avatarX = 100;
    int avatarY = 100;
    int monsterX = 200;
    int monsterY = 200;

    public GamePanel() {
        setLayout(null);
        avatar.setForeground(Color.RED);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();
                if(key == KeyEvent.VK_UP) {
                    avatarY -= 10;
                } else if (key == KeyEvent.VK_DOWN) {
                    avatarY += 10;
                } else if (key == KeyEvent.VK_LEFT) {
                    avatarX -= 10;
                } else {
                    avatarX += 10;
                }
                int keyChar = e.getKeyChar();
                if(keyChar == 'q')
                    System.exit(0);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        avatar.setSize(15,15);
        avatar.setLocation(avatarX,avatarY);
        add(avatar);

        monster.setSize(15,15);
        monster.setLocation(monsterX,monsterY);
        add(monster);
    }
}

class MonsterThread extends Thread {
    private GamePanel p;

    public MonsterThread(GamePanel panel) {
        p = panel;
    }

    public void run() {
        while (true) {
            if(p.avatarX < p.monsterX) { //아바타가 왼쪽에 있으면
                p.monsterX -= 5;
            } else if (p.avatarX > p.monsterX) {//아바타가 오른쪽에 있으면
                p.monsterX += 5;
            }

            if (p.avatarY < p.monsterY) {//아바타가 위쪽에 있으면
                p.monsterY -= 5;
            } else if (p.avatarY > p.monsterY) {//아바타가 아래쪽에 있으면
                p.monsterY += 5;
            }

            p.repaint(); //몬스터 움직임

            try {
                sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
public class Problem7 extends JFrame{
    public Problem7() {
        setTitle("아바타와 괴물 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        setContentPane(panel);
        panel.setFocusable(true);
        panel.requestFocus();

        setSize(300,300);
        setVisible(true);

        MonsterThread th = new MonsterThread(panel);
        th.start();
    }
    public static void main(String[] args) {
        new Problem7();
    }
}
