import java.util.Scanner;
import java.util.Arrays;
public class Encrypter {
    public static void main(String[] args) {

        System.out.print("Would you kindly input 4 digit data?: "); //kindly asks for an input
        Scanner Input = new Scanner(System.in); //scans for String input
        String Data = Input.next();
        System.out.print("Your input: ");
        System.out.println(Data); //displays String input
        converterMethod(Data); //transfers String input to convertMethod


    }
    public static void converterMethod(String data){ //method used to encrypt data

        int[] converterArray = new int[4];
        for(int i = 0; i <= 3; i++){
            String partOfString = data.substring(i, i+1); //gets each char of the string
            int x = Integer.parseInt(partOfString); //converts String input to individual integer
            converterArray[i] = (x+7)%10; //gets remainder and adds them to the array
        }
        int first, second, third, forth; //swaps the first and third int in the array
        first = converterArray[0];      //and the second and forth digit in the array
        second = converterArray[1];
        third =  converterArray[2];
        forth = converterArray[3];
        converterArray[0] = third;
        converterArray[2] = first;
        converterArray[1] = forth;
        converterArray[3] = second;
        System.out.print("Your encrypted data is: ");
        String encrytedData = Arrays.toString(converterArray);//converts int array to a string
        encrytedData = encrytedData.replaceAll(", ", "").trim().substring(1, 5); //removed brackets, commas, and spaces
        System.out.println(encrytedData);
        Decrypt obj1 = new Decrypt(); //calls Decrypter class
        obj1.decryptMethod(encrytedData); //transfers encrypted data to the decrypter class
    }
}
