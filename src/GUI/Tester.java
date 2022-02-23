/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Phone;
import Manager.PhoneList;
import Manager.ReadWriteFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Admin
 */
public class Tester 
{
    public static void main(String[] args) 
    {
        int choice = 0;
        boolean connhap = true;
        Scanner sc = new Scanner(System.in);
        PhoneList obj = new PhoneList();
        System.out.println("Welcome to HKT Store -@ 2021 by <SE151132-Tran Duy Hieu Trung>");
        obj.ReadFile();
        do
        {
           
            
            System.out.println("---------------MENU---------------");
            System.out.println("1. Add a Phone");
            System.out.println("2. Search a Phone by Model");
            System.out.println("3. Remove a Phone by Model");
            System.out.println("4. Print the phone list in the descending order of Model");
            System.out.println("5. Exit!!");
            
            // try -catch choice
            do
            {
                try
                {
                sc = new Scanner (System.in);
                System.out.println("Input your choice: ");
                choice = sc.nextInt();
                if(choice < 0 || choice > 5)
                    throw new Exception();
                connhap = false;
                }
                catch(Exception ex)
                {
                    System.err.println("Choice must be from 1->5. Type again, please!!!");
                    connhap = true;
                }
            }while(connhap);
            
            //pick case
            switch(choice)
            {
                case 1:
                    Phone tm = new Phone();
                    tm.input();
                    int choice2 =0;
                    boolean connhap2 = true;
                    if(obj.addPhone(tm) == true)
                    {
                        System.out.println("Add a new Phone successfully!!!");
                    }
                    else
                    {
                        System.out.println("Add a new Phone failed!!!");
                    }
                                
                    
                    // tiep tuc add them phone
                    do
                    {
                        System.out.println("Do you want to continue add new Phone ?? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        
                        do
                        {
                            try
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Select your choice: ");
                                choice2 = sc.nextInt();
                                if(choice2 < 0 || choice2 > 3)
                                    throw new Exception();
                                connhap2 = false;
                            }
                            catch(Exception ex)
                            {
                                System.err.println("Just select 1.YES or 2.NO, please!!");
                                connhap2 = true;
                            }
                        }while(connhap2);
                        
                        switch(choice2)
                        {
                            case 1:
                                Phone tm2 = new Phone();
                                tm2.input();
                               if(obj.addPhone(tm2) == true)
                                    {
                                        System.out.println("Add a new Phone successfully!!!");
                                    }
                                    else
                                    {
                                        System.out.println("Add a new Phone failed!!!");
                                    }
                                
                                break;
                                
                            case 2:
                                System.out.println("Back to main menu!!!");
                                break;
                        }
                    }while(choice2 < 2);
                   
                break;
                    
                case 2:
                   String modelcantim = ""; // bien tam de tim model
                   int choice3 =0;
                   boolean connhap3 = true;
                   
                   sc = new Scanner(System.in);
                   System.out.println("Input Model you want to find: ");
                   modelcantim = sc.nextLine();
                   
                   
                   Phone p1 = obj.searchPhone(modelcantim);
                   if(p1 == null)
                   {
                       System.out.println("This Phone Model does not exist!!!");
                   }
                   else
                   {
                        p1.output();
                   }
                   
                   // tiep tuc tim phone
                    do
                    {
                        System.out.println("Do you want to continue find a Phone ?? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        do
                        {
                            try
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Select your choice: ");
                                choice3 = sc.nextInt();
                                if(choice3 < 0 || choice3 > 3)
                                    throw new Exception();
                                connhap3 = false;
                            }
                            catch(Exception ex)
                            {
                                System.err.println("Just select 1.YES or 2.NO, please!!");
                                connhap3 = true;
                            }
                        }while(connhap3);
                        
                        switch(choice3)
                        {
                            case 1:
                                String modelcantim2 = "";
                                sc = new Scanner(System.in);
                                System.out.println("Input Model you want to find: ");
                                modelcantim2 = sc.nextLine();
                                
                                Phone p2 = obj.searchPhone(modelcantim2);
                                if(p2 == null)
                                {
                                    System.out.println("This Phone Model does not exist!!!");
                                }
                                else
                                {
                                     p2.toString();
                                }
                                break;
                                
                            case 2:
                                System.out.println("Back to main menu!!!");
                                break;
                        }
                    }while(choice3 < 2);
                   
                    break;
                    
                case 3:
                   String modelcantim3 = ""; // bien tam de tim model
                   
                   sc = new Scanner(System.in);
                   System.out.println("Input Model you want to delete: ");
                   modelcantim3 = sc.nextLine();
                   
                   obj.removePhone(modelcantim3);
                   
                   break;
                    
                case 4:
                    obj.displayAll();
                    System.out.println("Display done!!!");
                    break;
                    
                case 5:
                    obj.WriteFile();
                    System.out.println("Thanks for using the program!");
                    break;
            }
                    
                    
            
        }while(choice < 5);
        
    }
    
}
