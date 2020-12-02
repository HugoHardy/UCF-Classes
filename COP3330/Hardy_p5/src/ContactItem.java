

public class ContactItem {
    private String Firstname;
    private String LastName;
    private String phoneNumber;
    private String eMail;

    public ContactItem(String FirstName, String LastName, String phoneNumber, String eMail) {
        try {
            if (!IsAllEmpty()) {
                if (isFirstNameValid(Firstname)) {
                    Firstname = " ";
                } else {
                    this.Firstname = FirstName;
                }
                if (isLastNameValid(LastName)) {
                } else {
                    this.LastName = LastName;
                }
                if (isPhoneNumberValid(phoneNumber)) {
                    phoneNumber = " ";

                } else {
                    this.phoneNumber = phoneNumber;
                }
                if (isEMailValid(eMail)) {
                    eMail = " ";
                } else {
                    this.eMail = eMail;
                }
            } else {
                throw new IllegalArgumentException("ERROR: All information is empty!");
            }
        } catch (NullPointerException e){
            throw new NullPointerException("All data is blank!");
        }
    }

    public boolean IsAllEmpty() {
        return isFirstNameValid(Firstname) || isPhoneNumberValid(phoneNumber) || isEMailValid(eMail);
    }

    public String getFirstName() {

        return this.Firstname;
    }

    public boolean isFirstNameValid(String Firstname) {
        return Firstname.isEmpty() || Firstname.equals(" ") || Firstname.equals(null);// needs to work on date verification
    }
    public String getLastName(){
        return this.LastName;
    }
    public boolean isLastNameValid(String LastName){
        return LastName.isEmpty() || LastName.equals(" ") || LastName.equals(null);
    }

    public String getphoneNumber() {
        return this.Firstname;
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.isEmpty() || phoneNumber.equals(" ") || phoneNumber.equals(null);
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean isEMailValid(String eMail) {
        return eMail.isEmpty() || eMail.equals(" ") || eMail.equals(null);
    }
}
