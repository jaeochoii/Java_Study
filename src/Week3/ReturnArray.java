package Week3;

public class ReturnArray {
    static int[] makeArray() {
        int temp[] = new int[4];

        for(int i = 0; i < temp.length; i += 1) {
            temp[i] = i;
        }
        return temp;
    }

    public static void main(String[] args) {
        int intArray[];
        intArray = makeArray();
        for(int i = 0; i < intArray.length; i += 1) {
            System.out.print(intArray[i] + " ");
        }
    }
}
