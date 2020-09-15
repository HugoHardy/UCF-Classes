import java.util.Arrays;

public class Decrypt {
    public void decryptMethod(String encryptedData){
        int[] deconverterArray = new int[4];
        for(int i = 0; i <= 3; i++){
            String partOfString = encryptedData.substring(i, i+1); //gets each part of the array
            int x = Integer.parseInt(partOfString); //converts String input to integer
            switch(x){ //determines value before finding remainder, keeping the original digit plus 7
                case 7:
                case 8:
                case 9:
                    deconverterArray[i] = x;
                    break;
                case 0:
                    deconverterArray[i] = 10;
                    break;
                case 1:
                    deconverterArray[i] = 11;
                    break;
                case 2:
                    deconverterArray[i] = 12;
                    break;
                case 3:
                    deconverterArray[i] = 13;
                    break;
                case 4:
                    deconverterArray[i] = 14;
                    break;
                case 5:
                    deconverterArray[i] = 15;
                    break;
                case 6:
                    deconverterArray[i] = 16;
                    break;
                default:
                    break;
            }
            deconverterArray[i] = deconverterArray[i]-7; //subtracts 7 from the reverse modulus numbers
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
        String decryptedData = Arrays.toString(deconverterArray);
        decryptedData = decryptedData.replaceAll(", ", "").trim().substring(1, 5); //removes unnecessary characters from array to string conversion
        System.out.println(decryptedData);
    }
}
