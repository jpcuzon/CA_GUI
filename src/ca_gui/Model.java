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

/**
 *
 * @author jonpaulcarlo
 */
public class Model 
{
    
    //Login and registration------------------------------------------------------------------------------------------------------------------------------------------\\
    
    //checking the database if there's a match for email and password and logs the customer in-----------------
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
    
    //grabs the customer's id from the database when logging in
    public int getcusNumber(User user)
    {
        int customerNumber=0;
        
        try {

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
            rs.next();
            customerNumber = rs.getInt("customer_number");
            

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
        
        return customerNumber;
        
    }
    
    //checking the database if there's a match for email and password and logs the barber in----------------------
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
    
    //grabs the barber's id from the database when logging in--------------------------------------
    public int getbarNumber(User user)
    {
        int barberNumber=0;
        
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
            rs.next();
            barberNumber = rs.getInt("barber_number");
            

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
        
        return barberNumber;
        
    }
    
    //adds the customer's details for registration to the database-------------------------------
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
    
    ////adds the barber's details for registration to the database--------------------------
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
    
    //searching barber---------------------------------------------------------------------------------------------------------------------------------------------------------\\

    //counts the search through name results
    public int countSearchB(BarberReg search){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from barbers where full_name like '%" + search.getSearchBarber() + "%';"; 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
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
        
        return countResult;
    }
    
    //counts the search through location results-----------------------------------
    public int countSearchL(BarberReg search){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from barbers where location like '%" + search.getSearchBarber() + "%';"; 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
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
        
        return countResult;
    }
    
    //Search barber through name--------------------------------------------------
    public String[][] searchBarber(BarberReg search)
    {
        
        int countBarber = countSearchB(search);
        String[][] searchBarberResult = new String[countBarber][2];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "select * from barbers where full_name like '%" + search.getSearchBarber() + "%';";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] searchBarber = new String[countBarber][2];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            while (rs.next()) {                     
                
                searchBarber[row][0] = rs.getString("full_name");
                searchBarber[row][1] = rs.getString("location");
                row++;
                
            }
            
            searchBarberResult = searchBarber;

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
        
        return searchBarberResult;
    }
    
    //Search barber through location------------------------------------------------
    public String[][] searchLocation(BarberReg search)
    {
        int countBarber = countSearchL(search);
        String[][] searchBarberResult = new String[countBarber][2];
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "select * from barbers where location like '%" + search.getSearchBarber() + "%';";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] searchBarber = new String[countBarber][2];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            while (rs.next()) {                     
                
                searchBarber[row][0] = rs.getString("full_name");
                searchBarber[row][1] = rs.getString("location");
                row++;
                
            }
            
            searchBarberResult = searchBarber;

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
        
