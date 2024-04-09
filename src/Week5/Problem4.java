package Week5;

interface Shape {
    final double PI = 3.14;

    void draw();

    double getArea();

    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    public double getArea() {
        return radius * radius * PI;
    }
}

class Rect implements Shape {
    private int width, height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width +"x" + height + "크기의 사각형 입니다.");
    }

    public double getArea() {
        return width * height;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Shape[] list = new Shape[2];
        list[0] = new Circle(10);
        list[1] = new Rect(10, 40);

        for(int i = 0; i < list.length; i += 1) {
            list[i].redraw();
        }
        for(int i = 0; i < list.length; i += 1) {
            System.out.println("면적은 " + list[i].getArea());
        }
    }
}
