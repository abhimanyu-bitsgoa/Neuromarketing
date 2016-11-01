/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import static accubrain.Show.endTime;
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
    static String blankImageID="555";
    static String pauseImageID="888";
    static long startTime=0;
    static long experimentStartTime=0;
    static long experimentEndTime=0;
    static long experimentTotalTime=0;
    static ImageData currentImageObject;
    private static int imageBreakpoint1=31;
    private static int imageBreakpoint2=62;
    static String fixature_ID="FIXS";
    static String pause_ID="PAUS";
    
    
    
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
        /*if(imageID.equals("888")||imageID.equals("555")){
            sendEvent(imageID);
        }*/
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
    
    
    public static String[]  shuffleArray(){ 
            String [] ar=ImageData.getImageNames();
            
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                String a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            
            //Intiliase the ImageData ArrayList
            ImageData.initialiseImageData();
            
            return ar;
       
        
  }
    
    public static void startExperiment(final int imageDelay,int initialDelay,final int blankDelay,final int pauseImageDelay,final String [] arr,final JLabel l1){
        experimentStartTime=System.currentTimeMillis();
        
        Timer timer = new Timer(imageDelay, new ActionListener() {
            BufferedImage img=null;
            int counter=0;
            int index=0;
            boolean pauseInterval=false;
            int pauseCount=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(((Timer)e.getSource()).getDelay()+"");
                if(pauseInterval==false){
                if(counter%2==0){
                if(index<arr.length){
                    
                    currentImageObject=ImageData.getCurrentImageObject();
                    Util.dis(arr[index],l1);
                    Show.sendClick=true;
                    index++;
                    counter++;
                    //System.out.println(counter);
                    
                    if(counter==31||counter==63){
                        
                        pauseInterval=true;
                        
                    }
                    
                    ((Timer)e.getSource()).setDelay(blankDelay);
                    
                    
                    
                }
                else{
                    experimentEndTime=System.currentTimeMillis();
                    experimentTotalTime=experimentEndTime-experimentStartTime;
                    printReactionTimes();
                    ((Timer)e.getSource()).stop();
                    Show.closeConnection();//Graceful closing of socket
                    System.exit(0);
                }
                }
                else{
                    //Insert Blank event here
                    sendEvent(fixature_ID);
                    
                    Util.dis(blankImageID,l1);
                    Show.sendClick=false;
                    counter++;
                    ((Timer)e.getSource()).setDelay(imageDelay);
                }
            }else{
                    
                    
                    //Insert Pause event here
                    sendEvent(pause_ID);
                    doPause(l1);
                    pauseCount++;
                    
                    if(pauseCount==pauseImageDelay){
                        
                        pauseInterval=false;
                        l1.setBackground(Color.black);
                       //Insert Blank event here
                        sendEvent(fixature_ID);
                        
                        Util.dis(blankImageID,l1);
                        Show.sendClick=false;
                        counter++;
                        pauseCount=0;
                        ((Timer)e.getSource()).setDelay(imageDelay);
                        
                    }
                }

            }
            
        });
        timer.setInitialDelay(initialDelay);
        timer.start();
        
        
    }
    
    public static void printReactionTimes(){
        PrintWriter writer=null;
        try {
            
            ArrayList<ImageData> printImageList=ImageData.getImageData();
            
            writer = new PrintWriter(Show.filePath, "UTF-8");
            writer.println("Name , "+Show.userName);
 
           
            int correct=0;
            int total=0;
            String response;
            
            
            
            for(ImageData currentImage:printImageList){
                
                String resultTuple="";
                int imageNumber=currentImage.getImageNumber();
                String currentImageCode=currentImage.imageCode;
                long imageReactionTime=currentImage.imageReactionTime;
                int userResponse=currentImage.userResponse;
                resultTuple+=+imageNumber+","+currentImageCode+","+imageReactionTime;
                
                if(userResponse==-1){
                    resultTuple+=","+"Missed";
                }
                else if(userResponse==1){
                    resultTuple+=","+"Correct";
                    correct++;
                    total++;
                }
                else{
                    resultTuple+=","+"Incorrect";
                    total++;
                }
                writer.println(resultTuple);
            }
            writer.println("");
            writer.println("Total_Images , "+ImageData.getImageNames().length);
            writer.println("Responded , "+total);
            writer.println("Correct , "+correct);
            writer.println("Incorrect , "+(total-correct));
            writer.println("Accuracy , "+((((double)correct)/total)*100));
            writer.println("Experiment_time , "+experimentTotalTime/1000);
            System.out.println("File created successfully");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
    
    public static void doPause(JLabel l1){
    
                        
                        l1.setBackground(Color.white);
                        Util.dis(pauseImageID,l1);
                        
                        //l1.setBackground(Color.black);
                    
    
    }
    
    public static void sendEvent(String name){
    
        try {
                        //Insert blank event
                        if(Show.outToServer!=null){
                            Show.outToServer.write(name.getBytes());
                            Show.outToServer.flush();}
                        else
                          System.out.println("Stream is null");
                    } catch (IOException ex) {
                        Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
}
