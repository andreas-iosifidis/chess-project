/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author antre
 */
public class Piece extends Component {
    BufferedImage image;
    
    String Name;
    
    public Piece(String name){
    Name=name;
    
    
    }
    
    
    
  
     
     
     public BufferedImage getImage(  ) {
        try{image=ImageIO.read(new File(Name));}
        catch(IOException e){System.out.println("image not found");}
    return image;
    }

    
   
    
     
     
     
}
