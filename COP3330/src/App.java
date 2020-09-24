import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
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
        System.out.println("Do you need to enter BMI infomation?:");
        System.out.println("enter 1 for yes \n enter 0 for no");
        int check; //checks to see if the user is entering additional data
        Scanner scan = new Scanner(System.in);
        check = scan.nextInt();

        return true;
    }

    public static double getUserHeight() {


        int height;
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

    public static void displayBmiInfo(BodyMassIndex bmi) {
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
    }
}
