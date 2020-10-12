public class Pyramid extends Shape3D {
    private final double length;
    private final double width;
    private final double height;
    public Pyramid(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    @Override
    public String getName() {
        return "pyramid";
    }
    @Override
    public double getArea() {
        double squareRoot1 = Math.sqrt((width * width) / 4 + (height * height));
        double squareRoot2 = Math.sqrt((length * length / 4) + (height * height));
        return area = length * width + length * squareRoot1 + width * squareRoot2;
    }
    @Override
    public double getVolume() {
        return volume = length * width * height / 3;
    }
}
