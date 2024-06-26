/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagementsystem;

import java.util.Scanner;

/**
 *
 * @author misha
 */
public class Register {
    
    private static String firstName;
    private static String lastName;
    private static String userName;
    private static String passWord;

    public static void inputUserInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        System.out.print("Create a username that contains an underscore: ");
        userName = scanner.nextLine();

        System.out.print("Create a password (minimum 8 characters): ");
        passWord = scanner.nextLine();
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static void main(String[] args) {
        inputUserInfo();
        System.out.println("Your registration information:");
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Username: " + getUserName());
        System.out.println("Password: " + getPassWord());
    }
}
    

