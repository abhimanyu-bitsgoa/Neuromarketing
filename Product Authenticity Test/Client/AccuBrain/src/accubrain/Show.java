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
    int imageDelay=2000;
    int blankDelay=5000;
    int initialDelay=5000;
    int pauseImageDelay=30;
    static boolean sendClick=false;
    String blankImageID="555";
    byte[] data;
    Socket clientSocket;
    DataOutputStream outToServer;
    String IPAddress="10.10.10.45";
    int portNumber=6666;
    String codeString="";
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
        startButton.setVisible(false);
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
        panel1 = new javax.swing.JPanel();
        tPath = new javax.swing.JTextField();
        tPort = new javax.swing.JTextField();
        tIP = new javax.swing.JTextField();
        lPort = new javax.swing.JLabel();
        lIP = new javax.swing.JLabel();
        lPath = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        connectionButton = new javax.swing.JButton();

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

        tPath.setText("/home/aronzx/Desktop/");
        tPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPathActionPerformed(evt);
            }
        });

        tPort.setText("6666");

        tIP.setText("10.10.10.45");

        lPort.setText("Port");

        lIP.setText("IP");

        lPath.setText("File Path");

        lName.setText("Enter Name");

        tName.setText("Abhimanyu");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lIP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPath))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tPath, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(tIP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lPort)
                        .addGap(18, 18, 18)
                        .addComponent(tPort, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94)
                .addComponent(lName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPath)
                    .addComponent(tPath, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lName)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tIP, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(lIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        startButton.setText("Start Experiment");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        connectionButton.setText("Connect");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(connectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(55, 55, 55)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(connectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
	      data=(Util.currenImageID+"R").getBytes();
              codeString=Util.currenImageID+"R";
              //System.out.println("Left");
              Util.currentImageObject.userResponse=1;
              
	    }	    
	    else if(evt.getButton() == MouseEvent.BUTTON3){
	      data=(Util.currenImageID+"F").getBytes();
              codeString=Util.currenImageID+"F";
               //System.out.println("Right");
              Util.currentImageObject.userResponse=0;
	    }
        
        try {
            

            
            outToServer.write(data);
            outToServer.flush();
            Util.currentImageObject.imageCode=codeString;
            Util.currentImageObject.imageReactionTime=reactionTime;

            
        } catch (IOException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
    }//GEN-LAST:event_l1MouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
         //Why works here?
         //b1.setVisible(false);
         Util.makeComponentFullScreen(l1);
         Util.startExperiment(imageDelay, initialDelay, blankDelay,pauseImageDelay/5, arr, l1);
         emptyFrame();
         
         
    }//GEN-LAST:event_startButtonActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        IPAddress= tIP.getText();
        
        portNumber= Integer.parseInt(tPort.getText());
        userName=tName.getText();
        filePath=tPath.getText()+userName+".csv";
        
        
        try {
            
            clientSocket = new Socket(IPAddress, portNumber);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            startButton.setVisible(true);
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
    
    public void emptyFrame(){
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
         this.remove(panel1);
         this.remove(panel2);
    }
    
    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectionButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel lIP;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPath;
    private javax.swing.JLabel lPort;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField tIP;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPath;
    private javax.swing.JTextField tPort;
    // End of variables declaration//GEN-END:variables
}
