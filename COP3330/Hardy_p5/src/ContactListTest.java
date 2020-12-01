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
    public void test() throws FileNotFoundException {
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
    //@Test
    //completingTaskItemChangesStatus()
    //@Test
    //completingTaskItemFailsWithInvalidIndex()
    //@Test
    //public void editingItemDescriptionFailsWithInvalidIndex(){
    /*@Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        //TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddContactData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TLTest.AddContactData(data);
        data = new TaskItem("2020-01-01", "second Task", "My 2nd task");
        TLTest.SetEdit(1, data);
        assertEquals("[2020-01-01] second Task: My 2nd task", TLTest.GetTaskData(1));
    }*/
    //@Test
    //public void editingItemDueDateSucceedsWithExpectedValue()
    //@Test
    //public void editingItemTitleFailsWithEmptyString()
    //@Test
    //public void editingItemTitleFailsWithInvalidIndex()
    //@Test
    //public void editingItemTitleSucceedsWithExpectedValue()
    //@Test
    //public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    //@Test
    //public void editingTaskItemDueDateFailsWithInvalidIndex()
    //@Test
    //public void editingTaskItemDueDateFailsWithInvalidYYYMMDD()
    //@Test
    //public void gettingItemDescriptionFailsWithInvalidIndex()
    //@Test
    //public void gettingItemDescriptionSucceedsWithValidIndex()
    //@Test
    //public void gettingItemDueDateFailsWithInvalidIndex()
    //@Test
    //public void gettingItemDueDateSucceedsWithValidIndex()
    //@Test
    //public void gettingItemTitleFailsWithInvalidIndex()
    //@Test
    //public void gettingItemTitleSucceedsWithValidIndex()
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
        CLTest.RemoveTaskData(1);
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
            CLTest.RemoveTaskData(1);
        });
    }
    //@Test
    //public void savedTaskListCanBeLoaded()
    //@Test
    //public void uncompletingTaskItemChangesStatus()
    //@Test
    //public void uncompletingTaskItemFailsWithInvalidIndex()
}