        return searchBarberResult;
    }
    
    
    //Complaints-------------------------------------------------------------------------------------------------------------------------------------------\\
    
    //submits a complaint to the barber
    public boolean placeComplaint(Complaints complaints)
    {
        boolean result = false;
        int barNumber = complainBarNumber(complaints);
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String complain = "INSERT INTO complaints (complaint, customer_number, barber_number)" +
                    " VALUES ('"+complaints.complaints()+"','"+complaints.custNumber()+"', "+ barNumber+");";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            //get a statement from the connection
            Statement stmt = conn.createStatement();

            //execute the query
            stmt.executeUpdate(complain);
            
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
    
    //grabs the barber's id that's being complaint against----------------------------
    public int complainBarNumber(Complaints complaints){
        
        int barNumber = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String getBarNumber ="select barber_number from barbers where full_name = '"+ complaints.barberName()+"';";
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(getBarNumber);
            
            
            rs.next();
            barNumber = rs.getInt("barber_number");
            
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
        
        return barNumber;
    }
    
     //retrieves all the complaints that a barber have--------------------------------
    public String[][] getComplaints(Complaints barNumber){
        
        int complaintCount = countComplaint(barNumber);
        String[][] complaints = new String[complaintCount][2];
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "select customers.full_name,complaints.complaint\n" +
                            "from complaints\n" +
                            "join customers\n" +
                            "on complaints.customer_number = customers.customer_number\n" +
                            "where barber_number="+barNumber.barberNumber()+";";
            
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement test = conn.createStatement();
            
            
            ResultSet rs = test.executeQuery(query);

            
            // Loop through the result set
            int row = 0;
            while (rs.next()) {                     
                
                complaints[row][0] = rs.getString("full_name");
                complaints[row][1] = rs.getString("complaint");
                
                row++;
            }

            // Close the result set, statement and the connection
            rs.close();
            test.close();
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
        
        return complaints;
        
    }
     
    //count the number of complaints a barber have ----------------------------------
    public int countComplaint(Complaints barNumber){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from complaints where barber_number = "+barNumber.barberNumber()+";"; 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
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
        
        return countResult;
    }
     
    
     //Bookings-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
     
    //Customer-------------------------------------------------------------------------------------------------------------------------------\\
    
    //place a booking to the database-----------------------------------------------
    public boolean placeBooking(Booking book)
    {
        boolean result = false;
        int barNumber = bookBarNumber(book);
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String booking = "INSERT INTO bookings (service_type, time, date,customer_number,barber_number,status)" +
                    " VALUES ('"+book.getService()+"','"+book.getTime()+"', '"+book.getDate()+"', "+book.getCus()+", "+ barNumber+",'Pending');";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
            
            //get a statement from the connection
            Statement stmt = conn.createStatement();

            //execute the query
            stmt.executeUpdate(booking);
            
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
    
    //checks the availability of the slot selected------------------------------------
    public boolean checkAvailability(Booking book)
    {
        
        boolean result = false;
        
        try 
        {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "Select * from bookings where time = '"+book.getTime()+"' and date = '"+ book.getDate()+"';";

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
        
    //counts the number of bookings a customer have-------------------------------------
    public int countBooking(Booking book){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from bookings where customer_number = "+book.getCus()+";"; 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
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
        
        return countResult;
    }
    
    //calls all the details of all the bookings a customer have-------------------------
    public String[][] viewBookings(Booking bookings)
    {
        
        int countBarber = countBooking(bookings);
        String[][] bookingListFinal = new String[countBarber][7];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "select * from bookings join barbers\n" +
                                    "on bookings.barber_number = barbers.barber_number\n" +
                                    "where customer_number = " + bookings.getCus() + " ORDER BY date, time;";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] bookingList = new String[countBarber][7];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            while (rs.next()) {                     
                
                bookingList[row][0] = rs.getString("date");
                bookingList[row][1] = rs.getString("time");
                bookingList[row][2] = rs.getString("service_type");
                bookingList[row][3] = rs.getString("full_name");
                bookingList[row][4] = rs.getString("location");
                bookingList[row][5] = rs.getString("barber_number");
                bookingList[row][6] = rs.getString("status");
                row++;
                
            }
            
            bookingListFinal = bookingList;

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
        
        return bookingListFinal;
    }
     
    //cancels and deletes a booking of a customer--------------------------------------
    public boolean cancelBooking(Booking book)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String booking = "DELETE FROM bookings where service_type = '" + book.getService() +
                            "' and date = '"+book.getDate()+ "' and time = '"+book.getTime()+ 
                            "' and customer_number = "+book.getCus()+" and barber_number = "+book.getBar()+";";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
            
            //get a statement from the connection
            Statement stmt = conn.createStatement();

            //execute the query
            stmt.executeUpdate(booking);
            
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
    
    
    //Barber-----------------------------------------------------------------------------------------------------------------------------------\\
    
    //retrieves the barber's id using the barber's name
    public int bookBarNumber(Booking book){
        
        int barNumber = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String getBarNumber ="select barber_number from barbers where full_name = '"+ book.getBar()+"';";
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(getBarNumber);
            
            
            rs.next();
            barNumber = rs.getInt("barber_number");
            
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
        
        return barNumber;
    }
    
    //counts the number of bookings the barber have----------------------------------
    public int countBarberBooking(Booking book){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "select count(*) from bookings where barber_number = "+book.getCus()+";"; 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
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
        
        return countResult;
    }
    
    //view all the details of all the barber's bookings-----------------------------------
    public String[][] viewBarberBookings(Booking bookings)
    {
        
        int countBarber = countBarberBooking(bookings);
        String[][] bookingListFinal = new String[countBarber][7];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "select * from bookings join customers\n" +
                                    "on bookings.customer_number = customers.customer_number\n" +
                                    "where barber_number = " + bookings.getCus() + " ORDER BY date desc, time desc;";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] bookingList = new String[countBarber][7];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            while (rs.next()) {                     
                
                bookingList[row][0] = rs.getString("date");
                bookingList[row][1] = rs.getString("time");
                bookingList[row][2] = rs.getString("service_type");
                bookingList[row][3] = rs.getString("full_name");
                bookingList[row][5] = rs.getString("customer_number");
                bookingList[row][6] = rs.getString("status");
                row++;
                
            }
            
            bookingListFinal = bookingList;
            
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
        
        return bookingListFinal;
    }
    
    //updates the status of a booking ----------------------------------------------
    public boolean updateBooking(Booking book)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String booking = "update bookings set status = '"+book.getStatus()+ "' where service_type = '" + book.getService() +
                            "' and date = '"+book.getDate()+ "' and time = '"+book.getTime()+ 
                            "' and customer_number = "+book.getcusNumString()+" and barber_number = "+book.getBarNumber()+";";

            
            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
            
            //get a statement from the connection
            Statement stmt = conn.createStatement();

            //execute the query
            stmt.executeUpdate(booking);
            
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
    
    
    //Getting names---------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    
    //grabs the customer's name-----------------------------------------------------
    public String getCusName(CustomerReg getname)
    {
        String searchCustomerResult = null;

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String getName = "select full_name from customers where email_address like '" + getname.getCusEm() +"' and password like '"+ getname.getCusPass() + "';";
 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(getName);
            rs.next();
            
            searchCustomerResult = rs.getString("full_name");
            
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
        
        return searchCustomerResult;
    }
     
    //gets the barber's name-----------------------------------------------------------
    public String getBarName(BarberReg getname)
    {
        String searchBarberResult = null;

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String getName = "select full_name from barbers where email_address like '" + getname.getBarEm()+"' and password like '"+ getname.getBarPass()+ "';";
 
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(getName);
            rs.next();
            
            searchBarberResult = rs.getString("full_name");
            
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
        
        return searchBarberResult;
    }
    
}
