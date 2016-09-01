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
import java.io.IOException;
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
    
    
    public static void dis(int imageID,JLabel l1){

        try {
            BufferedImage img = null;
            img = ImageIO.read(l1.getClass().getResourceAsStream("/accubrain/images/"+imageID+".jpg"));
            Image dimg = img.getScaledInstance(xsize, ysize,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            l1.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static int[]  shuffleArray(int range)
  { 
    
    int[] ar=new int[range];
    for(int i=0;i<range;i++){
        ar[i]=i+1;
    }
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    { 
      int index = rnd.nextInt(i + 1);
      // Simple swap 
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    } 
    for(int i=0;i<ar.length;i++)
        System.out.println(ar[i]+" ");
    return ar;
  }
    
    public static void startExperiment(final int imageDelay,int initialDelay,final int blankDelay,final int [] arr,final JLabel l1){
    
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
                    Util.dis(666,l1);
                   
                    counter++;
                    ((Timer)e.getSource()).setDelay(imageDelay);
                }

            }
            
        });
        timer.setInitialDelay(1000);
        timer.start();
        
    }
    
    
}
