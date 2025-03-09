/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.accessibility.AccessibleContext;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author antre
 */
public class Board extends JPanel implements MouseMotionListener, MouseListener {
  enum type {king, queen, bishop, knight, rook, pawn};
  String[] letters, numbers, reverseNumbers;
  BorderLayout border;
  Map<String, Point> square;
  Map<String, JPanel> squarePanel;
  Point[][] squarePoint;
  JPanel[][] tiles;
  ArrayList<Piece> pieceSet;
  JPanel dropLocation;
  Piece draggedPiece;
  Point dragOffset;
  BufferedImage dragImage;
  Point currentDragLocation;
  boolean startingPosition;
  boolean clickedPiece;
  boolean movedPiece;
  boolean pieceReleased;

  Piece Wrook1 = new Piece("ChessPieces/Wrook1.png", 0, 0, type.rook.toString());
  Piece Wrook2 = new Piece("ChessPieces/Wrook2.png",0, 0,type.rook.toString());
  Piece Wqueen = new Piece("ChessPieces/Wqueen.png",0, 0,type.queen.toString());
  Piece Wpawn8 = new Piece("ChessPieces/Wpawn8.png",0, 0,type.pawn.toString());
  Piece Wpawn7 = new Piece("ChessPieces/Wpawn7.png",0, 0,type.pawn.toString());
  Piece Wpawn6 = new Piece("ChessPieces/Wpawn6.png",0, 0,type.pawn.toString());
  Piece Wpawn5 = new Piece("ChessPieces/Wpawn5.png",0, 0,type.pawn.toString());
  Piece Wpawn4 = new Piece("ChessPieces/Wpawn4.png",0, 0,type.pawn.toString());
  Piece Wpawn3 = new Piece("ChessPieces/Wpawn3.png",0, 0,type.pawn.toString());
  Piece Wpawn2 = new Piece("ChessPieces/Wpawn2.png",0, 0,type.pawn.toString());
  Piece Wpawn1 = new Piece("ChessPieces/Wpawn1.png",0, 0,type.pawn.toString());
  Piece Wking = new Piece("ChessPieces/Wking.png",0,0, type.king.toString());
  Piece WbishopB = new 
  Piece("ChessPieces/WbishopB.png",0,0,type.bishop.toString());
  Piece WbishopW = new
  Piece("ChessPieces/WbishopW.png",0,0,type.bishop.toString());
  Piece Wknight1 = new
  Piece("ChessPieces/Wknight1.png",0,0,type.knight.toString());
  Piece Wknight2 = new
  Piece("ChessPieces/Wknight2.png",0,0,type.knight.toString());

  Piece Brook1 = new Piece("ChessPieces/Brook1.png", 0, 0, type.rook.toString());
  Piece Brook2 = new Piece("ChessPieces/Brook2.png",0,0,type.rook.toString());
  Piece Bpawn1 = new Piece("ChessPieces/Bpawn1.png",0,0,type.pawn.toString());
  Piece Bpawn2 = new Piece("ChessPieces/Bpawn2.png",0,0,type.pawn.toString());
  Piece Bpawn3 = new Piece("ChessPieces/Bpawn3.png",0,0,type.pawn.toString());
  Piece Bpawn4 = new Piece("ChessPieces/Bpawn4.png",0,0,type.pawn.toString());
  Piece Bpawn5 = new Piece("ChessPieces/Bpawn5.png",0,0,type.pawn.toString());
  Piece Bpawn6 = new Piece("ChessPieces/Bpawn6.png",0,0,type.pawn.toString());
  Piece Bpawn7 = new Piece("ChessPieces/Bpawn7.png",0,0,type.pawn.toString());
  Piece Bpawn8 = new Piece("ChessPieces/Bpawn8.png",0,0,type.pawn.toString());
  Piece Bknight1 = new
  Piece("ChessPieces/Bknight1.png",0,0,type.knight.toString());
  Piece Bknight2 = new
  Piece("ChessPieces/Bknight2.png",0,0,type.knight.toString());
  Piece BbishopW = new
  Piece("ChessPieces/BbishopW.png",0,0,type.bishop.toString());
  Piece BbishopB = new
  Piece("ChessPieces/BbishopB.png",0,0,type.bishop.toString());
  Piece Bqueen = new Piece("ChessPieces/Bqueen.png",0,0,type.queen.toString());
  Piece Bking = new Piece("ChessPieces/Bking.png",0,0,type.king.toString());

