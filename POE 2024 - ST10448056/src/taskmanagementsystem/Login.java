/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagementsystem;

import java.util.Scanner;

public class Login {

    static String firstName;
    static String lastName;
    static String registeredUsername = null;
    static String registeredPassword = null;
    static boolean loggedIn = false;

    private static void setLoggedIn(boolean value) {
        loggedIn = value;
    }

    public static boolean checkUsernameValidity(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username not successfully captured");
            return false;
        }
    }

    public static boolean checkPasswordValidity(String password) {
        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%^&()\\-+=?<>/|`~].*")) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password not successfully captured");
            return false;
        }
    }

    public static void registerNewUser() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        
        boolean isUsernameValid = checkUsernameValidity(username);
        boolean isPasswordValid = checkPasswordValidity(password);

        if (!isUsernameValid) {
            System.out.println("Username is incorrectly formatted.");
        }
        if (!isPasswordValid) {
            System.out.println("Password does not meet the complexity requirements.");
        }
        if (isUsernameValid && isPasswordValid) {
            registeredUsername = username;
            registeredPassword = password;
            setLoggedIn(true);
            System.out.println("Both of the above requirements have been met.");
        }
    }

    public static boolean loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String enteredUser = scanner.nextLine();

        System.out.print("Enter your password: ");
        String enteredPass = scanner.nextLine();
        boolean result = enteredUser.equals(registeredUsername) && enteredPass.equals(registeredPassword);
        setLoggedIn(result);

        return result;
    }

    public static void main(String[] args) {
        registerNewUser();

        while (true) {
            if (loginUser()) {
                System.out.println("Login Successful! Welcome back!");
                break;
            } else {
                System.out.println("Username or password incorrect, please try again.");
            }
        }
    }

    static boolean loginUser(String invalid_user, String invalid_password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void registerNewUser(String test_user, String pssw0rd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
