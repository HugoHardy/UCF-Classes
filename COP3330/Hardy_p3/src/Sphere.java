public class Sphere extends Shape3D {
    private final double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "sphere";
    }
    @Override
    public double getArea() {
        return area = 4 * Math.PI * (radius * radius);
    }
    @Override
    public double getVolume() {
        return volume = 4 * Math.PI * (radius * radius * radius / 3);
    }
}
