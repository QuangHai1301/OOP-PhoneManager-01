/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Phone;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class ReadWriteFile 
{
    //----------- ghi list vao file--------
    public static void WriteFile(TreeSet<Phone> p)
    {
        try 
                    {
                        FileWriter fw  = new FileWriter("phonelistout.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Phone phone : p) 
                        {
                            bw.write(phone.toString());
                            bw.newLine();
                        }
                        bw.close();
                        fw.close();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e.getMessage());
                    }
    
    }
    //-----------------------------------------------------------
    
    
    //--------------------doc file---------------------------------------
    public TreeSet<Phone> ReadFile()
    {
        TreeSet<Phone> p = new TreeSet<>();
        try 
        {
            FileReader fr = new FileReader("phonelistin.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true)
            {
                line = br.readLine();
                if(line == null)
                {
                    break;
                }
                String txt[] = line.split(",");
                String model = txt[0];
                String CPU = txt[1];
                int ram = Integer.parseInt(txt[2]);
                int primarycamera = Integer.parseInt(txt[3]);
                float screensize = Float.parseFloat(txt[4]);
                int price = Integer.parseInt(txt[5]);
                String color = txt[6];
                String brand = txt[7];
                p.add(new Phone(model, CPU, ram, primarycamera, screensize, price, color, brand));
            }
            
        } 
        catch (Exception e) 
        {
            
        }
        return p;
    }
    //----------------------------------------------------------------------------
}
