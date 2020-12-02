import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    private TaskList TLTest;
    private String listName = "list3";
    List<TaskItem> Tasks;

    @BeforeEach
    public void test() {
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
    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My 2nd task");
            TLTest.SetEdit(10, data);
        });
    }
    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2022-01-01", "second Task", "My 2nd task");
        TLTest.SetEdit(1, data);
        assertEquals("My 2nd task", data.getTaskDescription());
    }
    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-02-02", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-03-03", "Task 2", "My second task");
        TLTest.SetEdit(1, data);
        assertEquals("2021-03-03", data.getTaskDate());
    }
    @Test
    public void editingItemTitleFailsWithEmptyString(){
        Assertions.assertThrows(IllegalArgumentException.class , () ->{
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "", "My second task");
            TLTest.SetEdit(1, data);
        });
    }
    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class , () ->{
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2nd", "My second task");
            TLTest.SetEdit(10, data);
        });
    }
    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-02-02", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-02-02", "second Task", "My second task");
        TLTest.SetEdit(1, data);
        assertEquals("second Task", data.getTaskName());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){

        Assertions.assertThrows( NumberFormatException.class ,() -> {
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("03-2022-03", "third Task", "My 3rd task");
            TLTest.SetEdit(1, data);
        });
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        Assertions.assertThrows( IndexOutOfBoundsException.class ,() -> {
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2022-03-03", "My second task", "Task 2");
            TLTest.SetEdit(3, data);
        });
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        Assertions.assertThrows( NumberFormatException.class ,() -> {
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            data = new TaskItem("202-03-03", "third Task", "My 3rd task");
            TLTest.SetEdit(1, data);
        });
    }
    @Test
    public void EnteringNonExistanceFileThrowsException(){
        assertThrows(FileNotFoundException.class, ()-> {
            TLTest.DataSetter("t");
        });
    }
    //@Test
    //public void gettingItemDescriptionFailsWithInvalidIndex()
    //@Test
    //public void gettingItemDescriptionSucceedsWithValidIndex(){
    //    TLTest = new TaskList();
    //    TaskItem data = null;
    //    data = new TaskItem("2020-01-01", "Task 1", "My First task");
    //    TLTest.AddTaskData(data);
    //    data = new TaskItem("2021-02-02", "Task 2", "My second task");
    //    TLTest.AddTaskData(data);
    //    Assertions.assertEquals("My second task", TLTest.get(1));
    //}
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
    @Test
    public void removingItemsDecreasesSize(){
        TLTest = new TaskList();
        TaskItem data = null;
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        TLTest.RemoveTaskData(1);
        assertEquals(1, TLTest.GetListSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        Assertions.assertThrows( IndexOutOfBoundsException.class ,() -> {
            TLTest = new TaskList();
            TaskItem data = null;
            data = new TaskItem("2020-01-01", "Task 1", "My First task");
            TLTest.AddTaskData(data);
            data = new TaskItem("2021-02-02", "Task 2", "My second task");
            TLTest.AddTaskData(data);
            TLTest.RemoveTaskData(5);
        });
    }
    @Test
    public void savedTaskListCanBeLoaded() throws FileNotFoundException {
        TaskItem data;
        TLTest.ListCreation("templist");
        data = new TaskItem("2020-01-01", "Task 1", "My First task");
        TLTest.AddTaskData(data);
        data = new TaskItem("2021-01-01", "Task 2", "My second task");
        TLTest.AddTaskData(data);
        TLTest = new TaskList();
        TLTest.WriteToList("templist");

        assertDoesNotThrow(()-> TLTest.DataSetter(listName));
    }
    //@Test
    //public void uncompletingTaskItemChangesStatus()
    //@Test
    //public void uncompletingTaskItemFailsWithInvalidIndex()
}
