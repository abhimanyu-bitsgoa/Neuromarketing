/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author aronzx
 */
public class Show extends javax.swing.JFrame {

    /**
     * Creates new form Show
     */
    int index=0;
    public Show() {
        initComponents();
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        
        Toolkit tk=Toolkit.getDefaultToolkit();
        final int xsize=(int)tk.getScreenSize().getWidth();
        final int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        final int[]arr=shuffleArray(3);
        
        dis(xsize,ysize,1);
        
        
        Timer timer = new Timer(2000, new ActionListener() {
            BufferedImage img=null;
            int counter=0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(counter%2==0){
                if(index<arr.length){
                    
                    System.out.println(arr[index]+" ll"+arr.length);
                    dis(xsize,ysize,arr[index]);
                    index++;
                    counter++;
                    
                    
                }
                else{
                    
                    ((Timer)e.getSource()).stop();
                }
                }
                else{
                    System.out.println("Displaying blank");
                    dis(xsize,ysize,999);
                    System.out.println("Awake");
                    counter++;
                }

            }
            
        });
        timer.start();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accubrain/images/1.jpg"))); // NOI18N
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1)
	    {
	      l1.setText("Detected Mouse Left Click!");
              System.out.println("Left");
              
	    }	    
	    else if(evt.getButton() == MouseEvent.BUTTON3)
	    {
	      l1.setText("Detected Mouse Right Click!");
              System.out.println("Right");
	    }
    }//GEN-LAST:event_l1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        System.out.println("I am up");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                new Show().setVisible(true);
                
               
            }
        });
        
        
        
        
    }
    
    //public int getImageCode();
    public void displayImage(BufferedImage img, Image dimg,int xsize,int ysize,int imgNum){
        try { 
            img = null;
            img = ImageIO.read(getClass().getResourceAsStream("/accubrain/images/"+imgNum+".jpg"));
            dimg = img.getScaledInstance(xsize, ysize,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            l1.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

static int[]  shuffleArray(int range)
  { 
    // If running on Java 6 or older, use `new Random()` on RHS here 
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

public void dis(int xsize,int ysize,int imageID){

        try {
            BufferedImage img = null;
            
            img = ImageIO.read(getClass().getResourceAsStream("/accubrain/images/"+imageID+".jpg"));
            Image dimg = img.getScaledInstance(xsize, ysize,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            l1.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel l1;
    // End of variables declaration//GEN-END:variables
}
