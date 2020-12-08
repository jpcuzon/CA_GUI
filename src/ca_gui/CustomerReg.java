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
public class CustomerReg 
{
    private String cusRegFName;
    private String cusRegEmail;
    private String cusRegPassword;
    private String cusRegPhone;
    
    public CustomerReg(String cusRegFName, String cusRegEmail, String cusRegPhone, String cusRegPassword)
    {
        this.cusRegFName = cusRegFName;
        this.cusRegEmail = cusRegEmail;
        this.cusRegPassword = cusRegPassword;
        this.cusRegPhone = cusRegPhone;
    }

    
    //for custormer register
    public String getCusFN()
    {
        return cusRegFName;
    }
    
    public String getCusEm()
    {
        return cusRegEmail;
    }
    
    public String getCusPass()
    {
        return cusRegPassword;
    }
    
    public String getCusPhone()
    {
        return cusRegPhone;
    }
    
    
}
