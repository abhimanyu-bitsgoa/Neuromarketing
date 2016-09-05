/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author aronzx
 */
public class Util {
    
    static int xsize=100;
    static int ysize=100;
    static String currenImageID;
    static String blankImageID="666";
    
    public static void setScreenDimensions(){
        
          Toolkit tk=Toolkit.getDefaultToolkit();
          xsize=(int)tk.getScreenSize().getWidth();
          ysize=(int)tk.getScreenSize().getHeight();
          
    }
    
    public static void makeFullScreen(Object obj){
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) obj);
       
        topFrame.setAlwaysOnTop(true);
        topFrame.setResizable(false);
        topFrame.setVisible(true);
        topFrame.setSize(xsize,ysize);
        
    }
  
    
    public static void makeComponentFullScreen(Component comp){
        comp.setSize(xsize, ysize);
        
    }
    
    
    public static void dis(String imageID,JLabel l1){

        try {
            currenImageID=imageID;
            BufferedImage img = null;
            img = ImageIO.read(l1.getClass().getResourceAsStream("/accubrain/images/"+imageID+".jpg"));
            Image dimg = img.getScaledInstance(xsize, ysize,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            l1.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static String[]  shuffleArray()
  { 
            String [] ar=ImageNames.getImageNames();
            
            
           /*
            Non functional code to get all the Image file listings
            BufferedReader br = new BufferedReader(new InputStreamReader(Show.class.getResourceAsStream("/accubrain/images/")));
            
            String fileName;
            int k=0;
        try {
            while((fileName = br.readLine()) != null){
                if(fileName.substring(0,3).equals("666")){
                    continue;
                }
                ar[k++]=fileName.substring(0,3);
                //System.out.println(fileName.substring(0,3));
                
            }*/
           
           
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                String a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            for(int i=0;i<ar.length;i++)
                System.out.println(ar[i]+" ");
            return ar;
       
        
  }
    
    public static void startExperiment(final int imageDelay,int initialDelay,final int blankDelay,final String [] arr,final JLabel l1){
    
        Timer timer = new Timer(imageDelay, new ActionListener() {
            BufferedImage img=null;
            int counter=0;
            int index=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((Timer)e.getSource()).getDelay()+"");
                if(counter%2==0){
                if(index<arr.length){
                    
                    System.out.println(arr[index]+" Image");
                    Util.dis(arr[index],l1);
                    Show.sendClick=true;
                    index++;
                    counter++;
                    ((Timer)e.getSource()).setDelay(blankDelay);
                    
                    
                }
                else{
                    
                    ((Timer)e.getSource()).stop();
                }
                }
                else{
                    System.out.println("Displaying blank");
                    Util.dis(blankImageID,l1);
                    Show.sendClick=false;
                    counter++;
                    ((Timer)e.getSource()).setDelay(imageDelay);
                }

            }
            
        });
        timer.setInitialDelay(1000);
        timer.start();
        
    }
    
    
}
