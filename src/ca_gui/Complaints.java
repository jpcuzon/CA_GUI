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
public class Complaints 
{
    private String complaints;
    private String barberName;
    private int custNumber;
    
    public Complaints(String complaints,int custNumber, String barberName)
    {
        this.complaints= complaints;
        this.custNumber = custNumber;
        this.barberName = barberName;
    }
    
    public String complaints()
    {
        return complaints;
    }
    public int custNumber()
    {
        return custNumber;
    }
    public String barberName()
    {
        return barberName;
    }
}
