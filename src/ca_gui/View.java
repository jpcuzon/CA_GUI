/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXDatePicker;

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
    JPasswordField userPassword;
    
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
            JPanel inputPanel = new JPanel(new GridLayout(2,2,5,5));
            body.add(inputPanel);

                JLabel putEmail = new JLabel("Email: ");
                userEmail = new JTextField(20);
                inputPanel.add(putEmail);
                inputPanel.add(userEmail);

                JLabel putPass = new JLabel("Password: ");
                userPassword = new JPasswordField(20);
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
//    JTextField password;
    JPasswordField password;
//    JTextField confirmPass;
    JPasswordField confirmPass;
    
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
                password = new JPasswordField(20);
                inputPanel.add(putPass);
                inputPanel.add(password);
                //confirm password
                JLabel putPass2 = new JLabel("Confirm Password: ");
                confirmPass = new JPasswordField(20);
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
    JPanel dashboardP;
    JPanel bodyCusHome;
    ScrollPane sp;
//    JPanel test;
    public void custHome()
    {    
        cusHome = new JFrame("Barberoo | | Dashboard");
        cusHome.setVisible(true);
        cusHome.setSize(700, 800);
        
        BorderLayout cusHomeL = new BorderLayout();
        cusHome.setLayout(cusHomeL);
        
//        JPanel header = new JPanel();
//        cusHome.add(header, BorderLayout.PAGE_START);
            //for the header
        cusHome.add(headerCus(), BorderLayout.PAGE_START);         
        bodyCusHome = new JPanel(new BorderLayout());
        cusHome.add(bodyCusHome, BorderLayout.CENTER);
        bodyCusHome.add(searchArea(), BorderLayout.PAGE_START); // calls the search field
        sp = new ScrollPane();
        bodyCusHome.add(sp, BorderLayout.CENTER);
        sp.add(dashboardPanel()); //temporary make it a booking page, set it back to dashboardPanel() later
    
        JPanel backToHomeP = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        cusHome.add(backToHomeP,BorderLayout.PAGE_END);
            JButton backToHome = new JButton("Home");
            backToHomeP.add(backToHome);
            backToHome.addActionListener(controller);
            backToHome.setActionCommand("homeButton");


        
        cusHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        cusHome.validate();
        cusHome.repaint();

    }
    

    
    
    
    
    
    
    
    
    
    
    // This section is for JPanel constructors
    
    public JPanel headerCus()
    {
        JPanel header = new JPanel();
//        searchResult.add(header, BorderLayout.PAGE_START);
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
                                
        return header;
    }
    
    public JPanel searchArea()
    {
        JPanel search = new JPanel();
        search.setBorder(new EmptyBorder(0,0,30,0));
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
        return search;
    }
    
    public JPanel dashboardPanel()
    {
        dashboardP = new JPanel(new BorderLayout());
            JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
            dashboardP.add(labelP, BorderLayout.PAGE_START);
                JPanel bookingLabelPanel = new JPanel();
                labelP.add(bookingLabelPanel);
                    JLabel bookingLabel = new JLabel("MY BOOKINGS");
                    bookingLabelPanel.add(bookingLabel);
                    bookingLabel.setBorder(new EmptyBorder(0,0,20,0));
                    bookingLabel.setFont(new Font("Courier", Font.BOLD,20));

            JPanel bookingContainer = new JPanel(new GridLayout(0,1,0,5));
            dashboardP.add(bookingContainer,BorderLayout.CENTER);

                JPanel bookingP = bookingP();
                bookingContainer.add(bookingP);

                JPanel booking3P = bookingP();
                bookingContainer.add(booking3P);

                JPanel booking4P = bookingP();
                bookingContainer.add(booking4P);

//                JPanel booking2P = new JPanel(new GridLayout(3,2,5,5));
//                bookingContainer.add(booking2P);
//                booking2P.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
//                    JPanel label1Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(label1Pb);
//                    label1Pb.setBorder(new EmptyBorder(10,15,0,100));
//                        JLabel time1b = new JLabel("2:00, Tuesday");
//                        label1Pb.add(time1b);
//                    JPanel button1Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(button1Pb);
//                    button1Pb.setBorder(new EmptyBorder(10,100,0,15));
//                        JButton cancel1b = new JButton("Cancel");
//                        button1Pb.add(cancel1b);    
//                    JPanel label2Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(label2Pb);
//                    label2Pb.setBorder(new EmptyBorder(0,15,0,100));
//                        JLabel service1b = new JLabel("Shave, Pending");
//                        label2Pb.add(service1b);
//                    JPanel button2Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(button2Pb);  
//                    button2Pb.setBorder(new EmptyBorder(0,100,0,15));
//                        JButton placeComplaint1b = new JButton("Place Complaint");
//                        button2Pb.add(placeComplaint1b);    
//                    JPanel label3Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(label3Pb);
//                    label3Pb.setBorder(new EmptyBorder(0,15,10,100));
//                        JLabel barberName1b = new JLabel("Bruce Banner, Dublin 7");
//                        label3Pb.add(barberName1b);
//                    JPanel button3Pb = new JPanel(new GridLayout(1,1));
//                    booking2P.add(button3Pb);  
//                    button3Pb.setBorder(new EmptyBorder(0,100,10,15));
//                        JButton viewBarber1b = new JButton("View Barber");
//                        button3Pb.add(viewBarber1b);
                        
                JPanel bookingbuffer = new JPanel();
                bookingContainer.add(bookingbuffer);
                JPanel bookingbuffer2 = new JPanel();
                bookingContainer.add(bookingbuffer2);
            cusHome.revalidate();
            cusHome.repaint();
        return dashboardP;
    }
    
    JFrame searchResult;
    JPanel dashboardSearchP;
    JPanel backToHomeButton;
    String result;
    int countSearch;
    int countIndex;
    public JPanel searchResult()
    {            
        dashboardSearchP = new JPanel(new BorderLayout());
            JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
            dashboardSearchP.add(labelP, BorderLayout.PAGE_START);
                JPanel searchLabelPanel = new JPanel();
                labelP.add(searchLabelPanel);
                    JLabel resultLabel = new JLabel("Search results for \""+ controller.searchBarber +"\"");
                    searchLabelPanel.add(resultLabel);
                    resultLabel.setBorder(new EmptyBorder(0,0,20,0));
                    resultLabel.setFont(new Font("Courier", Font.BOLD,20));
                
            JPanel resultContainer = new JPanel(new GridLayout(0,1,0,5));
            dashboardSearchP.add(resultContainer, BorderLayout.CENTER);
//            resultContainer.add(searchResultPanel());
            
            countSearch = controller.countSearch;
            countIndex = 0;
            JPanel[] searchArrayP = new JPanel[countSearch];
            JPanel[] complaintButtonP = new JPanel[countSearch];
            ArrayList<JButton> testcount = new ArrayList<>();
            
            if(countSearch!=0)
            {
                for(int i=0;i<countSearch;i++)
                {
                    System.out.println("Name: " + controller.searchBarberResult[i][0]);
                    System.out.println("Location: " + controller.searchBarberResult[i][1]);
                    searchArrayP[i] = new JPanel();
                        JPanel searchResultP = new JPanel(new GridLayout(2,2,5,5));
                        searchResultP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
                            JPanel barberNameP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(barberNameP);
                            barberNameP.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel barberName = new JLabel(controller.searchBarberResult[i][0]);
                                barberNameP.add(barberName);
                            JPanel bookButtonP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(bookButtonP);  
                            bookButtonP.setBorder(new EmptyBorder(10,100,0,15));
                                viewBarber1 = new JButton("Book An Appointment");
                                bookButtonP.add(viewBarber1);
                                viewBarber1.addActionListener(controller);
                                viewBarber1.setActionCommand("bookAppointment");
                            JPanel barberLocationP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(barberLocationP);
                            barberLocationP.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberLocation = new JLabel(controller.searchBarberResult[i][1]);
                                barberLocationP.add(barberLocation);                             
                            complaintButtonP[i] = new JPanel(new GridLayout(1,1));
                            searchResultP.add(complaintButtonP[i]);  
                            complaintButtonP[i].setBorder(new EmptyBorder(0,100,10,15));
                                JButton placeComplaint1 = new JButton("Place Complaint");
                                complaintButtonP[i].add(placeComplaint1);
                                placeComplaint1.addActionListener(controller);
                                placeComplaint1.setActionCommand("complaint"+i);
//                                
                    
                    searchArrayP[i].add(searchResultP);
                    resultContainer.add(searchArrayP[i]);
                }
            }
                    
                JPanel bookingbuffer = new JPanel();
                resultContainer.add(bookingbuffer);
                JPanel bookingbuffer2 = new JPanel();
                resultContainer.add(bookingbuffer2);

        return dashboardSearchP;
    }
    
    JButton viewBarber1;
    public JPanel bookingP()
    {
        JPanel bookingP = new JPanel(new GridLayout(3,2,5,5));
            bookingP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
//                        booking1P.setVisible(true);
                JPanel label1P = new JPanel(new GridLayout(1,1));
                bookingP.add(label1P);
                label1P.setBorder(new EmptyBorder(10,15,0,100));
                    JLabel time1 = new JLabel("11:30, Monday");
                    label1P.add(time1);
                JPanel button1P = new JPanel(new GridLayout(1,1));
                bookingP.add(button1P);
                button1P.setBorder(new EmptyBorder(10,100,0,15));
                    JButton cancel1 = new JButton("Cancel");
                    button1P.add(cancel1);
                JPanel label2P = new JPanel(new GridLayout(1,1));
                bookingP.add(label2P);
                label2P.setBorder(new EmptyBorder(0,15,0,100));
                    JLabel service1 = new JLabel("Haircut, Confirmed");
                    label2P.add(service1);
                JPanel button2P = new JPanel(new GridLayout(1,1));
                bookingP.add(button2P);  
                button2P.setBorder(new EmptyBorder(0,100,0,15));
                    JButton placeComplaint1 = new JButton("Place Complaint");
                    button2P.add(placeComplaint1);
                    placeComplaint1.addActionListener(controller);
                    placeComplaint1.setActionCommand("complaint");
                JPanel label3P = new JPanel(new GridLayout(1,1));
                bookingP.add(label3P);
                label3P.setBorder(new EmptyBorder(0,15,10,100));
                    JLabel barberName1 = new JLabel("Tony Stark, Dublin 7");
                    label3P.add(barberName1);
                JPanel button3P = new JPanel(new GridLayout(1,1));
                bookingP.add(button3P);  
                button3P.setBorder(new EmptyBorder(0,100,10,15));
                    viewBarber1 = new JButton("View Barber");
                    button3P.add(viewBarber1);
                    viewBarber1.addActionListener(controller);
                    viewBarber1.setActionCommand("viewBarber");

        return bookingP;
    }
 
