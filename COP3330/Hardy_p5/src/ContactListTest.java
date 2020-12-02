import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactListTest {
    private ContactList CLTest;
    private String listName = "list3";
    List<ContactItem> Contacts;

    @BeforeEach
    public void test() {
        CLTest = new ContactList();
        Contacts = new ArrayList<>();
    }
    @Test
    public void addingItemsIncreasesSize(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertEquals(2, CLTest.GetListSize());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){
        Assertions.assertThrows(IllegalArgumentException.class , () ->{
            ContactItem data;
            data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
            CLTest.AddContactData(data);
            data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
            CLTest.AddContactData(data);
            data = new ContactItem("", "", "", "");
            CLTest.SetEdit(1, data);
        });
    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            ContactItem data;
            data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
            CLTest.AddContactData(data);
            data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
            CLTest.AddContactData(data);
            data = new ContactItem("jim", "iny", "951-592-4658", "jiminy@pie.edu");
            CLTest.SetEdit(2, data);
        });
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertDoesNotThrow(()->CLTest.SetEdit(1, new ContactItem("", "iny", "951-592-4658", "jiminy@pie.edu")));
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertDoesNotThrow(()->CLTest.SetEdit(1, new ContactItem("Jim", "", "951-592-4658", "jiminy@pie.edu")));
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertDoesNotThrow(()->CLTest.SetEdit(1, new ContactItem("Jim", "iny", "", "jiminy@pie.edu")));
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertDoesNotThrow(()->CLTest.SetEdit(1, new ContactItem("Jim", "iny", "951-592-4658", "jiminy@pie.edu")));
    }
    @Test
    public void newListIsEmpty() throws FileNotFoundException {
        CLTest.ListCreation(listName);
        CLTest.DisplayLists();
        assertEquals( "List is empty", CLTest.EmptyList());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        CLTest.RemoveContactData(1);
        assertEquals(1, CLTest.GetListSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            CLTest.RemoveContactData(9);
        });
    }
    @Test
    public void savedContactListCanBeLoaded() throws FileNotFoundException {
        ContactItem data;
        CLTest.ListCreation(listName);
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        CLTest.WriteToList(listName);
        Assertions.assertDoesNotThrow( () -> CLTest.DataSetter(listName));
    }
}
