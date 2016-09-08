/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
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
    static long startTime=0;
    
    public static void setScreenDimensions(){
        
          Toolkit tk=Toolkit.getDefaultToolkit();
          xsize=(int)tk.getScreenSize().getWidth();
          ysize=(int)tk.getScreenSize().getHeight();
          
    }
    
    public static void makeFullScreen(Object obj){
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) obj);
        topFrame.dispose();
        topFrame.setUndecorated(true);
        //topFrame.pack();
        //topFrame.setLocationByPlatform(true);
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
            startTime=System.currentTimeMillis();
            img = ImageIO.read(l1.getClass().getResourceAsStream("/accubrain/images/"+imageID+".jpg"));
            Image dimg = img.getScaledInstance(500, 500,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            l1.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static String[]  shuffleArray()
  { 
            String [] ar=ImageNames.getImageNames();
            
           
           
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
                    printReactionTimes();
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
        timer.setInitialDelay(initialDelay);
        timer.start();
        
    }
    
    public static void printReactionTimes(){
        PrintWriter writer=null;
        try {
            ArrayList<String> printList=Show.reactionList;
            writer = new PrintWriter(Show.filePath, "UTF-8");
            
            for(String time:printList ){
                
                
                System.out.println(time);
                writer.println(time);
            
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
    
    
}
