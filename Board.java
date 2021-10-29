/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author antre
 */
public class Board extends Panel implements MouseMotionListener{     
   static Rectangle[][] rectangles;
   
    static String[] letters,numbers;
   
    static Point[][] points;
    int x=0;int y=0;
   
   
    static Piece Wrook1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wrook1.png");
   static Piece Wrook2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wrook2.png");
   static Piece Brook1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Brook1.png");
   static Piece Brook2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Brook2.png");
   static Piece WbishopW=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/WbishopW.png");
   static Piece WbishopB=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/WbishopB.png");
   static Piece BbishopB=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/BbishopB.png");
   static Piece BbishopW=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/BbishopW.png");
  static Piece  Wking=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wking.png");
   static Piece Bking=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bking.png");
   static Piece Wqueen=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wqueen.png");
  static Piece  Bqueen=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bqueen.png");
   static Piece Wknight1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wknight1.png");
   static Piece Wknight2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wknight2.png");
   static Piece Bknight1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bknight1.png");
   static Piece Bknight2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bknight2.png");
  static Piece  Wpawn1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn1.png");
  static Piece  Wpawn2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn2.png");
  static Piece  Wpawn3=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn3.png");
  static Piece  Wpawn4=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn4.png");
  static Piece  Wpawn5=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn5.png");
  static Piece  Wpawn6=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn6.png");
  static Piece  Wpawn7=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn7.png");
  static Piece  Wpawn8=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Wpawn8.png");
  static Piece  Bpawn1=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn1.png");
 static Piece   Bpawn2=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn2.png");
  static Piece  Bpawn3=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn3.png");
  static Piece  Bpawn4=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn4.png");
  static Piece  Bpawn5=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn5.png");
  static Piece  Bpawn6=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn6.png");
  static Piece  Bpawn7=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn7.png");
  static Piece  Bpawn8=new Piece("C:/Users/antre/OneDrive/Desktop/ChessPieces/Bpawn8.png");
    
    
    public Board() {
        
    
   
  
   
   
   
    
    
    BorderLayout border=new BorderLayout();
    setLayout(border);
    
    
    
    
   
   
    
   
   
  
    
        letters=new String[8];
        numbers=new String[8];
        points=new Point[8][8];
        points[0]=new Point[8];
        points[1]=new Point[8];
        points[2]=new Point[8];
        points[3]=new Point[8];
        points[4]=new Point[8];
        points[5]=new Point[8];
        points[6]=new Point[8];
        points[7]=new Point[8];points[0][0]=new Point();
        for(int i=0;i<8;i++){numbers[i]=String.valueOf(i+1);}
        letters[0]="A";
        letters[1]="B";
        letters[2]="C";
        letters[3]="D";
        letters[4]="E";
        letters[5]="F";
        letters[6]="G";
        letters[7]="H";
       // createRectangles();
        
        
       Wrook1.getImage();
       Brook1.getImage();
        
       addMouseMotionListener(this);
  
    
   
    }

   
    
  
    
    
    
   
  
   
        
    
    
    
 
       
         
       
        
        @Override
        public void paint(Graphics g){
            super.paintComponents(g);
           //Graphics2D g= (Graphics2D) gg;
        g.setColor(java.awt.Color.CYAN);
        for(int i=1;i<9;i++){
        {if(i%2==0){g.fillRect(100*i+100, 100, 100, 100);}}
        {if(!(i%2==0)){g.fillRect(100*i+100, 200, 100, 100);}}
        {if(i%2==0){g.fillRect(100*i+100, 300, 100, 100);}}
        {if(!(i%2==0)){g.fillRect(100*i+100, 400, 100, 100);}}
         {if(i%2==0){g.fillRect(100*i+100, 500, 100, 100);}}
       {if(!(i%2==0)){g.fillRect(100*i+100, 600, 100, 100);}}
         {if(i%2==0){g.fillRect(100*i+100, 700, 100, 100);}}
        {if(!(i%2==0)){g.fillRect(100*i+100, 800, 100, 100);}}}
        g.create(200, 100, 100, 100);
       
        g.drawRect(200, 100, 800, 800);
        g.setColor(java.awt.Color.green);
        g.fillRect(150, 50, 40, 860);
        g.fillRect(190, 50, 820, 40);
        g.fillRect(1010, 50, 40, 860);
        g.fillRect(150, 910, 900, 40);
        g.setColor(java.awt.Color.black);g.setFont(new Font("TimesRoman",Font.BOLD,20));
        
        
      
       
        
       g.drawImage(Wrook1.image,x , y, this); 
       g.drawImage(Brook1.image, x+100, y+100, this);
        
        
        
        g.drawString(numbers[7], 165, 155);
        g.drawString(numbers[6], 165, 255);
        g.drawString(numbers[5], 165, 355);
        g.drawString(numbers[4], 165, 455);
        g.drawString(numbers[3], 165, 555);
        g.drawString(numbers[2], 165, 655);
        g.drawString(numbers[1], 165, 755);
        g.drawString(numbers[0], 165, 855);
        
        g.drawString(letters[0], 240, 940);
        g.drawString(letters[1], 340, 940);
        g.drawString(letters[2], 440, 940);
        g.drawString(letters[3], 540, 940);
        g.drawString(letters[4], 640, 940);
        g.drawString(letters[5], 740, 940);
        g.drawString(letters[6], 840, 940);
        g.drawString(letters[7], 940, 940);
        
     
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       this.x=e.getX()-this.x;
       this.y=e.getY()-this.y;repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
        
        
}
    

