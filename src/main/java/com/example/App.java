package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Details Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        
        JLabel classLabel = new JLabel("Class:");
        JTextField classField = new JTextField();
        
        JLabel regNoLabel = new JLabel("Reg No:");
        JTextField regNoField = new JTextField();
        
        JLabel deptLabel = new JLabel("Department:");
        JTextField deptField = new JTextField();
        
        JButton submitButton = new JButton("Submit");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(classLabel);
        frame.add(classField);
        frame.add(regNoLabel);
        frame.add(regNoField);
        frame.add(deptLabel);
        frame.add(deptField);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String studentClass = classField.getText();
                String regNo = regNoField.getText();
                String department = deptField.getText();

                System.out.println("Student Details:");
                System.out.println("Name: " + name);
                System.out.println("Class: " + studentClass);
                System.out.println("Reg No: " + regNo);
                System.out.println("Department: " + department);
                
                JOptionPane.showMessageDialog(frame, "Details Submitted Successfully!");
            }
        });

        frame.setVisible(true);
    }
}
