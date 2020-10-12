public class Square extends Shape2D {
    private final double length;
    public Square(double length) {
        this.length = length;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return area = length * length;
    }
}
