/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonpaulcarlo
 */
public class Model 
{
    //logging in
    public boolean loginCustomer(User user)
    {
        
        boolean result = false;
        
        try 
        {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "SELECT * FROM customers WHERE email_address = '" + user.getEm() + "' AND password = '" + user.getPw() + "';";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            if (rs.next()) {
                result = true;
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
        
    }
    
    public boolean loginBarber(User user)
    {
        
        boolean result = false;
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "SELECT * FROM barbers WHERE email_address = '" + user.getEm() + "' AND password = '" + user.getPw() + "';";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            if (rs.next()) {
                result = true;
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
        
    }
    
    //customer registration
    public boolean CusRegister(CustomerReg cusReg)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String update = "INSERT INTO customers (full_name,email_address, phone_number, password)" +
                    "VALUES ('"+cusReg.getCusFN()+"','"+cusReg.getCusEm()+"','"+cusReg.getCusPhone()+"','"+cusReg.getCusPass()+"');";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            //get a statement from the connection
            Statement stmt = conn.createStatement();
            
            //execute the query
            stmt.executeUpdate(update);
            
            stmt.close();
            conn.close();
        
        }catch (SQLException se) 
        {
            System.out.println("SQL Exception: ");
            
            //Loop through the Exceptions
            while(se != null) 
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                
                se = se.getNextException();
            } 
        }catch (Exception e)
        {
            System.out.println(e);
        }
        
        
        return result;
    }
    
    public boolean BarRegister(BarberReg barReg)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String update = "INSERT INTO barbers (full_name,email_address, phone_number, password, location)" +
                    "VALUES ('"+barReg.getBarFN()+"','"+barReg.getBarEm()+"','"+barReg.getBarPhone()+"','"+barReg.getBarPass()+"','"+barReg.getBarLoc()+"');";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            //get a statement from the connection
            Statement stmt = conn.createStatement();
            
            //execute the query
            stmt.executeUpdate(update);
            
            stmt.close();
            conn.close();
        
        }catch (SQLException se) 
        {
            System.out.println("SQL Exception: ");
            
            //Loop through the Exceptions
            while(se != null) 
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                
                se = se.getNextException();
            } 
        }catch (Exception e)
        {
            System.out.println(e);
        }
        
        
        return result;
    }
    
    public int countBarber(){
        
        int count = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "SELECT COUNT(*) FROM barbers";
            
            
            
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            count = rs.getInt(1);
            

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
            
            

            
            
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return count;
    }
    
    public String[] searchBarber(BarberReg search){
        
        int countBarber = 0;
        String[] searchBarberResult = new String[countBarber];
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from barbers where full_name like '%" + search.getSearchBarber() + "%';";
            String searchQuery = "select * from barbers where full_name like '%" + search.getSearchBarber() + "%';";
            
            
            
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countBarber = rs.getInt(1);
            System.out.println(countBarber);
            System.out.println(countQuery);
            String[] searchBarber = new String[countBarber];
//            int testCount = searchBarber.length;
//            System.out.println(testCount);
            
            ResultSet rs2 = stmt.executeQuery(searchQuery);
            int i=0;
            while (rs2.next()) {                     
                
                searchBarber[i] = rs2.getString("full_name");
                i++;
                
//                System.out.println(rs2.getString("full_name")+"Test");
            }
            
            searchBarberResult = searchBarber;
            if(countBarber !=0)
            {
                for(int j=0;j<searchBarberResult.length;j++)
                {
                    System.out.println(searchBarberResult[j]);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Results Found!!", "Error!", 0);
                System.out.println("No Results Found!");
            }
            
            
            // Close the result set, statement and the connection
            rs.close();
            rs2.close();
            stmt.close();
            conn.close();
            
            

            
            
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return searchBarberResult;
    }
    
    public String[] searchLocation(BarberReg search){
        
        int countLocation = 0;
        String[] searchLocationResult = new String[countLocation];
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from barbers where location like '%" + search.getSearchBarber() + "%';";
            String searchQuery = "select * from barbers where location like '%" + search.getSearchBarber() + "%';";
            
            
            
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countLocation = rs.getInt(1);
            System.out.println(countLocation);
            System.out.println(countQuery);
            String[] searchLocation = new String[countLocation];
//            int testCount = searchBarber.length;
//            System.out.println(testCount);
            
            ResultSet rs2 = stmt.executeQuery(searchQuery);
            int i=0;
            while (rs2.next()) {                     
                
                searchLocation[i] = rs2.getString("full_name");
                i++;
                
//                System.out.println(rs2.getString("full_name")+"Test");
            }
            
            searchLocationResult = searchLocation;
            if(countLocation !=0)
            {
                for(int j=0;j<searchLocationResult.length;j++)
                {
                    System.out.println(searchLocationResult[j]);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Results Found!!", "Error!", 0);
                System.out.println("No Results Found!");
            }
            
            
            // Close the result set, statement and the connection
            rs.close();
            rs2.close();
            stmt.close();
            conn.close();
            
            

            
            
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return searchLocationResult;
    }
    
}
