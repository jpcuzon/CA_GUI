/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonpaulcarlo
 */
public class View extends JFrame
{
    Controller controller;
    
    public View(Controller controller)
    {
        this.controller = controller;
        // We encapsulated the building process of the window
        login();
        
    }
    
    
    
    JFrame login;
    JFrame Register;
    
    JTextField userEmail;
    JTextField userPassword;
    
    JComboBox userBoxLog;
    
    //log in page
    public void login()
    {
        login = new JFrame("Barberoo | | Log-in");
        login.setVisible(true);
        login.setSize(500, 700);
        
        BorderLayout loginL = new BorderLayout();
        login.setLayout(loginL);
        
        JPanel logoPanel = new JPanel();
        login.add(logoPanel, BorderLayout.PAGE_START);
            JLabel logoLabel = new JLabel("JP's Barber");
            logoLabel.setFont(new Font("Courier", Font.BOLD,40)); //sets the font size
            logoLabel.setBorder(new EmptyBorder(50,0,70,0)); //adds a padding around the label
            logoPanel.add(logoLabel);
        
            //main body
        JPanel body = new JPanel();
        body.setBorder(new EmptyBorder(20,0,0,0));
        login.add(body, BorderLayout.CENTER);

            //for the panel that contains the input field
            GridLayout inputBox = new GridLayout(2,2);
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(inputBox);
            body.add(inputPanel);

                JLabel putEmail = new JLabel("Email: ");
                userEmail = new JTextField(20);
                inputPanel.add(putEmail);
                inputPanel.add(userEmail);

                JLabel putPass = new JLabel("Password: ");
                userPassword = new JTextField(20);
                inputPanel.add(putPass);
                inputPanel.add(userPassword);

            //for the panel that contains the drop-down button
            JPanel logButtons = new JPanel();
            body.add(logButtons);
                String[] userType =  {"Select User Type","Customer", "Barber"};
                userBoxLog = new JComboBox(userType);
                //userBox.addActionListener(this);temp
                logButtons.add(userBoxLog);
                JButton submit = new JButton("Log-in");
                submit.addActionListener(controller); //login
                submit.setActionCommand("submit");
                logButtons.add(submit);

            //panel that contains the registration page
            GridLayout regInsL = new GridLayout(2,1);
            JPanel regIns = new JPanel();
            regIns.setBorder(new EmptyBorder(30,30,30,30));
            regIns.setLayout(regInsL);
            login.add(regIns, BorderLayout.PAGE_END);

                JLabel needAcc = new JLabel("Need an account?");//change
                regIns.add(needAcc);
                JButton goRegister = new JButton("Register");
                goRegister.addActionListener(controller); //opens the register window
                goRegister.setActionCommand("goRegister");
                regIns.add(goRegister);

        
        
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.validate();
        login.repaint();
        
        
    }
    
    String uType;
    boolean visible;
    JComboBox userBoxReg;
    JComboBox locList;
    JLabel putLoc;
    
    JTextField fName;
    JTextField lName;
    JTextField pNumber;
    JTextField email;
    JTextField password;
    public void Register()
    {
        Register = new JFrame("Barberoo | | Register");
        Register.setVisible(true);
        Register.setSize(500,700);
        
        BorderLayout cusRegisterL = new BorderLayout();
        Register.setLayout(cusRegisterL);
        
        JPanel logoPanel = new JPanel();
        JLabel logoLabel = new JLabel("Barberoo");
        logoLabel.setFont(new Font("Courier", Font.BOLD,40)); //sets the font size
        logoLabel.setBorder(new EmptyBorder(25,0,25,0)); //adds a padding around the label
        logoPanel.add(logoLabel);
        Register.add(logoPanel, BorderLayout.PAGE_START);
        
        //main body
        JPanel body = new JPanel();
        Register.add(body, BorderLayout.CENTER);
        
        //GridLayout uSelectL = new GridLayout(2,1);
            JPanel userSelect = new JPanel();
            //userSelect.setLayout(uSelectL);
            body.add(userSelect);
                JLabel regAs = new JLabel("Register As:");
                userSelect.add(regAs);
                String[] userType = {"Select User Type","Customer","Barber"};
                userBoxReg = new JComboBox(userType);
                userBoxReg.addActionListener(controller);
                userBoxReg.setActionCommand("hide");
                //userBox.setSelectedIndex(0);
                userBoxReg.addActionListener(controller);
                userSelect.add(userBoxReg);
        
            GridLayout inputBox = new GridLayout(7,1);
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(inputBox);
            body.add(inputPanel);
                //first name
                JLabel putfName = new JLabel("First Name: ");
                fName = new JTextField(20);
                inputPanel.add(putfName);
                inputPanel.add(fName);
                //last name
                JLabel putlName = new JLabel("Last Name: ");
                lName = new JTextField(20);
                inputPanel.add(putlName);
                inputPanel.add(lName);
                //phone number
                JLabel putpNumber = new JLabel("Phone Number: ");
                pNumber = new JTextField(20);
                inputPanel.add(putpNumber);
                inputPanel.add(pNumber);
                //email
                JLabel putEmail = new JLabel("Email: ");
                email = new JTextField(20);
                inputPanel.add(putEmail);
                inputPanel.add(email);

                //password
                JLabel putPass = new JLabel("Password: ");
                password = new JTextField(20);
                inputPanel.add(putPass);
                inputPanel.add(password);
                //confirm password
                JLabel putPass2 = new JLabel("Confirm Password: ");
                JTextField password2 = new JTextField(20);
                inputPanel.add(putPass2);
                inputPanel.add(password2);
                putLoc = new JLabel("Location: ");
                String[] locations = {"Dublin 7","Dublin 8"};
                locList = new JComboBox(locations);
                inputPanel.add(putLoc);
                inputPanel.add(locList);
                locList.setVisible(visible);
                putLoc.setVisible(visible);

            JButton register = new JButton("Register");
            register.addActionListener(controller); //opens the register window
            register.setActionCommand("register");
            body.add(register);
        
        //panel that contains the buttons to go back to log-in page
            GridLayout regInsL = new GridLayout(2,1);
            JPanel regIns = new JPanel();
                regIns.setBorder(new EmptyBorder(30,30,30,30));
                regIns.setLayout(regInsL);
                Register.add(regIns, BorderLayout.PAGE_END);

                JLabel haveAcc = new JLabel("Already have an account?");//change
                regIns.add(haveAcc);
                JButton goLogin = new JButton("Log-in");
                goLogin.addActionListener(controller); //opens the register window
                goLogin.setActionCommand("goLogin");
                regIns.add(goLogin);
        
        
        
        
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.validate();
        Register.repaint();
        
    }
    
