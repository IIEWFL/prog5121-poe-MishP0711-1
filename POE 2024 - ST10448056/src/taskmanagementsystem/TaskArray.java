/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Mishayl
 */
public class TaskArray {

    private static ArrayList<String> devName = new ArrayList<>();
    private static ArrayList<String> tasName = new ArrayList<>();
    private static ArrayList<String> tasDescription = new ArrayList<>();
    private static ArrayList<String> tasDuration = new ArrayList<>();
    private static ArrayList<String> tasID = new ArrayList<>();
    private static ArrayList<String> tasStatus = new ArrayList<>();

    // The Method will allow to add all information into the array lists
    public static void addDevelopersName(String developerName) {
        devName.add(developerName);
    }

    public static void addTaskName(String taskName) {
        tasName.add(taskName);
    }

    public static void AddTaskID(String taskID) {
        tasID.add(taskID);
    }

    public static void addTaskDuration(String taskDuration) {
        tasDuration.add(taskDuration);

    }

    public static void addTaskStatus(String taskStatus) {
        tasStatus.add(taskStatus);

    }

    // Getter methods to return all information and convert the array lists into a
    // regular array
    public static String[] getDeveloperNames() {
        return devName.toArray(new String[0]);
    }

    public static String[] getTaskNames() {
        return tasName.toArray(new String[0]);
    }

    public static String[] getTaskIDs() {
        return tasID.toArray(new String[0]);
    }

    public static Double[] getTaskDurations() {
        return tasDuration.toArray(new Double[0]);
    }

    public static String[] getTaskStatuses() {
        return tasStatus.toArray(new String[0]);
    }

    TaskArray(String taskName, String taskDescription, String developerDetails, int taskNumber, int taskDuration, String taskStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
