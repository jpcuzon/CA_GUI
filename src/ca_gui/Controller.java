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
import javax.swing.JOptionPane;

/**
 *
 * @author jonpaulcarlo
 */
public class Controller implements ActionListener
{
    View view;
    Model model;
    String searchBarber;
    String[][] searchBarberResult;
    int countSearch;
    int custNumber;
    int barNumber;
    public Controller()
    {
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("hide")) //shows/hide location
        {
            if(view.userBoxReg.getSelectedItem()=="Customer"){
                view.visible = false;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
                
            }else if(view.userBoxReg.getSelectedItem()=="Barber"){
                view.visible = true;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
            }
       
            
        }
        
        if(e.getActionCommand().equals("goRegister")) //open register page
        {
            view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
            view.Register();
        }
        
            
        if(e.getActionCommand().equals("goLogin")) //opens login page
        {
            view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
            view.login();
            
        }
        
        if(e.getActionCommand().equals("logoutCus")) //logs out and go back to the login page
        {
            int confirmLogOut = JOptionPane.showConfirmDialog(view.cusHome, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if(confirmLogOut==0)
            {
                view.cusHome.dispatchEvent(new WindowEvent(view.cusHome, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                view.login();
            }
            
            
        }
        
        
        if(e.getActionCommand().equals("submit")) //logging in
        {
            String em;
            String pw;
            
            User user;

            boolean result;
            String resultMessage = "Try again with valid credentials";
            //customer
            if(view.userBoxLog.getSelectedItem()=="Customer") 
            {
                em = view.userEmail.getText();
                pw = view.userPassword.getText();

                user = new User(em, pw);

                result = model.loginCustomer(user);
                custNumber = model.getcusNumber(user);
                if(result)
                {
                    resultMessage = "Welcome in";
                    view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                    view.custHome();
                    System.out.println(resultMessage);
                    System.out.println("Welcome customer number: " + custNumber);
                }
                else //pops up whenever the user forgot to pick a user type
                {
                    JOptionPane.showMessageDialog(view.login, "Invalid Credentials. Please Try Again.");
                }
                
            }
                
                else if(view.userBoxLog.getSelectedItem()=="Barber") 
                {
                    em = view.userEmail.getText();
                    pw = view.userPassword.getText();

                    user = new User(em, pw);

                    result = model.loginBarber(user);
                    barNumber = model.getbarNumber(user);

                    if(result)
                    {
                        resultMessage = "Welcome in";
                        System.out.println(resultMessage);
                        System.out.println("Welcome barber number: "+ barNumber);
                    }
                    else//pops up whenever the user forgot to pick a user type
                    {
                        JOptionPane.showMessageDialog(view.login, "Invalid Credentials. Please Try Again.");
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(view.login, "Please Select User Type!");
                }
                
            
            }
        
        //view.setResult(resultMessage);
        
        
        
        if(e.getActionCommand().equals("register")) //test
        {
            if(!view.fName.getText().isEmpty()&& !view.email.getText().isEmpty()&&!view.pNumber.getText().isEmpty()&&!view.password.getText().isEmpty())
            {
                if(view.userBoxReg.getSelectedItem()=="Customer")
                {
                    String fullName = view.fName.getText() + " " + view.lName.getText();
                    String email = view.email.getText();
                    String phone = view.pNumber.getText();
                    String password = view.password.getText();
                    String confirmPass = view.confirmPass.getText();
                    if(!phone.matches("[a-zA-Z]*")&&(phone.length()==10))
                    {
                        if(email.contains("@")&&email.contains("."))
                        {
                            if(password.equals(confirmPass))
                            {
                                CustomerReg cusReg = new CustomerReg(fullName, email, phone, password);

                                    model.CusRegister(cusReg);

                                    String query = "INSERT INTO customers (full_name,email_address, phone_number, password) "
                                            + "VALUES ('"+fullName+"','"+email+"','"+phone+"','"+password+"');";

                                    JOptionPane.showMessageDialog(view.Register, "Go back to the login page", "Registraition Complete!", 1);
                                    view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                                    view.login();
                                    System.out.println(query);
                            }
                            else
                            {
                                System.out.println(password +" "+confirmPass);
                                JOptionPane.showMessageDialog(view.Register, "Password doesn't match!", "Error!", 0);
                            }
                        }else{JOptionPane.showMessageDialog(view.Register, "Invalid email!", "Error!", 0);}
                        
                    }else{JOptionPane.showMessageDialog(view.Register, "Invalid Phone Number", "Error", 0);}
                }
                else if(view.userBoxReg.getSelectedItem()=="Barber") //barber registration
                {
                    String fullName = view.fName.getText() + " " + view.lName.getText();
                    String email = view.email.getText();
                    String phone = view.pNumber.getText();
                    String password = view.password.getText();
                    String confirmPass = view.confirmPass.getText();
                    String location = view.locList.getSelectedItem().toString();
                    if(!phone.matches("[a-zA-Z]*")&&(phone.length()==10))
                    {
                        if(email.contains("@")&&email.contains("."))
                        {

                            if(password.equals(confirmPass))
                            {
                                BarberReg barReg = new BarberReg(fullName, email, phone, password, location);

                                model.BarRegister(barReg);

                                String query = "INSERT INTO barbers (full_name,email_address, phone_number, password, location) "
                                        + "VALUES ('"+fullName+"','"+email+"','"+phone+"','"+password+"','"+location+"');";

                                JOptionPane.showMessageDialog(view.Register, "Go back to the login page", "Registraition Complete!", 1);
                                view.Register.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                                view.login();
                                System.out.println(query);
                            }
                            else
                            {
                                System.out.println(password +" "+confirmPass);
                                JOptionPane.showMessageDialog(view.Register, "Password doesn't match!", "Error!", 0);
                            }
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
        
        
        if(e.getActionCommand().equals("searchBarber"))
        {
            searchBarber = view.searchField.getText();
            BarberReg search = new BarberReg(searchBarber);
//            int countSearch;
            if(view.comboBoxSearch.getSelectedItem().equals("Name"))
            {
                countSearch = model.countSearchB(search);
                if(countSearch==0)
                {
                    view.sp.add(view.noResults());
                }
                else
                {
                    searchBarberResult = model.searchBarber(search);
                    view.dashboardP.removeAll();
                    view.sp.add(view.searchResult());
                    System.out.println(countSearch);
    //                searchBarberResult = model.searchBarber(search);
                }
                
            }
            else
            {
                countSearch = model.countSearchL(search);
                if(countSearch==0)
                {
                    view.sp.add(view.noResults());
                }
                else
                {
                    searchBarberResult = model.searchLocation(search);
                    view.dashboardP.removeAll();
                    view.sp.add(view.searchResult());
                    System.out.println(countSearch);
                }
                
            }

        }
        
        if(e.getActionCommand().equals("bookAppointment"))
        {
            JOptionPane.showMessageDialog(view.cusHome, view.makeBooking(),"Book an Appointmet", JOptionPane.PLAIN_MESSAGE);
            System.out.println();
//            view.dashboardSearchP.dispatchEvent(new WindowEvent(view.Register, WindowEvent.WINDOW_CLOSING));
//            view.cusHome.revalidate();
//            view.cusHome.repaint();
        }
        
        for(int i = 0;i<countSearch;i++)
        {
            if(e.getActionCommand().equals("complaint"+i))
            {   
                JOptionPane.showMessageDialog(view.cusHome, view.complaintPopUp(),"Is there a problem?", JOptionPane.PLAIN_MESSAGE);
                String complaint = view.complaintBox.getText();
                System.out.println(view.complaintBox.getText());
                int custNumberComplaint = custNumber;
                String barberName = searchBarberResult[i][0];
                Complaints complaints = new Complaints(complaint,custNumberComplaint,barberName);
                
                model.placeComplaint(complaints);
                
                
                JOptionPane.showMessageDialog(view.cusHome, "Submission Successful", "Place Complaint", 1);
                

            }
        }
        if(e.getActionCommand().equals("homeButton"))
        {
            System.out.println("Nice");
            view.sp.add(view.dashboardPanel());

        }
        
    }
    
    
        
    
}