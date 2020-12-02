import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new ContactItem("", "", "", "");
        });
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        Assertions.assertDoesNotThrow( () -> new ContactItem("john", "smith", "954-319-2844", ""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        Assertions.assertDoesNotThrow( () -> new ContactItem("", "smith", "954-319-2844", "johnsmith@doc.tar"));
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        Assertions.assertDoesNotThrow( () -> new ContactItem("john", "", "954-319-2844", "johnsmith@doc.tar"));
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        Assertions.assertDoesNotThrow( () -> new ContactItem("john", "smith", "", "johnsmith@doc.tar"));

    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        Assertions.assertDoesNotThrow( () -> new ContactItem("john", "smith", "954-319-2844", "johnsmith@doc.tar"));

    }
    //editingFailsWithAllBlankValues()
    //editingSucceedsWithBlankEmail()
    //editingSucceedsWithBlankFirstName()
    //editingSucceedsWithBlankLastName()
    //editingSucceedsWithBlankPhone()
    //editingSucceedsWithNonBlankValues()
    //testToString()
}
