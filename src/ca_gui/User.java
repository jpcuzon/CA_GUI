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
public class User 
{
    private String em;
    private String pw;
    
    
    public User(String em, String pw){
        this.em = em;
        this.pw = pw;
    }
    private String cusRegFName;
    private String cusRegEmail;
    private String cusRegPassword;
    private String cusRegPhone;
    
    public User(String cusRegFName, String cusRegEmail, String cusRegPassword, String cusRegPhone)
    {
        this.cusRegFName = cusRegFName;
        this.cusRegEmail = cusRegEmail;
        this.cusRegPassword = cusRegPassword;
        this.cusRegPhone = cusRegPhone;
    }

    //for login
    public String getEm() 
    {
        return em;
    }

    public String getPw() 
    {
        return pw;
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
