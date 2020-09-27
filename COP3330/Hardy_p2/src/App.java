import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class App {
    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
            System.out.println("Entered input method method");
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput()
    {
        System.out.println("Do you need to enter BMI information?:");
        System.out.println("enter Y for yes \nenter N for no");
        Scanner scan = new Scanner(System.in);
        char checker = scan.next().charAt(0); //checks to see if the user is entering additional data
        char check.toUpperCase(checker);//turns check to cap in case user inputs a lowercase
        if(check == 'Y'){
            return true; //returns true if user wants to input more BMI data
        } else
        {
            return false; //returns false in case user does not want to input more BMI data
        }


    }

    public static double getUserHeight() {
        System.out.println("Entered getuserheight method");
        int height = -1;
        System.out.println("Please enter a your height in feet: ");
        do { //continues to ask user to enter data until it is a positive integer
            Scanner scan = new Scanner(System.in);
            height = scan.nextInt();
            if(height <= 0){
                System.out.println("Invalid height, please enter a positive value");
            }
        }while (height <= 0);

        return height;
    }

    public static double getUserWeight() {
        System.out.println("Entered getuserweight method");
        int weight = -1;
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

    public static void displayBmiInfo(BodyMassIndex bmi) {
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.println( "Underweight < 18.5 \n" + //displays BMI information to tell the user what each BMI value represents in terms of approximate health
                            "Normal weight = 18.5–24.9 \n" +
                            "Overweight = 25–29.9 \n" +
                            "Obesity >= 30");
    }
}