JComboBox serviceTypeBox;    
JComboBox timeSlotsBox;    
JPanel makeBooking;
public JPanel makeBooking()
    {
        makeBooking = new JPanel(new BorderLayout());
            JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
            makeBooking.add(labelP, BorderLayout.PAGE_START);
                JPanel barberDetails = new JPanel(new GridLayout(2,1));
                labelP.add(barberDetails);
                    JPanel barberNameP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                    barberDetails.add(barberNameP);
                        JLabel barberName = new JLabel("Tony Stark");
                        barberNameP.add(barberName);
//                        barberName.setBorder(new EmptyBorder(0,0,20,0));
                        barberName.setFont(new Font("Courier", Font.BOLD,20));
                    JPanel barberLocationP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                    barberDetails.add(barberLocationP);
                        JLabel barberLocation = new JLabel("Dublin 7");
                        barberLocationP.add(barberLocation);
//                        barberLocation.setBorder(new EmptyBorder(0,0,20,0));
                        barberLocation.setFont(new Font("Courier", Font.BOLD,20));
                        
                
                    

            JPanel bookingContainer = new JPanel(new GridLayout(0,1,0,5));
            makeBooking.add(bookingContainer,BorderLayout.CENTER);

                JPanel bookingP = new JPanel(new GridLayout(3,1,5,5));
                bookingContainer.add(bookingP);
//                    bookingP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner
                    JPanel serviceTypeP = new JPanel(new GridLayout(1,2));
                    bookingP.add(serviceTypeP);
//                    serviceTypeP.setBorder(new EmptyBorder(10,15,0,100));
                        JPanel serviceLabelP = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                        serviceTypeP.add(serviceLabelP);
                            JLabel serviceTypeLabel = new JLabel("Service Type: ");
                            serviceLabelP.add(serviceTypeLabel);
                        JPanel selectServiceP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                        serviceTypeP.add(selectServiceP);
//                        selectServiceP.setBorder(new EmptyBorder(10,100,0,15));
                            String[] serviceType = {"Haircut", "Shave", "Both"};
                            serviceTypeBox = new JComboBox(serviceType);
                            selectServiceP.add(serviceTypeBox);
                    JPanel timeLabelP = new JPanel();
                    bookingP.add(timeLabelP);
                        JLabel timeLabel = new JLabel("Select Time and Date: ");
                        timeLabelP.add(timeLabel);
                    JPanel scheduleP = new JPanel(new GridLayout(1,2));
                    bookingP.add(scheduleP);
//                    serviceTypeP.setBorder(new EmptyBorder(10,15,0,100));
                        JPanel timePicker = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                        scheduleP.add(timePicker);
                            String[] timeSlots = {"10:00", "11:00", "13:00", "14:00", "15:00"};
                            timeSlotsBox = new JComboBox(timeSlots);
                            timePicker.add(timeSlotsBox);
                        JPanel datePickerP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                        scheduleP.add(datePickerP);
//                        selectServiceP.setBorder(new EmptyBorder(10,100,0,15));
                            datePickerP.add(datePicker());

                //just to space up the bottom space for visual purposes
//                JPanel bookingbuffer = new JPanel();
//                bookingContainer.add(bookingbuffer);
//                JPanel bookingbuffer2 = new JPanel();
//                bookingContainer.add(bookingbuffer2);
//            cusHome.revalidate();
//            cusHome.repaint();
        return makeBooking;
    }
    
    public JPanel noResults()
    {
        JPanel noResults = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JLabel message = new JLabel("No Results Found!");
            noResults.add(message);
            message.setFont(new Font("Courier", Font.ITALIC,30));
        
        return noResults;
    }
 
    public JPanel datePicker()
    {
        JPanel datePicker = new JPanel(new GridLayout(1,2));
            
            JXDatePicker picker = new JXDatePicker();
            picker.setDate(Calendar.getInstance().getTime());
            picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));


            Date getDate = picker.getDate();        
            DateFormat setDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String szDate = setDateFormat.format(getDate);

            System.out.println(szDate);
            
            datePicker.add(picker);
        
        return datePicker;
    }
    JTextField complaintBox;
    public JPanel complaintPopUp()
    {
        JPanel complaintPopUp = new JPanel();
            JLabel putComplaintL = new JLabel("Place complaint here: ");
            complaintPopUp.add(putComplaintL);
            complaintBox = new JTextField("",20);
            complaintPopUp.add(complaintBox);
        
        
        return complaintPopUp;
    }
}
