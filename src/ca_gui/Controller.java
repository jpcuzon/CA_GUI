/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author jonpaulcarlo
 */
public class Controller implements ActionListener
{
    View view;
    Model model;
    String em;
    String pw;
    String searchBarber;
    String customerName;
    String barberName;
    String[][] searchBarberResult;
    String[][] complaintTable;
    String[][] viewBookingsList;
    boolean result;
    int countSearch;
    int custNumber;
    int barNumber;
    int countBooking;
    Booking book;
    
    
    public Controller()
    {
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //shows/hide location depending on the user type selected on the registration page--------------------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("hide")) 
        {
            if(view.userBoxReg.getSelectedItem()=="Customer")
            {
                view.visible = false;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
                
            }else if(view.userBoxReg.getSelectedItem()=="Barber")
            {
                view.visible = true;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
            }
       
            
        }
        
        //opens the registration page when the register button was clicked on the log in page and disposes the login page---------------------------------------------------------------------\\
        if(e.getActionCommand().equals("goRegister")) 
        {
            view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
            view.Register();
        }
        
        //opens the login page when the login button was clicked on the registration page and disposes the registration page-----------------------------------------------------------------\\
        if(e.getActionCommand().equals("goLogin")) 
        {
            view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
            view.login();
            
        }
        
        //logs out the user and directs them back to the login page when the log out button was clicked------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("logoutCus")) 
        {
            int confirmLogOut = JOptionPane.showConfirmDialog(view.cusHome, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if(confirmLogOut==0)
            {
                view.cusHome.dispatchEvent(new WindowEvent(view.cusHome, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                view.login();
            }
  
        }
        
        //logs out the user and directs them back to the login page when the log out button was clicked-----------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("logoutBar")) //logs out the user and directs them back to the login page when the log out button was clicked
        {
            int confirmLogOut = JOptionPane.showConfirmDialog(view.barHome, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if(confirmLogOut==0)
            {
                view.barHome.dispatchEvent(new WindowEvent(view.barHome, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                view.login();
            }
  
        }
        
        //gets called when the login button was clicked on the login page---------------------------------------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("submit")) 
        {
            
            User user;

            if(view.userBoxLog.getSelectedItem()=="Customer") //when the user is logging in as a customer
            {
                em = view.userEmail.getText();
                pw = view.userPassword.getText();
                
                //creates a new user class
                user = new User(em, pw);
                //check if there's a match for email and password in the database
                result = model.loginCustomer(user);
                custNumber = model.getcusNumber(user);
                CustomerReg cusName = new CustomerReg(em,pw);
                customerName = model.getCusName(cusName);
                
                //calls the model that checks for the number of bookings the user have and the details of their bookings
                book = new Booking(custNumber);
                countBooking = model.countBooking(book);
                viewBookingsList = model.viewBookings(book);
                
                if(result) //only activates when the database found a match and returns a true value for return
                {
                    view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING)); //disposes the other frame when this frame opens
                    view.custHome();
                    
                }
                else //pops up whenever the user forgot to pick a user type
                {
                    JOptionPane.showMessageDialog(view.login, "Invalid Credentials. Please Try Again.");
                }
                
            }
                
            else if(view.userBoxLog.getSelectedItem()=="Barber") //when the user is logging in as a barber
            {
                em = view.userEmail.getText();
                pw = view.userPassword.getText();
                
                //creates a new user class
                user = new User(em, pw);
                //check if there's a match for email and password in the database
                result = model.loginBarber(user);
                barNumber = model.getbarNumber(user);
                BarberReg barName = new BarberReg(em,pw);
                barberName = model.getBarName(barName);
                
                //calls the model that checks for the number of bookings the user have and the details of their bookings
                book = new Booking(barNumber);
                countBooking = model.countBarberBooking(book);
                viewBookingsList = model.viewBarberBookings(book);

                if(result)
                {
                    view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                    view.barHome();
                }
                else//pops up whenever the user forgot to pick a user type
                {
                    JOptionPane.showMessageDialog(view.login, "Invalid Credentials. Please Try Again.");
                }

            }
            else//pops up whenever the user forgot to pick a user type
            {
                JOptionPane.showMessageDialog(view.login, "Please Select User Type!");
            }
                
            
        }
        
        //if the register button is clicked on the register page--------------------------------------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("register")) 
        {
            if(!view.fName.getText().isEmpty()&& !view.email.getText().isEmpty()&&!view.pNumber.getText().isEmpty()&&!view.password.getText().isEmpty()) //validattion that check if the user left field empty
            {
                if(view.userBoxReg.getSelectedItem()=="Customer") //for users registering as a customer
                {
                    //gets the values that the user typed on the input fields
                    String fullName = view.fName.getText() + " " + view.lName.getText();
                    String email = view.email.getText();
                    String phone = view.pNumber.getText();
                    String password = view.password.getText();
                    String confirmPass = view.confirmPass.getText();
                    
                    if(!phone.matches("[a-zA-Z]*")&&(phone.length()==10)) //validation that checks if the user input a letter on the phone number field and checks if they input 10 digit numbers or not
                    {
                        if(email.contains("@")&&email.contains(".")) //validation that checks if the user typed '@' and a dot (.) in the email field as these characters are always present in an email address
                        {
                            if(password.equals(confirmPass)) //validation to check if the user's input in the Password and Confirm Password field matches or not
                            {
                                //creates a CustomerReg object and assigns the user's input to its attributes
                                CustomerReg cusReg = new CustomerReg(fullName, email, phone, password);
                                
                                    //calls and run the query to the database
                                    model.CusRegister(cusReg);
                                    
                                    JOptionPane.showMessageDialog(view.Register, "Go back to the login page", "Registraition Complete!", 1); //shows a confirmation that the registraion is complete and leads the user back to the login page when clicked
                                    view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                                    view.login();
                            }
                            else{JOptionPane.showMessageDialog(view.Register, "Password doesn't match!", "Error!", 0);}
                            
                        }else{JOptionPane.showMessageDialog(view.Register, "Invalid email!", "Error!", 0);}
                        
                    }else{JOptionPane.showMessageDialog(view.Register, "Invalid Phone Number", "Error", 0);}
                }
                
                else if(view.userBoxReg.getSelectedItem()=="Barber") //barber registration
                {
                    //gets the values that the user typed on the input fields
                    String fullName = view.fName.getText() + " " + view.lName.getText();
                    String email = view.email.getText();
                    String phone = view.pNumber.getText();
                    String password = view.password.getText();
                    String confirmPass = view.confirmPass.getText();
                    String location = view.locList.getSelectedItem().toString();
                    
                    if(!phone.matches("[a-zA-Z]*")&&(phone.length()==10)) //validation that checks if the user input a letter on the phone number field and checks if they input 10 digit numbers or not
                    {
                        if(email.contains("@")&&email.contains(".")) //validation that checks if the user typed '@' and a dot (.) in the email field as these characters are always present in an email address
                        {

                            if(password.equals(confirmPass)) //validation to check if the user's input in the Password and Confirm Password field matches or not
                            {
                                //creates a BarberReg object and assigns the user's input to its attributes
                                BarberReg barReg = new BarberReg(fullName, email, phone, password, location);

                                //calls and run the query to the database
                                model.BarRegister(barReg);
                                
                                JOptionPane.showMessageDialog(view.Register, "Go back to the login page", "Registraition Complete!", 1); //shows a confirmation that the registraion is complete and leads the user back to the login page when clicked
                                view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                                view.login();
                            }
                            else{JOptionPane.showMessageDialog(view.Register, "Password doesn't match!", "Error!", 0);}
                            
                        }else{JOptionPane.showMessageDialog(view.Register, "Invalid email!", "Error!", 0);}
                        
                    }else{JOptionPane.showMessageDialog(view.Register, "Invalid Phone Number", "Error", 0);}

                }
                else
                {
                    JOptionPane.showMessageDialog(view.Register, "Please Select User Type!");
                }
            }
            else
            {
                
                JOptionPane.showMessageDialog(view.Register, "Please fill up all the fields!", "Incomplete Data",2);
            }
            
        }
        
        //gets called when the search button is clicked-----------------------------------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("searchBarber")) 
        {
            searchBarber = view.searchField.getText(); //captures the user's input
            BarberReg search = new BarberReg(searchBarber); //put the user's input to the object's attribute

            if(view.comboBoxSearch.getSelectedItem().equals("Name")) //runs if "Name" is selected
            {
                countSearch = model.countSearchB(search); //counts the result
                countSearch = model.countSearchB(search);
                if(countSearch==0)
                {
                    view.sp.add(view.noResults()); //displays a message when there's no result found
                }
                else
                {
                    searchBarberResult = model.searchBarber(search); //runs the query to the database
                    view.dashboardP.removeAll(); //removes the dashboard panel for bookings
                    view.sp.add(view.searchResult()); //and shows the search result panel instead

                }
                
            }
            else//runs if "Location" is selected
            {
                countSearch = model.countSearchL(search);//counts the result
                if(countSearch==0)
                {
                    view.sp.add(view.noResults()); //displays a message when there's no result found
                }
                else
                {
                    searchBarberResult = model.searchLocation(search); //runs the query to the database
                    view.dashboardP.removeAll(); //removes the dashboard panel for bookings
                    view.sp.add(view.searchResult()); //and shows the search result panel instead
                }
                
            }

        }
        
        //when the Place a Complaint button is pressed inside the search result-------------------------------------------------------------------------------------------------\\
        for(int i = 0;i<countSearch;i++) //loops based on the number of search results
        {
            if(e.getActionCommand().equals("complaint"+i)) //grabs the specific command action inside the loop in the search result panel
            {   
                int n = JOptionPane.showConfirmDialog(view.cusHome, view.complaintPopUp(),"Is there a problem?", JOptionPane.OK_CANCEL_OPTION); //shows a pop up that contains the complaint panel
                String complaint = view.complaintBox.getText(); //grabs the user input
                
                if(n==JOptionPane.YES_OPTION) //only runs if the user clicked 'OK'
                {
                    if(!complaint.isBlank()) //only runs if the user has typed something on the input field
                    {

                        int custNumberComplaint = custNumber; //grabs the customer id
                        String barberName = searchBarberResult[i][0]; //grabs the barber name
                        Complaints complaints = new Complaints(complaint,custNumberComplaint,barberName); //creates a new complain object and adds the attributes

                        model.placeComplaint(complaints); //runs the querry


                        JOptionPane.showMessageDialog(view.cusHome, "Submission Successful", "Place Complaint", 1); //confirms if the complaint is successfully submitted
                    }
                }

            }
        }
        //when the Place a Complaint button is pressed inside the booking area/home page-----------------------------------------------------------------------------------------\\
        for(int i = 0;i<countBooking;i++)
        {
            if(e.getActionCommand().equals("complaintBooking"+i))
            {   
                int n = JOptionPane.showConfirmDialog(view.cusHome, view.complaintPopUp(),"Is there a problem?", JOptionPane.OK_CANCEL_OPTION);
                String complaint = view.complaintBox.getText();
                
                if(n==JOptionPane.YES_OPTION)
                {
                    if(!complaint.isBlank())
                    {

                        int custNumberComplaint = custNumber;
                        String barberName = viewBookingsList[i][3];
                        Complaints complaints = new Complaints(complaint,custNumberComplaint,barberName);

                        model.placeComplaint(complaints);


                        JOptionPane.showMessageDialog(view.cusHome, "Submission Successful", "Place Complaint", 1);
                    }
                }

            }
        }
        
        //loop for booking an appointment to the specific barber based on the index-----------------------------------------------------------------------------------------\\
        for(int i = 0;i<countSearch;i++)
        {
            if(e.getActionCommand().equals("bookAppointment"+i))
            {
                int n = JOptionPane.showConfirmDialog(view.cusHome, view.makeBooking(),"Book an Appointmet", JOptionPane.OK_CANCEL_OPTION);
                if(n==JOptionPane.YES_OPTION) //only runs if the user clicked 'OK'
                {
                    view.getDate = view.picker.getDate();  //gets the date chosen by the user
                    view.setDateFormat = new SimpleDateFormat("dd.MM.yyyy"); //sets the date format
                    view.date = view.setDateFormat.format(view.getDate);   //applies the format to the date

                    //grabs the details necessary
                    int cusNumberBook = custNumber;
                    String bookDate = view.date;
                    String service = view.serviceTypeBox.getSelectedItem().toString();
                    String time = view.timeSlotsBox.getSelectedItem().toString();
                    String barberName = searchBarberResult[i][0];

                    Booking book = new Booking(cusNumberBook,bookDate,service,time,barberName);
                    
                    if(!model.checkAvailability(book)) //checks if the chosen slot (time and date) is available or not; Only runs if there's no match found meaning it's still available
                    {
                        model.placeBooking(book); //runs the query

                        JOptionPane.showMessageDialog(view.cusHome, "Booking Successful", "Book", 1); //confirms if  the bookin was successful
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(view.cusHome, "Selected slot is not available, please select a different slot", "Book", 1); //shows a message if the selected slot is not available
                    }
                }
            }
        }
        
        //calls the complaint table panel when clicked-----------------------------------------------------------------------------------------\\
        if(e.getActionCommand().equals("viewComplaints")) 
        {   
            int barberNumber = barNumber;
            Complaints getbarNumber = new Complaints(barberNumber);
            complaintTable = model.getComplaints(getbarNumber);
            JOptionPane.showMessageDialog(view.barHome, view.complaintTable(),"My Customers' Complaints", JOptionPane.PLAIN_MESSAGE);
        }
     
        //when the cancel button is clicked on the booking page-----------------------------------------------------------------------------------------\\
        for(int i = 0;i<countBooking;i++)
        {
            if(e.getActionCommand().equals("cancel"+i))
            {   
                int n = JOptionPane.showConfirmDialog(view.cusHome, "Confirm Cancellation?","Cancel Booking", JOptionPane.OK_CANCEL_OPTION);
                if(n==JOptionPane.YES_OPTION)
                {
                    //grabs all the details of the booking
                    String bookDate = viewBookingsList[i][0];
                    String time = viewBookingsList[i][1];
                    int cusNumberBook = custNumber;
                    String service = viewBookingsList[i][2];                    
                    String barberNumber = viewBookingsList[i][5];

                    Booking book = new Booking(cusNumberBook,bookDate,service,time,barberNumber);

                    model.cancelBooking(book); //runs the query that deletes the booking
                    JOptionPane.showMessageDialog(view.cusHome, "Cancellation Successful", "Cancel Booking", 1);
                    
                    //updates the dashboard when a booking is deleted/cancelled
                    book = new Booking(custNumber);
                    countBooking = model.countBooking(book);
                    viewBookingsList = model.viewBookings(book);
                    view.dashboardP.removeAll();
                    view.sp.add(view.dashboardPanel());
                    
                }

            }
        }
        
        //when the update button is clicked-------------------------------------------------------------------------------------------------------------\\
        for(int i = 0;i<countBooking;i++)
        {
            if(e.getActionCommand().equals("updateStatus"+i))
            {   
                String status = view.bookingStatus[i].getSelectedItem().toString();
                if(status.equals("Select Action")) //runs if the user didn't select a correct status type
                {
                    JOptionPane.showMessageDialog(view.barHome, "Please select an action!", "Update Status", 1);
                }
                else
                {
                    //grabs the booking details to point out the specific booking to be edited 
                    String date = viewBookingsList[i][0];
                    String time = viewBookingsList[i][1];
                    String service_type = viewBookingsList[i][2];
                    int barberNumber = barNumber;
                    String customer_number = viewBookingsList[i][5];
                    Booking book = new Booking(customer_number,date,service_type,time,barberNumber,status);

                    model.updateBooking(book); //runs the query that updates the status
                    
                    //refreshes and update the barber's dashboard after clicking the update button to show the updated info
                    book = new Booking(barNumber);
                    countBooking = model.countBarberBooking(book);
                    viewBookingsList = model.viewBarberBookings(book);    
                    view.barberDashP.removeAll();
                    view.sp.add(view.barberDashboard());
                    view.barHome.revalidate();
                    view.barHome.repaint();
                }
            }
        }
        
        //disposes the search result panel frame and adds the booking panel frame while also updating it if the user made an appointment prior clicking it--------------------------------------------------\\
        if(e.getActionCommand().equals("homeButton")) 
        {
            book = new Booking(custNumber);
            countBooking = model.countBooking(book);
            viewBookingsList = model.viewBookings(book);
            view.dashboardP.removeAll();
            view.sp.add(view.dashboardPanel());

        }
        
        
        
    }
    
    
    
}