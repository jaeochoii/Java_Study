package Week5;

class TV {
    private int size;
    public TV(int size) { this.size = size;}
    protected  int getSize() { return size; }
}

class ColorTV extends TV {
    private int color;
    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    protected int getColor() { return color; }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + getColor() + "컬러");
    }
}

class IPTV extends ColorTV {
    private String ipAddr;

    public IPTV(String ipAddr, int size, int color) {
        super(size, color);
        this.ipAddr = ipAddr;
    }

    public void printProperty() {
        System.out.print("나의 IPTV는 " + ipAddr + " 주소의 ");
        super.printProperty();
    }

    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();

        System.out.println();

        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}

public class Problem1 {
    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();

        System.out.println();

        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
