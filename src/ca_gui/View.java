/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
            JPanel inputPanel = new JPanel(new GridLayout(2,2));
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
            JPanel regIns = new JPanel(new GridLayout(2,1));
            login.add(regIns, BorderLayout.PAGE_END);
            regIns.setBorder(new EmptyBorder(30,30,30,30));

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
    
    JLabel testLabel;
    
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
    JTextField confirmPass;
    
    public void Register()
    {
        Register = new JFrame("Barberoo | | Register");
        Register.setVisible(true);
        Register.setSize(500,700);
        
        BorderLayout cusRegisterL = new BorderLayout();
        Register.setLayout(cusRegisterL);
        
        JPanel logoPanel = new JPanel();
        Register.add(logoPanel, BorderLayout.PAGE_START);
            JLabel logoLabel = new JLabel("Barberoo");
            logoLabel.setFont(new Font("Courier", Font.BOLD,40)); //sets the font size
            logoLabel.setBorder(new EmptyBorder(25,0,25,0)); //adds a padding around the label
            logoPanel.add(logoLabel);
        
        //main body
        JPanel body = new JPanel();
        Register.add(body, BorderLayout.CENTER);
       
            JPanel userSelect = new JPanel();
            body.add(userSelect);
                JLabel regAs = new JLabel("Register As:");
                userSelect.add(regAs);
                String[] userType = {"Select User Type","Customer","Barber"};
                userBoxReg = new JComboBox(userType);
                userBoxReg.addActionListener(controller);
                userBoxReg.setActionCommand("hide");
                //userBox.setSelectedIndex(0);
                userSelect.add(userBoxReg);
        
            JPanel inputPanel = new JPanel(new GridLayout(8,1,5,5));
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
                confirmPass = new JTextField(20);
                inputPanel.add(putPass2);
                inputPanel.add(confirmPass);
                putLoc = new JLabel("Location: ");
                String[] locations = {"Dublin 1","Dublin 2","Kildare, Kildare","Newbridge, Kildare","Cork","Belfast","Dublin 7","Dublin 8"};
                locList = new JComboBox(locations);
                inputPanel.add(putLoc);
                inputPanel.add(locList);
                locList.setVisible(visible); //label for location
                putLoc.setVisible(visible);  //textfield for location

            JButton register = new JButton("Register");
            body.add(register);
            register.addActionListener(controller); //opens the register window
            register.setActionCommand("register");
        
        //panel that contains the buttons to go back to log-in page
            JPanel regIns = new JPanel(new GridLayout(2,1));
            Register.add(regIns, BorderLayout.PAGE_END);
            regIns.setBorder(new EmptyBorder(30,30,30,30));

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
    String complaint;
    JTextField searchField;
    JComboBox comboBoxSearch;
    public void custHome()
    {
//        dbFetch dbfetch = new dbFetch();
//        String fullname = dbfetch.fetchFullName();
        
        cusHome = new JFrame("Barberoo | | Dashboard");
        cusHome.setVisible(true);
        cusHome.setSize(600, 700);
        
        BorderLayout cusHomeL = new BorderLayout();
        cusHome.setLayout(cusHomeL);
        
        JPanel header = new JPanel();
        cusHome.add(header, BorderLayout.PAGE_START);
            //for the header
            JPanel subHeader = new JPanel(new GridLayout(1,2));
            header.add(subHeader);
            
                JPanel logo = new JPanel();
                subHeader.add(logo);
                    JLabel logoLabel = new JLabel("Barberoo");
                    logo.add(logoLabel);
                    logoLabel.setFont(new Font("Courier", Font.BOLD,40)); //sets the font size
                    logoLabel.setBorder(new EmptyBorder(25,50,35,0)); //adds a padding around the label
                JPanel rightAlign = new JPanel();
                subHeader.add(rightAlign);
                    JPanel rightAlignHeader = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                    rightAlign.add(rightAlignHeader);
                    JPanel rightHeader = new JPanel(new GridLayout(2,1));
                    rightAlignHeader.add(rightHeader);
                            JPanel welcomeMessage = new JPanel();//note: allign to the right
                            rightHeader.add(welcomeMessage);
                                JLabel welcome = new JLabel("Welcome, Jon Paul!");
                                welcomeMessage.add(welcome);
                                welcome.setFont(new Font("Courier", Font.BOLD,15));
                            JPanel logoutButton = new JPanel(); //note: allign to the right
                            rightHeader.add(logoutButton);
                                JButton logout = new JButton("Logout");
                                logoutButton.add(logout);
                                logout.addActionListener(controller);
                                logout.setActionCommand("logoutCus");            
        
        JPanel body = new JPanel(new BorderLayout());
        cusHome.add(body, BorderLayout.CENTER);
            JPanel search = new JPanel();
            body.add(search, BorderLayout.PAGE_START);
                searchField = new JTextField("", 28);
                search.add(searchField);
                JPanel comboBoxSearchP = new JPanel();
                search.add(comboBoxSearchP);
                    String[] searchSelect = {"Name", "Location"};
                    comboBoxSearch = new JComboBox(searchSelect);
                    comboBoxSearchP.add(comboBoxSearch);
                JPanel searchButtonP = new JPanel();
                search.add(searchButtonP);
                    JButton searchButton = new JButton("Search");
                    searchButtonP.add(searchButton);
                    searchButton.addActionListener(controller);
                    searchButton.setActionCommand("searchBarber");
                    
            JPanel dashboardP = new JPanel(new BorderLayout());
            body.add(dashboardP, BorderLayout.CENTER);
                JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                dashboardP.add(labelP, BorderLayout.PAGE_START);
                    JPanel bookingLabelRight = new JPanel();
                    labelP.add(bookingLabelRight);
                        JLabel bookingLabel = new JLabel("MY BOOKINGS");
                        bookingLabelRight.add(bookingLabel);
                        bookingLabel.setBorder(new EmptyBorder(0,33,0,0));
                        bookingLabel.setFont(new Font("Courier", Font.BOLD,20));
            
//                JPanel bookingAreaP = new JPanel(new GridLayout(2,1));//temporary grid layout
//                dashboardP.add(bookingAreaP, BorderLayout.CENTER);
                    JPanel bookingContainer1 = new JPanel();
                    dashboardP.add(bookingContainer1);
                    
                        JPanel booking1P = new JPanel(new GridLayout(3,2,5,5));
                        bookingContainer1.add(booking1P);
                        booking1P.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
//                        booking1P.setVisible(true);
                            JPanel label1P = new JPanel(new GridLayout(1,1));
                            booking1P.add(label1P);
                            label1P.setBorder(new EmptyBorder(10,15,0,100));
                                JLabel time1 = new JLabel("11:30, Monday");
                                label1P.add(time1);
                            JPanel button1P = new JPanel(new GridLayout(1,1));
                            booking1P.add(button1P);
                            button1P.setBorder(new EmptyBorder(10,100,0,15));
                                JButton cancel1 = new JButton("Cancel");
                                button1P.add(cancel1);
                            JPanel label2P = new JPanel(new GridLayout(1,1));
                            booking1P.add(label2P);
                            label2P.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel service1 = new JLabel("Haircut, Confirmed");
                                label2P.add(service1);
                            JPanel button2P = new JPanel(new GridLayout(1,1));
                            booking1P.add(button2P);  
                            button2P.setBorder(new EmptyBorder(0,100,0,15));
                                JButton placeComplaint1 = new JButton("Place Complaint");
                                button2P.add(placeComplaint1);
                                placeComplaint1.addActionListener(controller);
                                placeComplaint1.setActionCommand("complaint");
                            JPanel label3P = new JPanel(new GridLayout(1,1));
                            booking1P.add(label3P);
                            label3P.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberName1 = new JLabel("Tony Stark, Dublin 7");
                                label3P.add(barberName1);
                            JPanel button3P = new JPanel(new GridLayout(1,1));
                            booking1P.add(button3P);  
                            button3P.setBorder(new EmptyBorder(0,100,10,15));
                                JButton viewBarber1 = new JButton("View Barber");
                                button3P.add(viewBarber1);
                                
                        JPanel booking2P = new JPanel(new GridLayout(3,2,5,5));
                        bookingContainer1.add(booking2P);
                        booking2P.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
                            JPanel label1Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(label1Pb);
                            label1Pb.setBorder(new EmptyBorder(10,15,0,100));
                                JLabel time1b = new JLabel("2:00, Tuesday");
                                label1Pb.add(time1b);
                            JPanel button1Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(button1Pb);
                            button1Pb.setBorder(new EmptyBorder(10,100,0,15));
                                JButton cancel1b = new JButton("Cancel");
                                button1Pb.add(cancel1b);    
                            JPanel label2Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(label2Pb);
                            label2Pb.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel service1b = new JLabel("Shave, Pending");
                                label2Pb.add(service1b);
                            JPanel button2Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(button2Pb);  
                            button2Pb.setBorder(new EmptyBorder(0,100,0,15));
                                JButton placeComplaint1b = new JButton("Place Complaint");
                                button2Pb.add(placeComplaint1b);    
                            JPanel label3Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(label3Pb);
                            label3Pb.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberName1b = new JLabel("Bruce Banner, Dublin 7");
                                label3Pb.add(barberName1b);
                            JPanel button3Pb = new JPanel(new GridLayout(1,1));
                            booking2P.add(button3Pb);  
                            button3Pb.setBorder(new EmptyBorder(0,100,10,15));
                                JButton viewBarber1b = new JButton("View Barber");
                                button3Pb.add(viewBarber1b);                



        
        cusHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        cusHome.validate();
        cusHome.repaint();

    }
    
 
}
