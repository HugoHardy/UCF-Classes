public class BodyMassIndex {
    private double height, weight, bmiScore;

    public BodyMassIndex(double height, double weight) {
        //class contains a public method to calculate a BMI score based on a height and weight value.
        this.height = height;
        this.weight = weight;
        this.bmiScore = ((703 * weight) / Math.pow(height , 2)); //calculates bmi using empirical values

    }

    public double giveBmi(){

        return bmiScore;
    }
}
