/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

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
            System.out.println(view.userBoxReg.getSelectedItem());
            if(view.userBoxReg.getSelectedItem()=="Customer"){
                view.visible = false;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
                
                
            }else if(view.userBoxReg.getSelectedItem()=="Barber"){
                view.visible = true;
                view.locList.setVisible(view.visible);
                view.putLoc.setVisible(view.visible);
            }
            System.out.println(view.visible);
            
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

                //resultMessage = "Try again with valid credentials";

                if(result)
                {
                    resultMessage = "Welcome in";
                    view.login.dispatchEvent(new WindowEvent(view.login, WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
                    view.custHome();
                    System.out.println(resultMessage);
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

                    //resultMessage = "Try again with valid credentials";

                    if(result)
                    {
                        resultMessage = "Welcome in";
                        System.out.println(resultMessage);
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
                //System.out.println(resultMessage);
            
            }
        
        //view.setResult(resultMessage);
        
        
        
        if(e.getActionCommand().equals("register")) //test
        {
            
            if(view.userBoxReg.getSelectedItem()=="Customer")
            {
                String fullName = view.fName.getText() + " " + view.lName.getText();
                String email = view.email.getText();
                String phone = view.pNumber.getText();
                String password = view.password.getText();

                CustomerReg cusReg = new CustomerReg(fullName, email, phone, password);

                boolean result = model.CusRegister(cusReg);

                String query = "INSERT INTO customers (full_name,email_address, phone_number, password) "
                        + "VALUES ('"+fullName+"','"+email+"','"+phone+"','"+password+"');";
                System.out.println(query);
            }
            else if(view.userBoxReg.getSelectedItem()=="Barber") //barber registration
            {
                String fullName = view.fName.getText() + " " + view.lName.getText();
                String email = view.email.getText();
                String phone = view.pNumber.getText();
                String password = view.password.getText();
                String location = view.locList.getSelectedItem().toString();

                BarberReg barReg = new BarberReg(fullName, email, phone, password, location);

                boolean result = model.BarRegister(barReg);

                String query = "INSERT INTO barbers (full_name,email_address, phone_number, password, location) "
                        + "VALUES ('"+fullName+"','"+email+"','"+phone+"','"+password+"','"+location+"');";
                System.out.println(query);
                
            }
            else
            {
                JOptionPane.showMessageDialog(view.Register, "Please Select User Type!");
            }
            
        }
        
        
    }
    
    
}
