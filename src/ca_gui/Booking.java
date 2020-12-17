/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_gui;

/**
 *
 * @author jonpaulcarlo
 */
public class Booking 
{
    private int cusNumberBook;
    private int barNumberBook;
    private String date;           
    private String service;
    private String time;
    private String barberName;
    private String status;
    private String cusNumString;
    
    public Booking(int cusNumberBook,String date,String service,String time,String barberName)
    {
        this.cusNumberBook = cusNumberBook;
        this.date = date;
        this.service = service;
        this.time = time;
        this.barberName = barberName;
    }
    
    public Booking(int cusNumberBook)
    {
        this.cusNumberBook = cusNumberBook;
    }
    
    public Booking(String cusNumString,String date,String service,String time,int barNumberBook, String status)
    {
        this.cusNumString = cusNumString;
        this.date = date;
        this.service = service;
        this.time = time;
        this.barNumberBook = barNumberBook;
        this.status = status;
    }
    
    public int getCus()
    {
        return cusNumberBook;
    }
    public int getBarNumber()
    {
        return barNumberBook;
    }
    public String getDate()
    {
        return date;
    }
    public String getService()
    {
        return service;
    }
    public String getTime()
    {
        return time;
    }
    public String getBar()
    {
        return barberName;
    }
    public String getStatus()
    {
        return status;
    }
    public String getcusNumString()
    {
        return cusNumString;
    }
}
