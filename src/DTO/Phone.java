/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Phone implements Comparable<Phone> {
    private String model;
    private String cpu;
    private int ram;
    private int primarycamera;
    private float screensize;
    private int price;
    private String color;
    private String brand;
    
    
    //--------Constructor-------
    public Phone()
    {
        model = "";
        cpu = "";
        ram = 0;
        primarycamera = 0;
        screensize = 0;
        price =0;
        color = "";
        brand = "";
    }

    public Phone(String model, String cpu, int ram, int primarycamera, float screensize, int price, String color, String brand) {
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.primarycamera = primarycamera;
        this.screensize = screensize;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }
    
    //----------------END-----------------------

    
    //--------GET-SET------------
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrimarycamera() {
        return primarycamera;
    }

    public void setPrimarycamera(int primarycamera) {
        this.primarycamera = primarycamera;
    }

    public float getScreensize() {
        return screensize;
    }

    public void setScreensize(float screensize) {
        this.screensize = screensize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
    //---------------END-------------------
    
    
    //---------------IN-OUT-----------------
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        boolean connhap = true;
       
       
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Model: ");
                model = sc.nextLine();
                if(model.isEmpty())
                    throw new Exception();
                connhap = false;

            }
            catch(Exception ex)
            {
                System.out.println("Model can not be empty !!");
                connhap = true;
            }
        }while(connhap);
       
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input CPU: ");
                cpu = sc.nextLine();
                if(cpu.isEmpty())
                    throw new Exception();
                connhap = false;
            }
            catch(Exception ex)
            {
                System.out.println("CPU can not be empty!!");
                connhap = true;
            }
        }while(connhap);
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input RAM: ");
                ram = sc.nextInt();
                if(ram < 0 || ram > 100)
                    throw new Exception();
                connhap = false;
            }
            catch(Exception ex)
            {
                System.out.println("RAM is not available for this phone!!!");
                connhap = true;
            }
        }while(connhap);
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Primary Camera: ");
                primarycamera = sc.nextInt();
                if(primarycamera < 0)
                    throw new Exception();
                connhap = false;
            }
            catch(Exception ex)
            {
                System.out.println("Primary Camera must be higher!!!");
                connhap = true;
            }
        }while(connhap);
          
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Sceensize: ");
                screensize = sc.nextFloat();
                if(screensize < 0)
                    throw new Exception();
                connhap = false;
            }
            catch(Exception ex)
            {
                System.out.println("Screen-size is not true!!!");
                connhap = true;
            }
        }while(connhap);
        
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Price: ");
                price = sc.nextInt();
                if(price < 0)
                    throw new Exception();
                connhap =false;
            }
            catch(Exception ex)
            {
                System.out.println("Price must be higher!!!");
                connhap = true;
            }
        }while(connhap);
        
        
       do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Color: ");
                color = sc.nextLine();
                if(color.isEmpty())
                    throw new Exception();
                connhap =false;
            }
            catch(Exception ex)
            {
                System.out.println("Color can not be empty!!!");
                connhap = true;
            }
        }while(connhap);
       
       
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Brand: ");
                brand = sc.nextLine();
                if(brand.isEmpty())
                    throw new Exception();
                connhap =false;
            }
            catch(Exception ex)
            {
                System.out.println("Brand can not be empty!!!");
                connhap = true;
            }
        }while(connhap);
        
    }
    
   public void output()
    {
        System.out.println("Model: " + model);
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Primary Camera: " + primarycamera + " MP");
        System.out.println("Screen size " + screensize + " inch");
        System.out.println("Price: " + price + " VND");
        System.out.println("Color: "+ color);
        System.out.println("Brand: " + brand);
        
    }

    @Override
    public String toString() {
        return model +","+ cpu +","+ ram +" GB" +","+ primarycamera +" MP" +","+ screensize +" inches"+","+ price +" VND"+","+ color +","+ brand;
    }

    
    
    //-----------------------END---------------------------------
    
    
    //compare to Model de no khong bi trung khi add
    
    @Override
    public int compareTo(Phone p)
    {
        if(model.compareTo(p.getModel()) > 0)
        {
            return -1;
        }
        if(model.compareTo(p.getModel()) < 0)
        {
            return 1;
        }
        return 0;
    }
    
    
   
    
    
    
}