  public Board() {
    // p.add(this);
    border = new BorderLayout();

    //border.addLayoutComponent(this, BorderLayout.CENTER);
    this.startingPosition = true;
    this.setOpaque(true);
    //GridLayout grid=new GridLayout(8,8); 
    this.setLayout(null);
   
     this.setSize(new Dimension(1200,1200));
     this.setMaximumSize(getSize());
     this.setMinimumSize(getSize());
     this.setPreferredSize(getSize());
    letters = new String[8];
    letters[0] = "A";
    letters[1] = "B";
    letters[2] = "C";
    letters[3] = "D";
    letters[4] = "E";
    letters[5] = "F";
    letters[6] = "G";
    letters[7] = "H";

    numbers = new String[8];
    for (int i = 0; i < 8; i++) {
      numbers[i] = String.valueOf(i + 1);
    }
    square=new HashMap<String, Point>();
    squarePoint= new Point[8][8];
    tiles= new JPanel[8][8];
    
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        tiles[i][j]=new JPanel(){
          @Override
          public void paint(Graphics g){
            super.paintComponent(g);
          }
        };
        
        tiles[i][j].setSize(100,100);
        tiles[i][j].setMaximumSize(tiles[i][j].getSize());
        tiles[i][j].setMinimumSize(tiles[i][j].getSize());
        tiles[i][j].setPreferredSize(tiles[i][j].getSize());
        tiles[i][j].setOpaque(true);
        tiles[i][j].setLocation(100*j+300, i*100+100); 
        //tiles[i][j].setLayout(new BorderLayout());;
        tiles[i][j].setBorder(BorderFactory.createEmptyBorder());
        tiles[i][j].setName(letters[j]+""+numbers[numbers.length-1-i]);
        tiles[i][j].setVisible(true);
        squarePoint[i][j]=new Point(100*j+300, i*100+100);
        square.put(tiles[i][j].getName(),squarePoint[i][j]);

        this.add(tiles[i][j]);
        
      }
    }
    
    this.getTileByName("A1").add(Wrook1);
    this.getTileByName("B1").add(Wknight1);
    this.getTileByName("C1").add(WbishopB);
    this.getTileByName("D1").add(Wqueen);
    this.getTileByName("E1").add(Wking);
    this.getTileByName("F1").add(WbishopW);
    this.getTileByName("G1").add(Wknight2);
    this.getTileByName("H1").add(Wrook2);
    this.getTileByName("A2").add(Wpawn1);
    this.getTileByName("B2").add(Wpawn2);
    this.getTileByName("C2").add(Wpawn3);
    this.getTileByName("D2").add(Wpawn4);
    this.getTileByName("E2").add(Wpawn5);
    this.getTileByName("F2").add(Wpawn6);
    this.getTileByName("G2").add(Wpawn7); 
    this.getTileByName("H2").add(Wpawn8);

    this.getTileByName("A8").add(Brook1);
    this.getTileByName("B8").add(Bknight1);
    this.getTileByName("C8").add(BbishopW);
    this.getTileByName("D8").add(Bqueen);
    this.getTileByName("E8").add(Bking);
    this.getTileByName("F8").add(BbishopB);
    this.getTileByName("G8").add(Bknight2);
    this.getTileByName("H8").add(Brook2);
    this.getTileByName("A7").add(Bpawn1);
    this.getTileByName("B7").add(Bpawn2);
    this.getTileByName("C7").add(Bpawn3);
    this.getTileByName("D7").add(Bpawn4);
    this.getTileByName("E7").add(Bpawn5);
    this.getTileByName("F7").add(Bpawn6);
    this.getTileByName("G7").add(Bpawn7); 
    this.getTileByName("H7").add(Bpawn8);
    addMouseListener(this);
    addMouseMotionListener(this);
    
   getPieceSet(); 
    //   System.out.println(pp);
    //  }
  }

  public Board getBoard() {
    return this;
  }

  public void getPieceSet(){
    pieceSet= new ArrayList<>();
    //int pieceCounter=0;
    //Piece piece;
    for(JPanel[] tileRow : tiles){
      for(JPanel tile : tileRow){
        if(this.findComponentAt(tile.getX(),tile.getY()) instanceof Piece){
          //pieceCounter++;
          Piece pc= (Piece) this.findComponentAt(tile.getX(),tile.getY());
          pieceSet.add(pc.copyPiece(pc));
          
        }
      }
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paintComponents(g);
     //Graphics2D g= (Graphics2D) gg;
    g.setColor(java.awt.Color.CYAN);
    for (int i = 0; i < 8; i++) {
      
        if (i % 2 == 0) {
          g.fillRect(100 * i + 300, 100, 100, 100);
        }
      
      
        if (!(i % 2 == 0)) {
          g.fillRect(100 * i + 300, 200, 100, 100);
        }
      
      
        if (i % 2 == 0) {
          g.fillRect(100 * i + 300, 300, 100, 100);
        }
      
      
        if (!(i % 2 == 0)) {
          g.fillRect(100 * i + 300, 400, 100, 100);
        }
      
      
        if (i % 2 == 0) {
          g.fillRect(100 * i + 300, 500, 100, 100);
        }
      
      
        if (!(i % 2 == 0)) {
          g.fillRect(100 * i + 300, 600, 100, 100);
        }
      
      
        if (i % 2 == 0) {
          g.fillRect(100 * i + 300, 700, 100, 100);
        }
      
      
        if (!(i % 2 == 0)) {
          g.fillRect(100 * i + 300, 800, 100, 100);
        }
      
        
    }
    //g.create(200, 100, 100, 100);
    g.drawRect(300, 100, 800, 800);
    g.setColor(java.awt.Color.green);
    g.fillRect(250, 50, 40, 860);
    g.fillRect(290, 50, 820, 40);
    g.fillRect(1110, 50, 40, 860);
    g.fillRect(250, 910, 900, 40);
    g.setColor(java.awt.Color.black);
    g.setFont(new Font("TimesRoman", Font.BOLD, 20));

    if (this.startingPosition == true) {
      g.drawImage(Wrook1.image, Wrook1.getParent().getX(), Wrook1.getParent().getY(), Wrook1.getParent());
      g.drawImage(Wrook2.image, Wrook2.getParent().getX(),Wrook2.getParent().getY(),Wrook2.getParent());
      g.drawImage(Wpawn1.image, Wpawn1.getParent().getX(),Wpawn1.getParent().getY(),Wpawn1.getParent());
      g.drawImage(Wpawn2.image, Wpawn2.getParent().getX(),Wpawn2.getParent().getY(),Wpawn2.getParent());
      g.drawImage(Wpawn3.image, Wpawn3.getParent().getX(),Wpawn3.getParent().getY(),Wpawn3.getParent());
      g.drawImage(Wpawn4.image, Wpawn4.getParent().getX(),Wpawn4.getParent().getY(),Wpawn4.getParent());
      g.drawImage(Wpawn5.image, Wpawn5.getParent().getX(),Wpawn5.getParent().getY(),Wpawn5.getParent());
      g.drawImage(Wpawn6.image, Wpawn6.getParent().getX(),Wpawn6.getParent().getY(),Wpawn6.getParent());
      g.drawImage(Wpawn7.image, Wpawn7.getParent().getX(),Wpawn7.getParent().getY(),Wpawn7.getParent());
      g.drawImage(Wpawn8.image, Wpawn8.getParent().getX(),Wpawn8.getParent().getY(),Wpawn8.getParent());
      g.drawImage(Wknight1.image, Wknight1.getParent().getX(),Wknight1.getParent().getY(),Wknight1.getParent());
      g.drawImage(Wknight2.image, Wknight2.getParent().getX(),Wknight2.getParent().getY(),Wknight2.getParent());
      g.drawImage(WbishopW.image, WbishopW.getParent().getX(),WbishopW.getParent().getY(),WbishopW.getParent());
      g.drawImage(WbishopB.image, WbishopB.getParent().getX(),WbishopB.getParent().getY(),WbishopB.getParent());
      g.drawImage(Wking.image, Wking.getParent().getX(),Wking.getParent().getY(),Wking.getParent());
      g.drawImage(Wqueen.image, Wqueen.getParent().getX(),Wqueen.getParent().getY(),Wqueen.getParent());

      g.drawImage(Brook1.image, Brook1.getParent().getX(),Brook1.getParent().getY(),Brook1.getParent());
      g.drawImage(Brook2.image, Brook2.getParent().getX(),Brook2.getParent().getY(),Brook2.getParent());
      g.drawImage(Bpawn1.image, Bpawn1.getParent().getX(),Bpawn1.getParent().getY(),Bpawn1.getParent());
      g.drawImage(Bpawn2.image, Bpawn2.getParent().getX(),Bpawn2.getParent().getY(),Bpawn2.getParent());
      g.drawImage(Bpawn3.image, Bpawn3.getParent().getX(),Bpawn3.getParent().getY(),Bpawn3.getParent());
      g.drawImage(Bpawn4.image, Bpawn4.getParent().getX(),Bpawn4.getParent().getY(),Bpawn4.getParent());
      g.drawImage(Bpawn5.image, Bpawn5.getParent().getX(),Bpawn5.getParent().getY(),Bpawn5.getParent());
      g.drawImage(Bpawn6.image, Bpawn6.getParent().getX(),Bpawn6.getParent().getY(),Bpawn6.getParent());
      g.drawImage(Bpawn7.image, Bpawn7.getParent().getX(),Bpawn7.getParent().getY(),Bpawn7.getParent());
      g.drawImage(Bpawn8.image, Bpawn8.getParent().getX(),Bpawn8.getParent().getY(),Bpawn8.getParent());
      g.drawImage(Bknight1.image, Bknight1.getParent().getX(),Bknight1.getParent().getY(),Bknight1.getParent());
      g.drawImage(Bknight2.image, Bknight2.getParent().getX(),Bknight2.getParent().getY(),Bknight2.getParent());
      g.drawImage(BbishopW.image, BbishopW.getParent().getX(),BbishopW.getParent().getY(),BbishopW.getParent());
      g.drawImage(BbishopB.image, BbishopB.getParent().getX(),BbishopB.getParent().getY(),BbishopB.getParent());
      g.drawImage(Bking.image, Bking.getParent().getX(),Bking.getParent().getY(),Bking.getParent());
      g.drawImage(Bqueen.image, Bqueen.getParent().getX(),Bqueen.getParent().getY(),Bqueen.getParent());

    }

    g.drawString(numbers[7], 265, 155);
    g.drawString(numbers[6], 265, 255);
    g.drawString(numbers[5], 265, 355);
    g.drawString(numbers[4], 265, 455);
    g.drawString(numbers[3], 265, 555);
    g.drawString(numbers[2], 265, 655);
    g.drawString(numbers[1], 265, 755);
    g.drawString(numbers[0], 265, 855);

    g.drawString(letters[0], 340, 940);
    g.drawString(letters[1], 440, 940);
    g.drawString(letters[2], 540, 940);
    g.drawString(letters[3], 640, 940);
    g.drawString(letters[4], 740, 940);
    g.drawString(letters[5], 840, 940);
    g.drawString(letters[6], 940, 940);
    g.drawString(letters[7], 1040, 940);

    
      Graphics2D gg = (Graphics2D) g;

      for(Piece piece : pieceSet){
        if( piece instanceof Piece && piece !=draggedPiece){ 
          gg.drawImage(piece.image, piece.getParent().getX(), piece.getParent().getY(), piece.getParent());
        }
      }
      if (draggedPiece != null && dragImage != null && movedPiece==true) { 
        if (this.currentDragLocation != null) { 
          if(this.pieceReleased==false){ 
          gg.drawImage(draggedPiece.image, this.currentDragLocation.x ,
          this.currentDragLocation.y , this);
          }
          else{ 
              gg.drawImage(draggedPiece.image, this.dropLocation.getX(), this.dropLocation.getY(),this.dropLocation); 
              draggedPiece = null;
              dragImage = null;
              dragOffset=null;
              this.startingPosition = false;
              this.movedPiece=false; 
              //dropLocation=null;
              currentDragLocation=null;
          }
        }
      }
    }
   
   

  // public static void copyPieceAttr(Piece p1, Piece p2) {
  //   p1.width = p2.width;
  //   p1.heigth = p2.width;
  //   p1.Name = p2.Name;
  //   p1.Path=p2.Path;
  //   p1.size = p2.size;
  //   p1.setMaximumSize(p1.size);
  //   p1.setBounds(null);
  //   p1.setPreferredSize(p1.size);
  //   p1.setSize(p1.size);
  // }

  public JPanel getTileByName(String name){
    for(JPanel[] tileRow : tiles){
      for(JPanel panel : tileRow){
        if(panel.getName().equals(name)){
          return panel;
        }
      }
    }
    return null;
  }

  public boolean piecePressed(MouseEvent e){

    clickedPiece=false;
    Component component= this.findComponentAt(e.getPoint()); 
    
    if(component!=null && component instanceof Piece){
      clickedPiece=true;
    }
    return clickedPiece;
  }

  public boolean pieceDragged(MouseEvent e){ 
    movedPiece=false;
    if(draggedPiece!=null && !this.findComponentAt(dragOffset).getName().equals(this.findComponentAt(e.getPoint()).getName())){
      movedPiece=true; 
    }else{
      movedPiece=false; 
    }
    return movedPiece;
  }


  public boolean isValidMove(Component targetSquare) {

    return targetSquare != null &&
        !(targetSquare instanceof Piece);
  }

  @Override
  public void mouseDragged(MouseEvent e) {  
    if ( pieceDragged(e)) { 
      this.currentDragLocation = new Point(e.getX() , e.getY());
     // System.out.println(currentDragLocation);
      currentDragLocation.x = Math.max(300, Math.min(currentDragLocation.x, 1020));
      currentDragLocation.y = Math.max(100, Math.min(currentDragLocation.y, 810));
      revalidate();
      repaint();
   //  System.out.println("current drag location"+" "+currentDragLocation);
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

   @Override
   public void mouseReleased(MouseEvent e) {
    
    if (draggedPiece != null && this.movedPiece==true) { 
      this.pieceReleased=true;
      
      currentDragLocation.x = Math.max(300, Math.min(currentDragLocation.x, 1020));
      currentDragLocation.y = Math.max(100, Math.min(currentDragLocation.y, 810));
      dropLocation= getTileByName(this.findComponentAt(e.getPoint()).getName());
      dropLocation.add(draggedPiece);
      //draggedPiece.setLocation(this.currentDragLocation.x - dragOffset.x, this.currentDragLocation.y - dragOffset.y);
      repaint();
    } 

  }
  @Override
  public void mousePressed(MouseEvent e) { 
    
    //System.out.println(this.findComponentAt(e.getPoint()));
    Component clickedComponent = this.findComponentAt(e.getPoint()); 
    if(piecePressed(e)){
      draggedPiece = (Piece) clickedComponent;
      draggedPiece = draggedPiece.getPieceByPath(draggedPiece.Path); 
      clickedComponent = null;

      dragOffset = new Point(
        e.getX() , 
        e.getY() 
    );

      this.dragImage = new BufferedImage(
          draggedPiece.getWidth(),
          draggedPiece.getHeight(),
          BufferedImage.TYPE_INT_ARGB);
  } 
    clickedComponent = null;
    this.pieceReleased=false;
    //System.out.println(dragOffset+" "+ e.getPoint());
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // System.out.println("mouse Exited");
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // System.out.println("mouse Entered");
  }




}
