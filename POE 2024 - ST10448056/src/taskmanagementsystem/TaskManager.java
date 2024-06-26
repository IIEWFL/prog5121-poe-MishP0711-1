package taskmanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author misha
 */
public class TaskManager {

    private static List<Task> tasks = new ArrayList<>();
    private static int nextTaskNumber = 0;
    private static final Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Welcome back to the application");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    register();
                case 2:

                    loginUser();
                case 3:

                    System.out.println("Exiting the application. Goodbye!");
                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    public static void loginUser() {

        if (Login.loggedIn) {
            System.out.println("Login Successful! Welcome back!");
            displayPostloginOptions();
        }
    }

    public static void register() {
        Login.registerNewUser();

    }

    public static void displayPostloginOptions() {
        int postloginChoice;
        do {
            System.out.println("Welcome to easy Kanban:");
            System.out.println("1. Add Tasks");
            System.out.println("2. Show report");
            System.out.println("3. Display tasks with status 'Done'");
            System.out.println("4. Display the task with the longest duration");
            System.out.println("5. Search for a task by name");
            System.out.println("6. Search for tasks by developer");
            System.out.println("7. Delete a task by name");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");
            postloginChoice = scanner.nextInt();

            switch (postloginChoice) {
                case 1:
                    addTask();
                case 2:
                    showReport();
                case 3:
                    displayTasksStatusDone();
                case 4:
                    displayTaskWithLongestDuration();
                case 5:
                    searchTaskByName();
                case 6:
                    searchTasksByDeveloper();
                case 7:
                    deleteTaskByName();
                case 8: {
                    System.out.println("Logging out. Returning to main menu.");
                    return;
                }
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (postloginChoice != 8);
    }

    public static void addTask() {
        System.out.print("Enter the task name: ");
        String taskName = scanner.next();

        int taskNumber = nextTaskNumber++;

        System.out.print("Enter the task description (max 50 characters): ");
        String taskDescription;
        do {
            taskDescription = scanner.next();
            if (taskDescription.length() > 50) {
                System.out.println("Please enter a task description of less than 50 characters.");
            }
        } while (taskDescription.length() > 50);

        System.out.println("Task successfully captured.");

        System.out.print("Enter the developer's first name: ");
        String developerFirstName = scanner.next();
        System.out.print("Enter the developer's last name: ");
        String developerLastName = scanner.next();
        String developerDetails = developerFirstName + " " + developerLastName;

        System.out.print("Enter the task duration in hours: ");
        int taskDuration = scanner.nextInt();

        System.out.print("Enter the task status (To Do, In Progress, Done): ");
        String taskStatus = scanner.next();

        Task newTask = new Task(taskName, taskDescription, developerDetails, taskNumber, taskDuration, taskStatus);

        if (newTask.checkTaskDescription()) {
            tasks.add(newTask);
            System.out.println("Task added successfully:\n" + newTask.printTaskDetails());
        } else {
            System.out.println("Task description is too long.");
        }
    }

    public static void showReport() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks with status 'Done'.");
        } else {

            for (Task task : tasks) {
                if (task.getTaskStatus() != null && task.getTaskStatus().equalsIgnoreCase("Done")) {
                    System.out.println("Developers Name:" + task.getDeveloperName());
                    System.out.println("Task Name:" + task.getTaskName());
                    System.out.println("Duration:" + task.getTaskDuration());
                }

            }
        }
    }

    public static void displayTaskWithLongestDuration() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        Task longestTask = null;
        for (Task task : tasks) {
            if (longestTask == null || task.getTaskDuration() > task.getTaskDuration()) {
                longestTask = task;
            } else {
            }
        }

        if (longestTask != null) {
            System.out.println("Task with Longest Duration:");
            System.out.println("Developer: " + longestTask.getDeveloperName());
            System.out.println("Task Duration: " + longestTask.getTaskDuration() + " hours");
        }
    }

    public static void searchTaskByName() {
        System.out.print("Enter the task name to search: ");
        String taskName = scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                System.out.println("Task Found:");
                System.out.println("Task Name: " + TaskArray.getTaskNames());
                System.out.println("Developer: " + TaskArray.getDeveloperNames());
                System.out.println("Task Status: " + TaskArray.getTaskStatuses());
                return;
            }
        }

        System.out.println("Task not found.");
    }

    public static void searchTasksByDeveloper() {
        System.out.print("Enter the developer's full name to search: ");
        String developerName = scanner.nextLine();

        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            if (task.getDeveloperName().equalsIgnoreCase(developerName)) {
                report.append("Task Name: ").append(TaskArray.getTaskNames())
                        .append("\nTask Status: ").append(TaskArray.getTaskStatuses()).append("\n\n");
            }
        }

        if (report.length() == 0) {
            System.out.println("No tasks found for the developer.");
        } else {
            System.out.println("Tasks for Developer:");
            System.out.println(report.toString());
        }
    }

    public static void deleteTaskByName() {
        System.out.print("Enter the task name to delete: ");
        String taskName = scanner.nextLine();

        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task '" + taskName + "' has been deleted.");
            showReport();
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void displayTasksStatusDone() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

    }
}
