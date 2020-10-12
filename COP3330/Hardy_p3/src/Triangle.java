public class Triangle extends Shape2D {
    private final double length;
    private final double height;
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
        return area = length * height / 2;
    }
}
