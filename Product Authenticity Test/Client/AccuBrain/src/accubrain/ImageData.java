/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accubrain;

import java.util.ArrayList;

/**
 *
 * @author aronzx
 */
public class ImageData {
    
    private int imageNumber=0;
    String imageCode;
    long imageReactionTime=0;
    int userResponse=-1;
    private static int currentImagePosition=0;
    
    
    ImageData(int imageNumber,String imageCode,long imageReactionTime,int userResponse){
        this.imageNumber=imageNumber;
        this.imageCode=imageCode;
        this.imageReactionTime=imageReactionTime;
        this.userResponse=userResponse;
    }
    
    private static String[] nameArray={"00R","01R","03R","04R","04R","04R","05R","06R","07R","09R","10R","12R","13R","14F","15R","16R","17R","18F","19R","20R","21R","22R","23R","25R","26R","27R","28R","29R","30R","32R","33R","34R","35R","36R","37R","38R","39R","40R","42R","42R","42R","44R","45R","47R","47R","47R","48R","49R","51R","52R","53R","55R","56R","58R","59R","61F","63R","64R","65R","66R","68R","69R","70R","71R","72R","72R","72R","73R","75F","76R","77F","78F","79F","80R","81R","82F","84F","85F","85F","85F","86F","89F","90F","91F","92F","93F","95F","97F","98F","99F","11F","43F","46F","24F"};
    private static ArrayList<ImageData>imageData=new ArrayList<ImageData>();
    
    public static String[] getImageNames(){
        return nameArray;
    }
    
    public static void initialiseImageData(){
        int k=0;
        
        for(String imageID:nameArray){
            
            imageData.add(new ImageData(k,imageID,0,-1));
            k++;
        }
        
    }
    
    public static ImageData getCurrentImageObject(){
        
        return imageData.get(currentImagePosition++);
        
    }
    
    public static ArrayList<ImageData>getImageData(){
        return imageData;
    }
    
    public int getImageNumber(){
        return this.imageNumber;
    
    }
    
}
