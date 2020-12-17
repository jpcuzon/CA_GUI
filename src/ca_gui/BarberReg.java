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
public class BarberReg 
{
    private String barberRegFName;
    private String barberRegEmail;
    private String barberRegPassword;
    private String barberRegPhone;
    private String barberRegLocation;
    private String searchBarber;
    
    public BarberReg(String barberRegFName, String barberRegEmail, String barberRegPhone, String barberRegPassword, String barberRegLocation)
    {
        this.barberRegFName = barberRegFName;
        this.barberRegEmail = barberRegEmail;
        this.barberRegPassword = barberRegPassword;
        this.barberRegPhone = barberRegPhone;
        this.barberRegLocation = barberRegLocation;
    }

    public BarberReg(String searchBarber)
    {
        this.searchBarber = searchBarber;
    }
    
    public BarberReg(String barberRegEmail, String barberRegPassword)
    {
        this.barberRegEmail = barberRegEmail;
        this.barberRegPassword = barberRegPassword;
    }
    
    
    //for custormer register
    public String getBarFN()
    {
        return barberRegFName;
    }
    
    public String getBarEm()
    {
        return barberRegEmail;
    }
    
    public String getBarPass()
    {
        return barberRegPassword;
    }
    
    public String getBarPhone()
    {
        return barberRegPhone;
    }
    
    public String getBarLoc()
    {
        return barberRegLocation;
    }
    
    public String getSearchBarber()
    {
        return searchBarber;
    }
    
}
