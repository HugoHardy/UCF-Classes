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
                throw new IllegalArgumentException("task name is invalid, please enter a new task name: ");

            } else {
                this.taskName = title;
            }
            if (isTaskDescriptionValid(description)) {
                throw new IllegalArgumentException("Description invalid, please enter a new description: ");
            } else {
                this.taskDescription = description;
            }
        } catch (NullPointerException e) {
            e.getCause();
        }
    }

    public String getTaskDate() {

        return this.date;
    }

    public static boolean isDateValid(String date) {
        //yyyy-mm-dd
        //0123456789
        try {
            if (!(date.isEmpty() || date.equals(" ") || date.equals(null))) {
                int year = Integer.parseInt(date.substring(0, 4));
                int month = Integer.parseInt(date.substring(5, 7));
                int day = Integer.parseInt(date.substring(8));

                if (year <= 9999 || year >= 1000 || month <= 12 || month >= 1 || day <= 31 || day >= 1) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("ERROR: Date format invalid, enter yyyy-MM-dd format: ");
        }
        return false;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public static boolean isTaskNameValid(String name) {
        return name.isEmpty() || name.equals(" ") || name.equals(null);
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public boolean isTaskDescriptionValid(String description) {
        return description.isEmpty() || description.equals(" ") || description.equals(null);
    }


}