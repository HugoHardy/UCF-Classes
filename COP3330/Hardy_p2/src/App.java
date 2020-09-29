import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput(){
        //prompts the user to enter "Y" or "N" and returns an appropriate boolean value based on their input.
        System.out.println("Do you need to enter BMI information? " + "enter Y for yes or enter N for no: ");
        Scanner scanner = new Scanner(System.in);
        char check = scanner.next().charAt(0); //checks to see if the user is entering additional data
        if(check == 'Y' || check == 'y'){
            return true; //returns true if user wants to input more BMI data
        }
        else
        {
            return false; //returns false in case user does not want to input more BMI data
        }


    }

    private static double getUserHeight() {
        //prompts the user to enter their height in inches and only accepts positive values.
        int height;
        System.out.print("Please enter a your height in inches: ");
        do { //continues to ask user to enter data until it is a positive integer
            Scanner scan = new Scanner(System.in);
            height = scan.nextInt();
            if(height <= 0){
                System.out.print("\nInvalid height, please enter a positive value: ");
            }
        }while (height <= 0);

        return height;
    }

    private static double getUserWeight() {
        //prompts the user to enter their weight in pounds and only accepts positive values.
        int weight;
        System.out.print("Please enter a your weight in pounds: ");
        do{ //continues to ask user to enter data until it is a positive integer
            Scanner scan = new Scanner(System.in);
            weight = scan.nextInt();
            if(weight <= 0){
                System.out.print("\nInvalid weight, please enter a positive value: ");
            }
        }while(weight <= 0);

        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        //prints out a user's BMi score and category using the data contained in a BodyMassIndex object.
        double bmiscore = bmi.giveBmi(); //acquires bmiScore from BodyMassIndex java class

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

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        //prints out the average BMI score of the data.
        double bmiAverage = 0 ;
        for (int i = 0; i < bmiData.size(); i++){
            bmiAverage = bmiAverage + bmiData.get(i).giveBmi(); //equates the sum of the bmiAverage by adding the bmiScore within the giveBmi method inside BodyMassIndex java class
        }
        bmiAverage = bmiAverage/bmiData.size(); //equates the average bmi
        System.out.println("The average Bmi score is: " + bmiAverage);
    }
}
