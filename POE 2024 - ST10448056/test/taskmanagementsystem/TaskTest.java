/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author misha
 */
public class TaskTest {

    /**
     * Test of inputTaskInfo method, of class Task.
     */
    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");

        //Test for success with valid input
        Task.taskDes = "Create a login to authenticate users";
        String expResult = "Task successfully captured";
        String result = Task.validateTaskDescription();
        assertEquals(expResult, result);

        //Test for failure with invalid input
        Task.taskDes = "This task description is definitely going to be longer than fifty characters.";
        expResult = "Please enter a task description of less than 50 characters";
        result = Task.validateTaskDescription();
        assertEquals(expResult, result);
    }

    @Test
    //Second sample data 
    public void testTaskDescription_2() {
        System.out.println("testTaskDescription_2");

        //Test success with another valid input
        Task.taskDes = "Create Add Task feature to add task users";
        String expResult = "Task successfully captured";
        String result = Task.validateTaskDescription();
        assertEquals(expResult, result);

        // Test failure with another invalid input
        Task.taskDes = "Create Add Task feature to add task users with additional description exceeding the fifty characters limit";
        expResult = "Please enter a task description of less than 50 characters";
        result = Task.validateTaskDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID_1() {
        String taskName = "Login feature";
        int taskNum = 0;
        String devDetails = "Robyn Harison";
        String expResult = "LO:0:SON";
        String result = Task.createTaskID();
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateTaskID_2() {
        String taskName = "Add task feature";
        int taskNum = 1;
        String devDetails = "Mike Smith";
        String expResult = "LO:0:SON";
        String result = Task.createTaskID();
        assertEquals(expResult, result);
    }

    @Test
    public void testTotalTaskDuration() {
        double expResult = 18;
        double result = Task.totalTaskDuration;
        assertEquals(expResult, result);
            
   
    }
        
}
