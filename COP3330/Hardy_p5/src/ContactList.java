import java.io.*;
import java.util.*;

public class ContactList {
    private static final Scanner input = new Scanner(System.in);
    private static List<ContactItem> Contacts;

    public ContactList() {
        Contacts = new ArrayList<>();
    }
    public static void ListCreation(String listName) throws FileNotFoundException {// creates a new list text file with a user specified name

        if (listName.endsWith(".txt")) { //checks to see if user inputs file extension then creates a .txt file with the specified name
            new Formatter(listName);
        } else {
            new Formatter(listName + ".txt");
        }
        System.out.println("New task list has been created");


    }

    public static void WriteToList(String FileName) { //writes the list to the specified .txt file
        try(Formatter output = new Formatter(FileName)) {
            for (ContactItem cItem : Contacts) {
                output.format("First name: %s Last name: %s phonenumber: %s Email: %s\n", cItem.getFirstName(), cItem.get_LastName() ,cItem.get_phoneNumber(), cItem.get_phoneNumber());
            }
        } catch(NullPointerException e){
            throw new NullPointerException("ERROR: Data not saved");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DisplayLists(){
        try {
            String[] pathnames;

            File f = new File(".");

            FilenameFilter filter = (f1, name) -> name.endsWith(".txt");
            pathnames = f.list(filter);

            assert pathnames != null;
            for (String pathname : pathnames) {

                System.out.println(pathname);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ReadList(String FileName){ //reads the data specified folder
        if(!FileName.endsWith(".txt")){
            FileName = FileName + ".txt";
        }
        System.out.println("Reading: " + FileName);
        File file = new File("." + "\\" + FileName);
        int i  = 0;
        if(Contacts.get(i) == null){
            System.out.println(EmptyList());
        } else {
            for (ContactItem Item : Contacts) {
                System.out.println(i + ")" + "first name: " +  Item.getFirstName() + "\nLast name: " + Item.get_LastName() + "\nPhone:  " + Item.get_phoneNumber() + "\nEmail: " + Item.getEmail());
                i++;
            }
        }

    }
    public static String EmptyList(){
        return "List is empty";
    }
    public static void DataSetter(String FileName) throws IOException {
        if(!FileName.endsWith(".txt")){
            FileName = FileName + ".txt";
        }
        File file = new File("." + "\\" + FileName);
        BufferedReader read = new BufferedReader(new FileReader(file));

        String content;
        content = read.readLine();
        if(content == null){
            System.out.println("List is empty");
        } else {
            ContactItem data;
            while (content != null) {
                try {
                    String firstName = content.substring(content.indexOf("First name:") + 1, content.indexOf("Last name:"));
                    String lastName = content.substring(content.indexOf("Last name:") + 2, content.indexOf("phonenumber:"));;
                    String phoneNumber = content.substring(content.indexOf("phonenumber:") + 2, content.indexOf("Email:"));
                    String eMail = content.substring(content.indexOf("Email:") + 2);
                    data = new ContactItem(firstName, lastName, phoneNumber, eMail);
                    AddContactData(data);
                    content = read.readLine();
                } catch (NullPointerException e) {
                    throw new NullPointerException("ERROR: data null!");
                }
            }
        }
    }
    public static ContactItem GetData(){
        ContactItem data;
            String firstName = getFirstName();
            String lastName = getLastName();
            String phoneNumber = getPhoneNumber();
            String eMail = getEMail();
            data = new ContactItem(firstName, lastName, phoneNumber, eMail);
        return data;
    }
    public static void AddContactData(ContactItem data){
        try{
            Contacts.add(data);
        } catch (UnsupportedOperationException e){
            System.out.print("Warning: unsupported Operation");
        }
    }
    public static int GetListSize() {
        return Contacts.size();
    }

    private static String getFirstName(){
        System.out.println();
        System.out.print("Please enter first name: ");
        String fName = input.nextLine();
        if(fName == null || fName== ""){
            return " ";
        }
        return fName;
    }
    private static String getLastName(){
        System.out.println();
        System.out.print("Please enter last name: ");
        String lName = input.nextLine();
        if(lName == null || lName == ""){
            return " ";
        }
        return lName;
    }
    private static String getPhoneNumber(){
        System.out.println();
        System.out.print("Please enter phonenumber: ");
        String fName = input.nextLine();
        if(fName == null || fName== ""){
            return " ";
        }
        return fName;
    }
    private static String getEMail(){
        System.out.println();
        System.out.println("Please enter Email address: ");
        String eMail = input.nextLine();
        if(eMail == null || eMail == ""){
            return " ";
        }
        return eMail;
    }
    public static void EditPrompt(){
        System.out.print("Please choose a contact to edit: ");
    }
    public static void EditTaskData(){
        ContactItem data;
        int setInput = input.nextInt();
        input.nextLine();
        try{
                String firstName = getFirstName();
                String lastName = getLastName();
                String phoneNumber = getPhoneNumber();
                String eMail = getEMail();
                data = new ContactItem(firstName, lastName, phoneNumber, eMail);
                SetEdit(setInput, data);
        } catch (InputMismatchException e) {
            EditTaskData();
            throw new IllegalArgumentException("Not valid argument");
        } catch (ArrayIndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("ERROR: Invalid index! ");
        }
    }
    public static void SetEdit(int i, ContactItem data){
        Contacts.set(i, data);
    }
    public static void RemovePrompt(){
        System.out.println("Please choose task to remove: ");
    }
    public static void RemoveContactData(int i){
        Contacts.remove(i);
    }
}
