import java.util.Scanner;
import java.util.Arrays;
public class Encrypter {
    public static void main(String[] args) {

        System.out.print("Would you kindly input 4 digit data: "); //kindly asks for an input
        Scanner Input = new Scanner(System.in); //scans for String input
        String Data = Input.next();
        System.out.print("Your input: ");
        System.out.println(Data); //displays String input
        converterMethod(Data); //transfers String input to convertMethod


    }
    public static String converterMethod(String data){ //method used to encrypt data

        int converterArray[] = new int[4];
        for(int i = 0; i <= 3; i++){
            String partOfString = data.substring(i, i+1); //gets each part of the array
            Integer x = Integer.valueOf(partOfString); //converts String input to integer
            //System.out.print("part:");
            //System.out.println(x);
            converterArray[i] = (x+7)%10; //gets reaminder and adds them to the array
            System.out.println(converterArray[i]);//inserts ints into converterArray
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
        Decrypter obj1 = new Decrypter(); //calls Decrypter class
        obj1.decrypterMethod(encrytedData); //transfers encrypted data to the decrypter class
        return encrytedData;
    }
}
