import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
        CLTest = new ContactList();
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        assertEquals(2, CLTest.GetListSize());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){
        Assertions.assertThrows(NullPointerException.class , () ->{
            CLTest = new ContactList();
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
            CLTest = new ContactList();
            ContactItem data;
            data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
            CLTest.AddContactData(data);
            data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
            CLTest.AddContactData(data);
            data = new ContactItem("jim", "iny", "951-592-4658", "jiminy@pie.edu");
            CLTest.SetEdit(2, data);
        });
    }
    //editingSucceedsWithBlankFirstName()
    //editingSucceedsWithBlankLastName()
    //editingSucceedsWithBlankPhone()
    //editingSucceedsWithNonBlankValues()
    @Test
    public void newListIsEmpty() throws FileNotFoundException {
        CLTest = new ContactList();
        CLTest.ListCreation(listName);
        CLTest.DisplayLists();
        assertEquals( "List is empty", CLTest.EmptyList());
    }
    @Test
    public void removingItemsDecreasesSize(){
        CLTest = new ContactList();
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
        CLTest = new ContactList();
        ContactItem data;
        data = new ContactItem("John", "Deo", "555-123-1234", "unknown@cia.gov");
        CLTest.AddContactData(data);
        data = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        CLTest.AddContactData(data);
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            CLTest.RemoveContactData(9);
        });
    }
    //savedContactListCanBeLoaded()
}
