public class Cube extends Shape3D {
    private double length;
    public Cube(double length) {
        this.length = length;
    }
    @Override
    public String getName() {
        return "cube";
    }
    @Override
    public double getArea() {
        return area = length * length;
    }
    @Override
    public double getVolume() {
        return volume = length * length * length;
    }
}
