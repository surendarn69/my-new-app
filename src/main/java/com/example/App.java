package com.example;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WELCOME =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to register a new user
    private static void registerUser(Scanner scanner) {
        System.out.println("\n===== REGISTER =====");

        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm your password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("\nError: Passwords do not match. Please try again.");
            return;
        }

        if (users.containsKey(email)) {
            System.out.println("\nError: Email is already registered. Try logging in.");
            return;
        }

        users.put(email, new User(name, username, email, phone, password));
        System.out.println("\n✅ Registration successful! You can now log in.");
    }

    // Method to log in a user
    private static void loginUser(Scanner scanner) {
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            User user = users.get(email);
            showUserPopup(user);
        } else {
            System.out.println("\n❌ Invalid email or password. Please try again.");
        }
    }

    // Method to display user details in a pop-up
    private static void showUserPopup(User user) {
        String message = "✅ Login Successful!\n"
                + "Name: " + user.getName() + "\n"
                + "Username: " + user.getUsername() + "\n"
                + "Email: " + user.getEmail() + "\n"
                + "Phone: " + user.getPhone();

        JOptionPane.showMessageDialog(null, message, "User Details", JOptionPane.INFORMATION_MESSAGE);
    }
}

// User class to store user details
class User {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;

    public User(String name, String username, String email, String phone, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
}
