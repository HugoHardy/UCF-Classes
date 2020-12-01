import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private TaskList TLTest;
    private String listName = "list3";
    List<TaskItem> Tasks;

    @BeforeEach
    public void test() throws FileNotFoundException {
        TLTest = new TaskList();
        Tasks = new ArrayList<>();
    }
    @Test
    public void addingItemsIncreasesSize(){
        TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        assertEquals(2, TLTest.GetListSize());
    }//@Test
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
        TLTest = new TaskList();
        TLTest.ListCreation("templist");
        TLTest.DisplayLists();
        assertEquals( "List is empty", TLTest.EmptyList());
    }
    //@Test
    //public void removingItemsDecreasesSize()
    //@Test
    //public void removingItemsFailsWithInvalidIndex()
    //@Test
    //public void savedTaskListCanBeLoaded()
    //@Test
    //public void uncompletingTaskItemChangesStatus()
    //@Test
    //public void uncompletingTaskItemFailsWithInvalidIndex()
}
