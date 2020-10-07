public class Triangle extends Shape2D {
    private double length, height;
    public Triangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        area = length * height / 2;
        return area;
    }
}
