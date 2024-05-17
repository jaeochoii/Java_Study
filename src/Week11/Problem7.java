package Week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class Problem7 extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[9];
    private int[] numbers = {1, 1, 1, 2, 2, 2, 3, 3, 3};
    private int clickCount = 0;
    private int[] selectedIndexes = new int[3];

    public Problem7() {
        setTitle("Memory Game");
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        Collections.shuffle(Arrays.asList(numbers));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int index = Arrays.asList(buttons).indexOf(clickedButton);

        if (buttons[index].getText().equals("")) {
            buttons[index].setText(String.valueOf(numbers[index]));
            selectedIndexes[clickCount] = index;
            clickCount++;

            if (clickCount == 3) {
                checkMatch();
            }
        }
    }

    private void checkMatch() {
        if (numbers[selectedIndexes[0]] == numbers[selectedIndexes[1]] &&
        numbers[selectedIndexes[0]] == numbers[selectedIndexes[2]]) {
            JOptionPane.showMessageDialog(this, "Congratulations! You win!");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "Try Again!");
            resetButtons();
        }
    }

    private void resetButtons() {
        for (int index : selectedIndexes) {
            buttons[index].setText("");
        }
        clickCount = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Problem7 game = new Problem7();
            game.setVisible(true);
        });
    }
}