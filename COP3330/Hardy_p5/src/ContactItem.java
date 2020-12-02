

public class ContactItem {
    private String _Firstname;
    private String _LastName;
    private String _phoneNumber;
    private String _eMail;

    public ContactItem(String FirstName, String LastName, String phoneNumber, String eMail) {
        try {
            if (!IsAllEmpty(FirstName, LastName, phoneNumber, eMail)) {
                if (isFirstNameValid(FirstName)) {
                    _Firstname = " ";
                } else {
                    this._Firstname = FirstName;
                }
                if (isLastNameValid(LastName)) {
                    _LastName = " ";
                } else {
                    this._LastName = LastName;
                }
                if (isPhoneNumberValid(phoneNumber)) {
                    _phoneNumber = " ";

                } else {
                    this._phoneNumber = phoneNumber;
                }
                if (isEMailValid(eMail)) {
                    _eMail = " ";
                } else {
                    this._eMail = eMail;
                }
            } else {
                throw new IllegalArgumentException("ERROR: All information is empty!");
            }
        } catch (NullPointerException e){
            throw new NullPointerException("All data is blank!");
        }
    }

    public boolean IsAllEmpty(String firstName, String lastName, String phoneNumber, String eMail) {
        return isFirstNameValid(firstName) && isLastNameValid(lastName) && isPhoneNumberValid(phoneNumber) && isEMailValid(eMail);
    }

    public String getFirstName() {

        return this._Firstname;
    }

    public boolean isFirstNameValid(String Firstname) {
        return Firstname.isEmpty() || Firstname.equals(null);
    }
    public String get_LastName(){
        return this._LastName;
    }
    public boolean isLastNameValid(String LastName){
        return LastName.isEmpty() || LastName.equals(null);
    }

    public String get_phoneNumber() {
        return this._phoneNumber;
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.isEmpty() || phoneNumber.equals(null);
    }
    public String getEmail(){
        return this._eMail;
    }
    public boolean isEMailValid(String eMail) {
        return eMail.isEmpty() || eMail.equals(null);
    }
}
