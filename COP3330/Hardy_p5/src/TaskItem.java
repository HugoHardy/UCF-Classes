public class TaskItem {
    //localBackup;
    private String taskName;
    private String taskDescription;
    private String date;

    public TaskItem(String date, String title, String description) {
        try {
            if (isDateValid(date)) {
                throw new IllegalArgumentException("Date invalid, please enter a new date (YYYY-MM-DD): ");
            } else {
                this.date = date;
            }
            if (isTaskNameValid(title)) {
                this.taskName = title;
            } else {
                throw new IllegalArgumentException("task name is invalid, please enter a new task name");

            }
            if (isTaskDescriptionValid(description)) {
                this.taskDescription = description;
            } else {
                throw new IllegalArgumentException("Description invalid, please enter a new description");
            }
        } catch (NullPointerException e) {
            e.getCause();
        }
    }

    public String getTaskDate() {

        return this.date;
    }

    public boolean isDateValid(String date) {
        return !date.isEmpty() && !date.equals(" ");// needs to work on date verification
    }

    public String getTaskName() {
        return this.taskName;
    }

    public static boolean isTaskNameValid(String name) {
        return !name.isEmpty() && !name.equals(" ");
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public boolean isTaskDescriptionValid(String description) {
        return !description.isEmpty() && !description.equals(" ");
    }


}