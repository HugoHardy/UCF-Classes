public class TaskItem {
    //localBackup;
    private String taskName;
    private String taskDescription;
    private String date;

    public TaskItem(String title, String description, String date) {

        if (true) { //isTaskNameValid(title)
            this.taskName = title;
        } else {
            new IllegalArgumentException("task name is invalid, please enter a new task name");

        }
        if (true) { //isTaskDescriptionValid(description)
            this.taskDescription = description;
        } else {
            new IllegalArgumentException("Description invalid, please enter a new description");
        }

        if (true) { //isDateValid(date)
            this.date = date;
        } else {
            new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        }

    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public String getTaskDate() {

        return this.date;
    }
}