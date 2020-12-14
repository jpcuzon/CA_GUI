///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ca_gui;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author jonpaulcarlo
// */
//public class dbFetch 
//{
//    View view;
//    
//    String fullName;
//    String emailLogged = view.userEmail.getText();
////    public String fetchFullName()
////    {
////        String query;
////        //String emailLogged = view.userEmail.getText();
////        try
////        {
////            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
////            String dbUser = "Jon_2019395";
////            String dbPassword = "2019395";
////            query = "SELECT Full_name FROM customers where email_address="+emailLogged +";\"";
////
////            //Get a connection to the database
////            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
////
////            //get a statement from the connection
////            Statement stmt = conn.createStatement();
////            
////            //execute the query
////            ResultSet rs = stmt.executeQuery(query);
////            
////            rs.close();
////            stmt.close();
////            conn.close();
////            fullName = rs.getString("full_name");
////        }catch (SQLException se) 
////        {
////            System.out.println("SQL Exception: ");
////            
////            //Loop through the Exceptions
////            while(se != null) 
////            {
////                System.out.println("State  : " + se.getSQLState());
////                System.out.println("Message: " + se.getMessage());
////                System.out.println("Error  : " + se.getErrorCode());
////                
////                se = se.getNextException();
////            } 
////        }catch (Exception e)
////        {
////            System.out.println(e);
////        }
////        //System.out.println(query);
////        
////        
////        return fullName;
////    }
////    
////    public String callingDB(User user){
////        
////        String fullName;
////        
////        try
////        {
////            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
////            String dbUser = "Jon_2019395";
////            String dbPassword = "2019395";
////            String query = "SELECT Full_name FROM customers where email_address="+user.getEm() +" AND password ="+ user.getPw()+";\"";
////            
////            
////            
////            
////            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
////            
////            Statement test = conn.createStatement();
////            
////            
////            ResultSet rs = test.executeQuery(query);
////
////            
////            // Loop through the result set
////            int row = 0;
////            while (rs.next()) {                     
////                
////                data[row][0] = rs.getString("id");
////                data[row][1] = rs.getString("first_name");
////                data[row][2] = rs.getString("student_number");
////                
////                row++;
////                //System.out.println(rs.getString("id") + "\t" + rs.getString("first_name") + "\t" + rs.getString("student_number"));
////            }
////
////            // Close the result set, statement and the connection
////            rs.close();
////            test.close();
////            conn.close();
////            
////            
////
////            
////            
////        } catch (SQLException se) {
////            System.out.println("SQL Exception:");
////
////            // Loop through the SQL Exceptions
////            while (se != null) {
////                System.out.println("State  : " + se.getSQLState());
////                System.out.println("Message: " + se.getMessage());
////                System.out.println("Error  : " + se.getErrorCode());
////
////                se = se.getNextException();
////            }
////        } catch (Exception e) {
////            System.out.println(e);
////        }
////        
////        return data;
////        
////    }
//    
//}
