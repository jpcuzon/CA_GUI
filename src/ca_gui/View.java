/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author jonpaulcarlo
 */
public class View extends JFrame
{
    Controller controller;
    
    boolean visible;
    String uType;
    String complaint;
    String result;
    String date;
    int countSearch;
    int countIndex;
    JFrame login;
    JFrame Register;
    JFrame cusHome;
    JFrame searchResult;
    JFrame barHome;
    JPanel dashboardP;
    JPanel bodyCusHome;
    JPanel dashboardSearchP;
    JPanel backToHomeButton;
    JPanel makeBooking;
    JPanel bodyBarHome;
    JPanel barberDashP;
    JButton viewBarber1;
    ScrollPane sp;
    JTextField userEmail;
    JTextField fName;
    JTextField lName;
    JTextField pNumber;
    JTextField email;
    JTextField searchField;
    JPasswordField userPassword;  
    JLabel putLoc;
    JLabel testLabel;
    JComboBox userBoxReg;
    JComboBox locList;
    JComboBox userBoxLog;
    JComboBox comboBoxSearch;
    JComboBox serviceTypeBox;    
    JComboBox timeSlotsBox; 
    JComboBox[] bookingStatus;
    JPasswordField password;
    JPasswordField confirmPass;
    Date getDate;
    JXDatePicker picker;
    DateFormat setDateFormat;
     
    
    
    
    
    
    

    
    
    public View(Controller controller)
    {
        this.controller = controller;
        // We encapsulated the building process of the window
        login();
        
    }
    
    //log in page
    public void login()
    {
        login = new JFrame("Barberoo | | Log-in"); //creates a new frame for the log in page
        login.setVisible(true);
        login.setSize(500, 700);
        
        BorderLayout loginL = new BorderLayout();
        login.setLayout(loginL);
        
        //for the logo panel/header
        JPanel logoPanel = new JPanel();
        login.add(logoPanel, BorderLayout.PAGE_START);
            JLabel logoLabel = new JLabel("Barberoo");
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
                userPassword = new JPasswordField(20); //JPasswordField hides whatever the user types
                inputPanel.add(putPass);
                inputPanel.add(userPassword);

            //for the panel that contains the drop-down button
            JPanel logButtons = new JPanel();
            body.add(logButtons);
                String[] userType =  {"Select User Type","Customer", "Barber"}; //let's the user select their user type and prevents them from logging in when they selected the wrong value
                userBoxLog = new JComboBox(userType);
                logButtons.add(userBoxLog);
                JButton submit = new JButton("Log-in"); //directs the user to their respective dashboard
                submit.addActionListener(controller); 
                submit.setActionCommand("submit");
                logButtons.add(submit);
                
            //panel that contains the button that directs the user to the registration page when clicked
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
    
    //a new frame for the registration page
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
                String[] userType = {"Select User Type","Customer","Barber"}; //lets the user choose what type of user they want to register as
                userBoxReg = new JComboBox(userType);
                userBoxReg.addActionListener(controller);
                userBoxReg.setActionCommand("hide");
                userSelect.add(userBoxReg);
                
            //panel that contains the input fields
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
                //location field that is only available to users registering as a barber
                putLoc = new JLabel("Location: ");
                String[] locations = {"Dublin 1","Dublin 2","Kildare, Kildare","Newbridge, Kildare","Cork","Belfast","Dublin 7","Dublin 8","Galway"};
                locList = new JComboBox(locations);
                inputPanel.add(putLoc);
                inputPanel.add(locList);
                locList.setVisible(visible); //label for location that will be hidden depending on the user type
                putLoc.setVisible(visible);  //textfield for location that will be hidden depending on the user type

            JButton register = new JButton("Register");
            body.add(register);
            register.addActionListener(controller); //submits the details to the database
            register.setActionCommand("register");
        
            //panel that contains the buttons to go back to log-in page
            JPanel regIns = new JPanel(new GridLayout(2,1));
            Register.add(regIns, BorderLayout.PAGE_END);
            regIns.setBorder(new EmptyBorder(30,30,30,30));

                JLabel haveAcc = new JLabel("Already have an account?");
                regIns.add(haveAcc);
                JButton goLogin = new JButton("Log-in");
                goLogin.addActionListener(controller); //directs the user to the log in page instead if they already have an account
                goLogin.setActionCommand("goLogin");
                regIns.add(goLogin);
        
        
        
        
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.validate();
        Register.repaint();
        
    }
    
