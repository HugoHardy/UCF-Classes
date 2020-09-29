public class BodyMassIndex {
    public BodyMassIndex(double height, double weight) {
        //class contains a public method to calculate a BMI score based on a height and weight value.
        double bmiscore = ((703 * weight) / (height*height)); //calculates bmi using empirical values
        //class contains a public method to calculate a BMI category based on a height and weight value.
        String bmiCategory = null;
        if(bmiscore >= 30){
            bmiCategory = "Obese";
        }
        else if(bmiscore >= 25){
            bmiCategory  = "Overweight";
        }
        else if(bmiscore >= 18.5){
            bmiCategory = "Normal Weight";
        }
        else if(bmiscore < 18.5){
            bmiCategory = "Underweight";
        }
        System.out.println("Your Bmi score is: " + bmiscore + "\n" + "Your bmi states you are currently: " + bmiCategory);
    }
}
