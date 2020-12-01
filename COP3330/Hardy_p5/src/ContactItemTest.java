import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        Assertions.assertThrows(NullPointerException.class, ()-> {
            new ContactItem("", "", "", "").IsAllEmpty();
        });
    }
    //@Test
    //public void creationSucceedsWithBlankEmail(){
    //    Assertions.assertDoesNotThrow( () -> new ContactItem("john", "smith", "9543192844", ""));
    //}
    //creationSucceedsWithBlankFirstName()
    //creationSucceedsWithBlankLastName()
    //creationSucceedsWithBlankPhone()
    //creationSucceedsWithNonBlankValues()
    //editingFailsWithAllBlankValues()
    //editingSucceedsWithBlankEmail()
    //editingSucceedsWithBlankFirstName()
    //editingSucceedsWithBlankLastName()
    //editingSucceedsWithBlankPhone()
    //editingSucceedsWithNonBlankValues()
    //testToString()
}