    //Customer dashboard side -------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    
    public void custHome()
    {    
        //new frame for the customer dashboard
        cusHome = new JFrame("Barberoo | | Dashboard");
        cusHome.setVisible(true);
        cusHome.setSize(800, 800);
        
        BorderLayout cusHomeL = new BorderLayout();
        cusHome.setLayout(cusHomeL);

        //for the header
        cusHome.add(headerCus(), BorderLayout.PAGE_START);         
        bodyCusHome = new JPanel(new BorderLayout());
        cusHome.add(bodyCusHome, BorderLayout.CENTER);
        bodyCusHome.add(searchArea(), BorderLayout.PAGE_START); // calls the search field panel
        sp = new ScrollPane();
        bodyCusHome.add(sp, BorderLayout.CENTER);
        sp.add(dashboardPanel()); //dashboard panel that initially contains the bookin panels; this serves as the home panel
    
        //directs the user back to the home panel/refreshes the home panel
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

    
    
    
    // This section is for JPanel constructors for the customer dashboard ---------------------------------------------------------------------------------\\
    
    //customer dashboard's header
    public JPanel headerCus()
    {
        JPanel header = new JPanel();
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
                                JLabel welcome = new JLabel("Welcome, "+ controller.customerName); //grabs the user's name and print it on the welcome panel
                                welcomeMessage.add(welcome);
                                welcome.setFont(new Font("Courier", Font.BOLD,15));
                            JPanel logoutButton = new JPanel(); //note: allign to the right
                            rightHeader.add(logoutButton);
                                JButton logout = new JButton("Logout"); //logs the user out and directs them back to the log in page
                                logoutButton.add(logout);
                                logout.addActionListener(controller);
                                logout.setActionCommand("logoutCus");            
                                
        return header;
    }
    
    //panel that contains the search field
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
    
    //Main body of the customer dashboard
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

            countSearch = controller.countBooking; //count the number of bookings the user have
            countIndex = 0;
            JPanel[] bookArrayP = new JPanel[countSearch]; //JPanel array that has a length equal to the number of bookings the user have
            
            if(countSearch==0) //returns a message that the user has no booking if they have no booking
            {
                bookingContainer.add(noBookings());
            }
            else
            {
                for(int i=0;i<countSearch;i++) //a loop that displays the user's bookings
                {
                    bookArrayP[i] = new JPanel();
                    JPanel bookingP = new JPanel(new GridLayout(3,2,5,5));
                        bookingP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
                            JPanel label1P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label1P);
                            label1P.setBorder(new EmptyBorder(10,15,0,100));
                                JLabel time1 = new JLabel("Schedule: " + controller.viewBookingsList[i][0]+", "+controller.viewBookingsList[i][1]); //grabs the date and time info from the database
                                label1P.add(time1);
                            JPanel button1P = new JPanel(new GridLayout(1,1));
                            bookingP.add(button1P);
                            button1P.setBorder(new EmptyBorder(10,100,0,15));
                                JButton cancel = new JButton("Cancel");
                                button1P.add(cancel);
                                cancel.addActionListener(controller);
                                cancel.setActionCommand("cancel"+i); //set a specific action command depending on the index of the loop to accurately choose the target barber details on the controller
                            JPanel label2P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label2P);
                            label2P.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel service1 = new JLabel("Service Type: " + controller.viewBookingsList[i][2]+", (Status: "+controller.viewBookingsList[i][6]+")");  //grabs the service type and status info from the database
                                label2P.add(service1);
                            JPanel button2P = new JPanel(new GridLayout(1,1));
                            bookingP.add(button2P);  
                            button2P.setBorder(new EmptyBorder(0,100,0,15));
                                JButton placeComplaint1 = new JButton("Place Complaint");
                                button2P.add(placeComplaint1);
                                placeComplaint1.addActionListener(controller);
                                placeComplaint1.setActionCommand("complaintBooking"+i); //set a specific action command depending on the index of the loop to accurately choose the target barber details on the controller
                            JPanel label3P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label3P);
                            label3P.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberName1 = new JLabel("Barber: "+controller.viewBookingsList[i][3]+", "+controller.viewBookingsList[i][4]);  //grabs the barber's name and location info from the database
                                label3P.add(barberName1);
                    bookArrayP[i].add(bookingP);
                    bookingContainer.add(bookArrayP[i]);
                }
                
            }

            cusHome.revalidate();
            cusHome.repaint();
        return dashboardP;
    }
    
    //panel for the search result
    public JPanel searchResult()
    {            
        dashboardSearchP = new JPanel(new BorderLayout());
            JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
            dashboardSearchP.add(labelP, BorderLayout.PAGE_START);
                JPanel searchLabelPanel = new JPanel();
                labelP.add(searchLabelPanel);
                    JLabel resultLabel = new JLabel("Search results for \""+ controller.searchBarber +"\""); //displays the string that the user typed on the search field
                    searchLabelPanel.add(resultLabel);
                    resultLabel.setBorder(new EmptyBorder(0,0,20,0));
                    resultLabel.setFont(new Font("Courier", Font.BOLD,20));
                
            JPanel resultContainer = new JPanel(new GridLayout(0,1,0,5));
            dashboardSearchP.add(resultContainer, BorderLayout.CENTER);
            countSearch = controller.countSearch; //count the number of search results
            countIndex = 0;
            JPanel[] searchArrayP = new JPanel[countSearch]; //JPanel array for the search results
            
            if(countSearch!=0)
            {
                for(int i=0;i<countSearch;i++) //a loop that displays the panels containing the details of the barbers that matches a certain character/string that the user types
                {
                    searchArrayP[i] = new JPanel();
                        JPanel searchResultP = new JPanel(new GridLayout(2,2,5,5));
                        searchResultP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
                            JPanel barberNameP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(barberNameP);
                            barberNameP.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel barberName = new JLabel(controller.searchBarberResult[i][0]);  //grabs the barber's name info from the database
                                barberNameP.add(barberName);
                            JPanel bookButtonP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(bookButtonP);  
                            bookButtonP.setBorder(new EmptyBorder(10,100,0,15));
                                viewBarber1 = new JButton("Book An Appointment");
                                bookButtonP.add(viewBarber1);
                                viewBarber1.addActionListener(controller);
                                viewBarber1.setActionCommand("bookAppointment"+i); //sets a specific action command unique to the babrer it is attached to by using the search index to accurately choose the barber on the controller
                            JPanel barberLocationP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(barberLocationP);
                            barberLocationP.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberLocation = new JLabel(controller.searchBarberResult[i][1]); //grabs the barber's location info from the database
                                barberLocationP.add(barberLocation);                             
                            JPanel complaintButtonP = new JPanel(new GridLayout(1,1));
                            searchResultP.add(complaintButtonP);  
                            complaintButtonP.setBorder(new EmptyBorder(0,100,10,15));
                                JButton placeComplaint1 = new JButton("Place Complaint");
                                complaintButtonP.add(placeComplaint1);
                                placeComplaint1.addActionListener(controller);
                                placeComplaint1.setActionCommand("complaint"+i); //sets a specific action command unique to the babrer it is attached to by using the search index to accurately choose the barber on the controller
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
 
    //pop  up panel for making a booking
    public JPanel makeBooking()
    {
        makeBooking = new JPanel();
            JPanel bookingContainer = new JPanel(new GridLayout(0,1,0,5));
            makeBooking.add(bookingContainer);

                JPanel bookingP = new JPanel(new GridLayout(3,1,5,5));
                bookingContainer.add(bookingP);
                    JPanel serviceTypeP = new JPanel(new GridLayout(1,2));
                    bookingP.add(serviceTypeP);
                        JPanel serviceLabelP = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                        serviceTypeP.add(serviceLabelP);
                            JLabel serviceTypeLabel = new JLabel("Service Type: ");
                            serviceLabelP.add(serviceTypeLabel);
                        JPanel selectServiceP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                        serviceTypeP.add(selectServiceP);
                            String[] serviceType = {"Haircut", "Shave", "Both"};
                            serviceTypeBox = new JComboBox(serviceType); //combobox for selecting the service type
                            selectServiceP.add(serviceTypeBox);
                    JPanel timeLabelP = new JPanel();
                    bookingP.add(timeLabelP);
                        JLabel timeLabel = new JLabel("Select Time and Date: ");
                        timeLabelP.add(timeLabel);
                    JPanel scheduleP = new JPanel(new GridLayout(1,2));
                    bookingP.add(scheduleP);
                        JPanel timePicker = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                        scheduleP.add(timePicker);
                            String[] timeSlots = {"10:00", "11:00", "13:00", "14:00", "15:00"};
                            timeSlotsBox = new JComboBox(timeSlots); //combobox for selecting the time
                            timePicker.add(timeSlotsBox);
                        JPanel datePickerP = new JPanel(new FlowLayout(FlowLayout.LEADING));
                        scheduleP.add(datePickerP);
                            datePickerP.add(datePicker()); //calls the date picker constructor

        return makeBooking;
    }
    
    //panel that will be showed on the search result panel when there are no matching results while searching 
    public JPanel noResults()
    {
        JPanel noResults = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JLabel message = new JLabel("No Results Found!");
            noResults.add(message);
            message.setFont(new Font("Courier", Font.ITALIC,30));
        
        return noResults;
    }
    
    //panel that will be showed on the dashboard when the user currently has no booking
    public JPanel noBookings()
    {
        JPanel noResults = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JLabel message = new JLabel("No Bookings Found!");
            noResults.add(message);
            message.setFont(new Font("Courier", Font.ITALIC,30));
        
        return noResults;
    }
 
    //datepicker sourced on the internet that shows a calendar and capture the date selected. .jar files required is included in the jar forlder
    public JPanel datePicker()
    {
        JPanel datePicker = new JPanel(new GridLayout(1,2));
            
            picker = new JXDatePicker();
            datePicker.add(picker);
            picker.setDate(Calendar.getInstance().getTime()); //sets the current date initially
            picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        
        return datePicker;
    }
    
    //panel for the complaint pop-up where the user can submit their complaints
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
    
    
    
   

    //barber dashboard side-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

    //barber main dashboard frame
    public void barHome()
    {    
        barHome = new JFrame("Barberoo | | Dashboard");
        barHome.setVisible(true);
        barHome.setSize(750, 800);
        
        BorderLayout barHomeL = new BorderLayout();
        barHome.setLayout(barHomeL);

        //for the header
        barHome.add(headerBar(), BorderLayout.PAGE_START); //calls the header panel     
        bodyBarHome = new JPanel(new BorderLayout());
        barHome.add(bodyBarHome, BorderLayout.CENTER);
        bodyBarHome.add(detailsArea(), BorderLayout.PAGE_START); // calls the barber details field
        sp = new ScrollPane();
        bodyBarHome.add(sp, BorderLayout.CENTER);
        sp.add(barberDashboard());
        
        barHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        barHome.validate();
        barHome.repaint();

    }
    
    public JPanel headerBar()
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
                JPanel rightAlign = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                subHeader.add(rightAlign);
                    JPanel rightAlignHeader = new JPanel();
                    rightAlign.add(rightAlignHeader);
                    JPanel rightHeader = new JPanel();
                    rightAlignHeader.add(rightHeader);
                        JPanel logoutButton = new JPanel();
                        rightHeader.add(logoutButton);
                            JButton logout = new JButton("Logout"); //logs the user out and directs them to the log in page
                            logoutButton.add(logout);
                            logout.addActionListener(controller);
                            logout.setActionCommand("logoutBar");            

        return header;
    }
    
    public JPanel detailsArea()
    {
        JPanel search = new JPanel(new FlowLayout(FlowLayout.LEADING));
        search.setBorder(new EmptyBorder(0,0,30,0));
            JPanel welcomeP = new JPanel();
            search.add(welcomeP);
                JLabel welcome = new JLabel("Welcome, "+controller.barberName); //grabs the user's registered name and displays it
                welcome.setFont(new Font("Courier", Font.BOLD,20));
                search.add(welcome);
            JPanel complaintButtonP = new JPanel();
            search.add(complaintButtonP);
                JButton complaintButton = new JButton("View Complaints"); //button for viewing the complaints to the barber by opening a table
                complaintButtonP.add(complaintButton);
                complaintButton.addActionListener(controller);
                complaintButton.setActionCommand("viewComplaints");

        return search;
    }
    
    //panel for the barber's main dashboard which shows the bookings the barber currently have
    public JPanel barberDashboard()
    {
        barberDashP = new JPanel(new BorderLayout());
            JPanel labelP = new JPanel(new FlowLayout(FlowLayout.LEADING));
            barberDashP.add(labelP, BorderLayout.PAGE_START);
                JPanel bookingLabelPanel = new JPanel();
                labelP.add(bookingLabelPanel);
                    JLabel bookingLabel = new JLabel("MY BOOKINGS");
                    bookingLabelPanel.add(bookingLabel);
                    bookingLabel.setBorder(new EmptyBorder(0,0,20,0));
                    bookingLabel.setFont(new Font("Courier", Font.BOLD,20));

            JPanel bookingContainer = new JPanel(new GridLayout(0,1,0,5));
            barberDashP.add(bookingContainer,BorderLayout.CENTER);

            countSearch = controller.countBooking;
            countIndex = 0;
            JPanel[] bookArrayP = new JPanel[countSearch]; //Jpanel array 
            bookingStatus = new JComboBox[countSearch]; //jcombobox array for assigning one jcombobox per booking
            
            if(countSearch==0)
            {
                bookingContainer.add(noBookings()); //calls the panel that says the user has no booking if the user doesn't have one
            }
            else
            {
                for(int i=0;i<countSearch;i++) //a loop to create multiple panels based on the number of booking the user have
                {
                    bookArrayP[i] = new JPanel();
                    JPanel bookingP = new JPanel(new GridLayout(3,2,5,5));
                        bookingP.setBorder(BorderFactory.createDashedBorder(null,2,3,3,true)); //creates a dashed line border with the parameter (paint, thickness,length,spacing, and rounded corner)
                            JPanel label1P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label1P);
                            label1P.setBorder(new EmptyBorder(10,15,0,100));
                                JLabel time1 = new JLabel("Schedule: " + controller.viewBookingsList[i][0]+", "+controller.viewBookingsList[i][1]); //grabs the time and date info from the database
                                label1P.add(time1);
                            JPanel button1P = new JPanel(new GridLayout(1,2));
                            bookingP.add(button1P);
                            button1P.setBorder(new EmptyBorder(10,100,0,15));
                                String[] statusType = {"Select Action","Pending","Confirm","Done","Cancel","Did not arrived"};
                                bookingStatus[i] = new JComboBox(statusType); //jcombobox for status options; specifically points to the linked customer for accuracy using the counter index
                                JButton update = new JButton("Update"); //updates the database on the status of a booking
                                button1P.add(bookingStatus[i]);
                                button1P.add(update);
                                update.addActionListener(controller);
                                update.setActionCommand("updateStatus"+i); // specifically points to the linked customer for accuracy using the counter index
                            JPanel label2P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label2P);
                            label2P.setBorder(new EmptyBorder(0,15,0,100));
                                JLabel service1 = new JLabel("Service Type: " + controller.viewBookingsList[i][2]);  //grabs the service type info from the database
                                label2P.add(service1);
                            JPanel statusLabel = new JPanel(new GridLayout(1,1));
                            bookingP.add(statusLabel);  
                            statusLabel.setBorder(new EmptyBorder(0,100,0,15));
                                JLabel status = new JLabel(controller.viewBookingsList[i][6]);  //grabs the status info from the database
                                statusLabel.add(status);
                            JPanel label3P = new JPanel(new GridLayout(1,1));
                            bookingP.add(label3P);
                            label3P.setBorder(new EmptyBorder(0,15,10,100));
                                JLabel barberName1 = new JLabel("Customer: "+controller.viewBookingsList[i][3]);  //grabs the customer name info from the database
                                label3P.add(barberName1);
                            JPanel button2P = new JPanel(new GridLayout(1,1));
                            bookingP.add(button2P);  
                            button2P.setBorder(new EmptyBorder(0,100,10,15));
                                JButton placeComplaint1 = new JButton("Place Complaint");
                                button2P.add(placeComplaint1);
                                placeComplaint1.addActionListener(controller);
                                placeComplaint1.setActionCommand("complaintBooking"+i); // specifically points to the linked customer for accuracy using the counter index
                    bookArrayP[i].add(bookingP);
                    bookingContainer.add(bookArrayP[i]);
                }
                
            }

            barHome.revalidate();
            barHome.repaint();
        return barberDashP;
    }

    //panel that contains the complainee name and their complaints on a table
    public JPanel complaintTable()
    {
        JPanel complaintTable = new JPanel();
        String[] colNames = {"Customer Name","Complaint"};
        String[][] data = controller.complaintTable;
        
        JTable t = new JTable (data, colNames);
        JScrollPane sp = new JScrollPane(t);
        complaintTable.add(sp);
        
        return complaintTable;
    }

}