public class TaskItem {
    //localBackup;
    private String taskName;
    private String taskDescription;
    private String date;

    public TaskItem(String date, String title, String description) {

        if (isTaskNameValid(title)) {
            this.taskName = title;
        } else {
            new IllegalArgumentException("task name is invalid, please enter a new task name");

        }
        if (isTaskDescriptionValid(description)) {
            this.taskDescription = description;
        } else {
            new IllegalArgumentException("Description invalid, please enter a new description");
        }

        if (isDateValid(date)) {
            this.date = date;
        } else {
            new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
        }

    }

    public String getTaskName() {
        return this.taskName;
    }
    private boolean isTaskNameValid(String name){
        return name.length() > 0;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }
    public boolean isTaskDescriptionValid(String description){
        return description.length() > 0;
    }

    public String getTaskDate() {

        return this.date;
    }
    public boolean isDateValid(String date){
        return true;// needs to work on date verification
    }
}