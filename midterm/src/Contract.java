import java.util.Scanner;

public class Contract {
    String name;
    String email;
    String phoneNumber;
    public static void main(String[] args){
        Contract contract = new Contract();
    }
    public Contract() {
        //Provide a constructor that creates a new Contact based on these fields.
        //Create a class `Contact` that represents personal contact information. *
        //A Contact should have a name, an email address, and a phone number.
        //string representation of a contact.

        int userInput;
        do{
            Scanner x = new Scanner(System.in);
            System.out.println("Do you with to get information or edit information?\n 1 to get information\n 2 to edit information\n");
            userInput = x.nextInt();
            if(userInput == 1){
                toString();
            } else if(userInput == 2){
                editor();
            }
        }while(userInput !=1);


    }

    public void editor(){
        //Provide accessor methods to retrieve and modify these fields.
        Scanner x = new Scanner(System.in);
        System.out.println("which would you like to edit? \n1 name\n2 email\n3 phonenumber\n");
        int userInput = x.nextInt();
        if(userInput == 1){
            Scanner newName = new Scanner(System.in);
            System.out.println("Please enter new name");
            name = newName.nextLine();
        } else if(userInput == 2){
            System.out.println("Please enter new email");
            Scanner newEmail = new Scanner(System.in);
            email = newEmail.nextLine();
        } else if(userInput == 3){
            System.out.println("Please enter new phone number");
            Scanner newPhoneNumber = new Scanner(System.in);
            phoneNumber = newPhoneNumber.nextLine();
        }



    }

    public String toString(){
        //Provide an implementation of the toString method to create a human-readable
        return name + "\n" + email + "\n" + phoneNumber;

    }
}
