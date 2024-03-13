public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        int i = 100;

        System.out.println(b+i);
        System.out.println(10 / 4);
        System.out.println(10.0 / 4);
        System.out.println((char)0x12340041);
        System.out.println((byte)(b+i)); // 227을 4바이트로 해줄때 0000000011100011 -> 맨 앞이 음수로 인식되어서 - (00011100) = -29
        System.out.println((int)2.9 + 1.8);
        System.out.println((int)(2.9 + 1.8));
        System.out.println((int)2.9 + (int)1.8);
    }
}