package Week3;

import java.util.Random;

public class Problem3 {
    public static void main(String[] args) {
        int[][] twoDArray = new int[4][4];

        for(int i = 0; i < 4; i += 1) {
            for(int j = 0; j < 4; j += 1) {
                twoDArray[i][j] = 0;
            }
        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10) + 1;

            boolean isPossible = false;

            while(!isPossible) {
                int row = random.nextInt(4);
                int col = random.nextInt(4);

                if(twoDArray[row][col] == 0) {
                    twoDArray[row][col] = randomNumber;
                    isPossible = true;
                }
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(twoDArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

