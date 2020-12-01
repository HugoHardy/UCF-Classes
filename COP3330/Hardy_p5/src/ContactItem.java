

public class ContactItem {
    private String Firstname;
    private String LastName;
    private String phoneNumber;
    private String eMail;

    public ContactItem(String FirstName, String LastName, String phoneNumber, String eMail) {
        if (IsAllEmpty()) {
            if (isFirstNameValid(Firstname)) {
                System.out.println("Firstname is valid");
                this.Firstname = FirstName;
            } else {
                Firstname = " ";
            }
            if(isLastNameValid(LastName)){
                this.LastName = LastName;
            }
            if (isPhoneNumberValid(phoneNumber)) {
                System.out.println("Firstname is valid");
                this.phoneNumber = phoneNumber;
            } else {
                phoneNumber = " ";//redundancies

            }
            if (isEMailValid(eMail)) {
                this.eMail = eMail;
            } else {
                eMail = " ";
            }
        } else{
            throw new IllegalArgumentException("ERROR: All information is empty!");
        }
    }

    public boolean IsAllEmpty() {
        return isFirstNameValid(Firstname) || isPhoneNumberValid(phoneNumber) || isEMailValid(eMail);
    }

    public String getFirstName() {

        return this.Firstname;
    }

    public boolean isFirstNameValid(String Firstname) {
        return !Firstname.isEmpty();// needs to work on date verification
    }
    public String getLastName(){
        return this.LastName;
    }
    public boolean isLastNameValid(String LastName){
        return !LastName.isEmpty();
    }

    public String getphoneNumber() {
        return this.Firstname;
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        return !phoneNumber.isEmpty();
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean isEMailValid(String eMail) {
        return !eMail.isEmpty();
    }
}
