public class BodyMassIndex {
    public BodyMassIndex(double height, double weight) {
        //class contains a public method to calculate a BMI score based on a height and weight value.
        double bmiAverage = ((703 * weight) / (height*height)); //calculates bmi using imperical values
        //class contains a public method to calculate a BMI category based on a height and weight value.
        String bmiCategory = null;
        if(bmiAverage >= 30){
            bmiCategory = "Obese";
        }
        else if(bmiAverage >= 25){
            bmiCategory  = "Overweight";
        }
        else if(bmiAverage >= 18.5){
            bmiCategory = "Normal Weight";
        }
        else if(bmiAverage < 18.5){
            bmiCategory = "Underweight";
        }
        System.out.println(bmiAverage + bmiCategory);
    }
}
