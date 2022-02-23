/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Phone;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class PhoneList 
{
    TreeSet<Phone> p = new TreeSet<>();
    ReadWriteFile rwf = new ReadWriteFile();
   
    public PhoneList() 
    {
        
        p = rwf.ReadFile();
    }
    
    
    
    // add phone vao tree
    public boolean addPhone(Phone ph)
    {
        return p.add(ph);
        
    }
    //-----------------------------------
    
    
    //------------------- search phone------------- 
    public Phone searchPhone(String model)
    {
        for (Phone phone : p) 
        {
           if(phone.getModel().contains(model))
           {
              
               return phone;
           }
        }
        return null ;
    }
    //-----------------------------------------
    
    
    //----------------- xoa phone----------------
    public void removePhone(String model)
    {
       Phone kq = searchPhone(model);
       int choice =0;
       boolean connhap = true;
       Scanner sc = new Scanner(System.in);
       if(kq == null)
       {
           System.out.println("Phone is not exist!!");
       }
       if(kq != null)
       {
           System.out.println("Do you really want to remove this Phone ??");
           System.out.println("1. Yes");
           System.out.println("2. No");
           
           // try-catch lua chon cua nguoi dung xem co xoa phone hay ko
           do
           {
               try
               {
                    sc = new Scanner(System.in);
                    System.out.println("Select your option: ");
                    choice = sc.nextInt();
                    if(choice <0 || choice >3)
                        throw new Exception();
                    connhap = false;
               }
               catch(Exception ex)
               {
                   System.out.println("Just select 1.YES or 2.NO");
                   connhap =true;
               }
           }while(connhap);   
           
           switch(choice)
           {
               case 1:
                   p.remove(kq);
                   System.out.println("Remove Phone successfully!!");
                   break;
                   
               case 2:
                   System.out.println("Back to main menu!");
                   break;
           }
       }
       
    }
    //---------------------------------------------------------------------------
    
    
    //----------display all phone---------------
    public void displayAll()
    {
        for (Phone phone : p) 
        {
            System.out.println(phone);
        }
    }
    //-------------------------------------------
    
    
    //---------------Write File------------------
    public void WriteFile()
    {
        for (Phone phone : p) 
        {
            ReadWriteFile.WriteFile(p);
        }
    }
    
    public void ReadFile()
            
    {
        p = rwf.ReadFile();
        for (Phone phone : p) 
        {
            System.out.println(phone);
        }
    }
}
