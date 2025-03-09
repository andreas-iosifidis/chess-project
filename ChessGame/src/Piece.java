/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Component;
import java.awt.Dimension;
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
    int x, y;
    int width;
    int heigth;
    Dimension size;
    String Name;
    String Path;
    String pieceType;

    public Piece(String path, int xPos, int yPos,String ctgry) {
        this.Path = path;
        this.pieceType=ctgry;
        this.getImage();
         this.x = xPos;
         this.y = yPos;
        this.width = image.getWidth();
        this.heigth = image.getHeight();
        this.setFocusable(true);
        this.size = new Dimension(width,heigth);
        this.setMaximumSize(size);
        this.setBounds(xPos, yPos, width, heigth);
        this.setPreferredSize(size);
        this.setSize(size);
        
    }
    public Piece getPiece(){
        return this;
    }

    public Piece copyPiece(Piece piece){
        piece=this;
        return piece;
    }

    public String getName(){
        this.Name=this.Path.substring(this.Path.lastIndexOf("/")+1).trim();
        return this.Name;
    }
    
    public Piece getPieceByPath(String path){
        Piece piece=null;
        if(this.Path.equals(path)){
            piece= this;
        }
        return piece;
    }

    

    @Override
    public String toString(){
        return this.Path;
    }

    public BufferedImage getImage() {
        try {
            image = ImageIO.read(new File(Path));
        } catch (IOException e) {
            System.out.println("image not found");
        }
        return image;
    }

}
