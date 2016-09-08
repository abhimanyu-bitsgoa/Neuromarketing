/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
    int imageDelay=1500;
    int blankDelay=3000;
    int initialDelay=1000;
    static boolean sendClick=false;
    String blankImageID="666";
    String data;
    Socket clientSocket;
    DataOutputStream outToServer;
    String IPAddress="192.168.100.3";
    int portNumber=6789;
    static long endTime=0;
    static long reactionTime=0;
    String arr[];
    static ArrayList<String> reactionList=new ArrayList<String>();
    static ArrayList<String> scoreList=new ArrayList<String>();
    static String filePath="";
    static String userName;
    
    public Show() {
        this.arr = Util.shuffleArray();
        initComponents();
        Util.setScreenDimensions();
        Util.makeFullScreen(l1);
        Util.dis(blankImageID,l1);
       
        
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
        startButton = new javax.swing.JButton();
        connectionButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        tIP = new javax.swing.JTextField();
        tPort = new javax.swing.JTextField();
        lIP = new javax.swing.JLabel();
        lPort = new javax.swing.JLabel();
        tPath = new javax.swing.JTextField();
        lName = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        lPath = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        l1.setBackground(new java.awt.Color(1, 1, 1));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accubrain/images/666.jpg"))); // NOI18N
        l1.setBorder(null);
        l1.setOpaque(true);
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });

        startButton.setText("Start Experiment");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        connectionButton.setText("Connect");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        tIP.setText("10.20.19.64");

        tPort.setText("6789");

        lIP.setText("IP");

        lPort.setText("Port");

        tPath.setText("/home/aronzx/Desktop/Abhi");
        tPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPathActionPerformed(evt);
            }
        });

        lName.setText("Enter Name");

        lPath.setText("File Path");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(connectionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lPort)
                                    .addComponent(lIP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(lPath)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tPath, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tIP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPort, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPath)
                    .addComponent(tPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIP, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(158, 158, 158))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        
        
       
        
        //Code to make the frame exit
        if(evt.getButton() == MouseEvent.BUTTON2){
            closeConnection();
            System.exit(0);
        }
          
        
        if(sendClick==true){
            
             //Code to get the reaction time
        endTime=System.currentTimeMillis();
        reactionTime=(endTime-Util.startTime);
        //reactionList.add(Util.currenImageID+" , "+reactionTime);
            
            sendClick=false;
        if(evt.getButton() == MouseEvent.BUTTON1){
	      data=Util.currenImageID+"R";
              //System.out.println("Left");
              
              
	    }	    
	    else if(evt.getButton() == MouseEvent.BUTTON3){
	      data=Util.currenImageID+"F";
              //System.out.println("Right");
	    }
        
        try {
            
            //outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            outToServer.writeBytes(data + '\n');
            outToServer.flush();
            reactionList.add(data+" , "+reactionTime);
            scoreList.add(data);
           
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
    }//GEN-LAST:event_l1MouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
         //Why works here?
         //b1.setVisible(false);
         Util.makeComponentFullScreen(l1);
         Util.startExperiment(imageDelay, initialDelay, blankDelay, arr, l1);
         this.remove(startButton);   //Why set visible doesnt work
         this.remove(connectionButton);
         this.remove(disconnectButton);
         this.remove(tIP);
         this.remove(tPort);
         this.remove(tPath);
         this.remove(tName);
         this.remove(lIP);
         this.remove(lPort);
         this.remove(lName);
         this.remove(lPath);
         
    }//GEN-LAST:event_startButtonActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        IPAddress= tIP.getText();
        
        portNumber= Integer.parseInt(tPort.getText());
         filePath=tPath.getText();
        userName=tName.getText();
        
        try {
            
            clientSocket = new Socket(IPAddress, portNumber);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(AccuBrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_connectionButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        closeConnection();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON2){
            
            System.exit(0);
        }
           
    }//GEN-LAST:event_formMouseClicked

    private void tPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPathActionPerformed

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
    
    public void closeConnection(){
        try {
            outToServer.writeBytes("#" + '\n');
            outToServer.flush();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectionButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel lIP;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPath;
    private javax.swing.JLabel lPort;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField tIP;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPath;
    private javax.swing.JTextField tPort;
    // End of variables declaration//GEN-END:variables
}
