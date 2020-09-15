import java.util.Arrays;

public class Decrypter {
    public String decrypterMethod(String encrytedData){
        int[] deconverterArray = new int[4];
        for(int i = 0; i <= 3; i++){
            String partOfString = encrytedData.substring(i, i+1); //gets each part of the array
            Integer x = Integer.valueOf(partOfString); //converts String input to integer
            //System.out.print("part:");
            //System.out.println(x);
            int cypher;
            switch(deconverterArray[i]){ //determines value before finding remainder, keeping the original digit plus 7
                case 7:
                case 8: 
                case 9:
                    cypher = deconverterArray[i];
                    break;
                case 0:
                    cypher = 10;
                    break;
                case 1:
                    cypher = 11;
                    break;
                case 2:
                    cypher = 12;
                    break;
                case 3:
                    cypher = 13;
                    break;
                case 4:
                    cypher = 14;
                    break;
                case 5:
                    cypher = 15;
                    break;
                case 6:
                     cypher = 16;
                    break;
                default:
                    break;
            }
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
        System.out.print("Your decrypted data is: ");
        String dencrytedData = Arrays.toString(deconverterArray);
        encrytedData = encrytedData.replaceAll(", ", "").trim().substring(1, 5); //removes unnecessary characters from array to string conversion
        System.out.println(encrytedData);
        return encrytedData;
    }
}
