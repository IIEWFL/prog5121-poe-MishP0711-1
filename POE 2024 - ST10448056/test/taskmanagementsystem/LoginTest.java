/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagementsystem;

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
public class LoginTest {

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        //Test data: "kyl_1"
        Registration.uName = "kyl_1";
        boolean expResultValid = true;
        boolean resultValid = Task.checkUserName();
        assertEquals(expResultValid, resultValid);

        //Test data: "kyle!!!!!!!"
        Registration.uName = "kyle!!!!!!!";
        boolean expResultInvalid = false;
        boolean resultInvalid = Task.checkUserName();
        assertEquals(expResultInvalid, resultInvalid);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        //Test data: "Ch&&sec@ke99!"
        Registration.pWord = "Ch&&sec@ke99!";
        boolean expResultValid = true;
        boolean resultValid = Task.checkPasswordComplexity();
        assertEquals(expResultValid, resultValid);

        //Test data: "password"
        Registration.pWord = "password";
        boolean expResultInValid = false;
        boolean resultInvalid = Task.checkPasswordComplexity();
        assertEquals(expResultInValid, resultInvalid);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String expResult = "";
        String result = Task.registerNewUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLogin method, of class Login.
     */
    @Test
    public void testUserLogin() {
        System.out.println("userLogin");
        boolean expResult = false;
        boolean result = Task.userLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String expResult = "";
        String result = Task.returnLoginStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype."); 
    }
}
