package com.mycompany.app;
import javax.swing.*;

import java.awt.Label;
import java.awt.event.*;
import javax.sql.*;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        JFrame frame = new JFrame("My Student Management App");
        JLabel label = new JLabel("this is a label");
        frame.add(label);
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );
        frame.setVisible(true);
    }
}
