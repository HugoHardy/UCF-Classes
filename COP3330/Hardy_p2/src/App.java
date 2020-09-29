import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("Do you need to enter BMI information?:");
        System.out.println("enter Y for yes \nenter N for no");
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
        System.out.println("Entered getuserheight method");
        int height;
        System.out.print("Please enter a your height in inches: ");
        do { //continues to ask user to enter data until it is a positive integer
            Scanner scan = new Scanner(System.in);
            height = scan.nextInt();
            if(height <= 0){
                System.out.println("Invalid height, please enter a positive value");
            }
        }while (height <= 0);

        return height;
    }

    private static double getUserWeight() {
        //prompts the user to enter their weight in pounds and only accepts positive values.
        System.out.println("Entered getuserweight method");
        int weight;
        System.out.println("Please enter a your weight in pounds: ");
        do{ //continues to ask user to enter data until it is a positive integer
            Scanner scan = new Scanner(System.in);
            weight = scan.nextInt();
            if(weight <= 0){
                System.out.println("Invalid weight, please enter a positive value");
            }
        }while(weight <= 0);

        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        //prints out a user's BMi score and category using the data contained in a BodyMassIndex object.
        System.out.println("display bmi " + bmi);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        //prints out the average BMI score of the data.
        System.out.println( "Underweight < 18.5 \n" + //displays BMI information to tell the user what each BMI value represents in terms of approximate health
                            "Normal weight = 18.5–24.9 \n" +
                            "Overweight = 25–29.9 \n" +
                            "Obesity >= 30");

        System.out.println("prints out bmiData" + bmiData);
    }
}
