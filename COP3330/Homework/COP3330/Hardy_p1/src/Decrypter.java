import java.util.Arrays;

public class Decrypter {
    public String decrypterMethod(String encrytedData){
        int deconverterArray[] = new int[4];
        for(int i = 0; i <= 3; i++){
            String partOfString = encrytedData.substring(i, i+1); //gets each part of the array
            Integer x = Integer.valueOf(partOfString); //converts String input to integer
            //System.out.print("part:");
            //System.out.println(x);
            deconverterArray[i] = (x+7)%10; //gets reaminder and adds them to the array
            System.out.println(deconverterArray[i]);
        }
        int first, second, third, forth; //swaps the first and third int in the array
        first = deconverterArray[0];      //and the second and forth digit in the array
        second = deconverterArray[1];
        third =  deconverterArray[2];
        forth = deconverterArray[3];
        deconverterArray[0] = third;
        deconverterArray[2] = first;
        deconverterArray[1] = forth;
        deconverterArray[3] = second;
        System.out.print("Your encrypted data is: ");
        String dencrytedData = Arrays.toString(deconverterArray);
        encrytedData = encrytedData.replaceAll(", ", "").trim().substring(1, 5);
        //encrytedData.replace(',',' ').replace('[', ' ').replace(']', ' ').trim();
        System.out.println(encrytedData);
        return encrytedData;
    }
}
