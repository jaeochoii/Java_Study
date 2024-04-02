package Week5;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected  void move(int x, int y) { this.x = x; this.y = y;}
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y) {
        super(x, y);
    }

    public void setXY(int x, int y) {
        move(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String result = this.color + "색의 " + "(" + getX() + "," + getY() + ")의 점 ";
        return result;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        ColorPoint zeroPoint = new ColorPoint(0, 0);
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint cp = new ColorPoint(10, 10);
        cp.setXY(5, 5);
        cp.setColor("RED");
        System.out.println(cp.toString() + "입니다.");
    }
}
