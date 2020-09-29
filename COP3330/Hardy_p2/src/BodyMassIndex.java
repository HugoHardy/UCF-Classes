public class BodyMassIndex {
    private double height, weight, bmiscore;

    public BodyMassIndex(double height, double weight) {
        //class contains a public method to calculate a BMI score based on a height and weight value.
        this.height = height;
        this.weight = weight;
        this.bmiscore = ((703 * weight) / (height*height)); //calculates bmi using empirical values

    }

    public double giveBmi(){
        return bmiscore;
    }
}