    JFrame cusHome;
    public void custHome()
    {
        cusHome = new JFrame("Barberoo | | Dashboard");
        cusHome.setVisible(true);
        cusHome.setSize(1000, 700);
        
        BorderLayout cusHomeL = new BorderLayout();
        cusHome.setLayout(cusHomeL);
        
        //GridLayout headerL = new GridLayout(2,1);
        JPanel header = new JPanel();
        //header.setLayout(headerL);
        cusHome.add(header, BorderLayout.PAGE_START);
            //for the header
            GridLayout subHeaderL = new GridLayout(1,2);
            JPanel subHeader = new JPanel();
            subHeader.setLayout(subHeaderL);
            header.add(subHeader);
                JPanel logo = new JPanel();
                subHeader.add(logo);
                    JLabel logoLabel = new JLabel("Barberoo");
                    logo.add(logoLabel);
                    logoLabel.setFont(new Font("Courier", Font.BOLD,20)); //sets the font size
                    logoLabel.setBorder(new EmptyBorder(25,0,35,0)); //adds a padding around the label
                JPanel rightAlign = new JPanel();
                FlowLayout rightAlignL = new FlowLayout();
                rightAlign.setLayout(rightAlignL);
                rightAlignL.setAlignment(FlowLayout.RIGHT);
                subHeader.add(rightAlign);
                    GridLayout rightHeaderL = new GridLayout(2,1);
                    JPanel rightHeader = new JPanel();
                    rightHeader.setLayout(rightHeaderL);
                    rightAlign.add(rightHeader);
                            JPanel welcomeMessage = new JPanel();//note: allign to the right
                            rightHeader.add(welcomeMessage);
                                JLabel welcome = new JLabel("Welcome!");
                                welcomeMessage.add(welcome);
                            JPanel logoutButton = new JPanel(); //note: allign to the right
                            rightHeader.add(logoutButton);
                                JButton logout = new JButton("Logout");
                                logoutButton.add(logout);
                                logout.addActionListener(controller);
                                logout.setActionCommand("logoutCus");            
        
        JPanel body = new JPanel();
        cusHome.add(body, BorderLayout.CENTER);

            
        
        
//        //main body
//        JPanel body = new JPanel();
//        body.setBorder(new EmptyBorder(20,0,0,0));
//        this.add(body, BorderLayout.CENTER);
//        //for the panel that contains the input field
//        GridLayout inputBox = new GridLayout(3,2);
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(inputBox);
//        body.add(inputPanel);
//        
//        JLabel putEmail = new JLabel("Email: ");
//        JTextField email = new JTextField(20);
//        inputPanel.add(putEmail);
//        inputPanel.add(email);
//        
//        JLabel putPass = new JLabel("Password: ");
//        JTextField password = new JTextField(20);
//        inputPanel.add(putPass);
//        inputPanel.add(password);
//        //for the panel that contains the drop-down button
//        JPanel logButtons = new JPanel();
//        body.add(logButtons);
//        String[] userType =  {"Select User Type","Customer", "Barber"};
//        userBox = new JComboBox(userType);
//        userBox.addActionListener(this);
//        userBox.setActionCommand("comboBox");
//        userBox.setAlignmentX(LEFT_ALIGNMENT);
//        logButtons.add(userBox);
//        JButton submit = new JButton("Log-in");
//        logButtons.add(submit);
//        
//        //panel that contains the registration page
//        GridLayout regInsL = new GridLayout(2,1);
//        JPanel regIns = new JPanel();
//        regIns.setBorder(new EmptyBorder(30,30,30,30));
//        regIns.setLayout(regInsL);
//        this.add(regIns, BorderLayout.PAGE_END);
//        
//        JLabel needAcc = new JLabel("Need an account?");//change
//        regIns.add(needAcc);
//        JButton goRegister = new JButton("Register");
//        regIns.add(goRegister);

        
        cusHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        cusHome.validate();
        cusHome.repaint();

    }
    
    
}
