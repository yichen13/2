/**
 * Write a description of class PieceProxy here.
 * 
 * @author (Agean Binan) 
 * @version (9/30)
 */
public class PieceProxy implements Animatable
{
    // instance variables - replace the example below with your own
    public Tetrimino _piece;

    /**
     * Constructor for objects of class PieceProxy
     */
    public PieceProxy()
    {
        // initialise instance variables
        
    }

    public void setPiece(Tetrimino p)
    {  
        _piece = p;
    }
    public void moveUp(){
        //
    }
    public void moveDown()
    {
        // put your code here
        _piece.moveDown();
    }
    public void moveLeft()
    {
        // put your code here
        _piece.moveLeft();
    }
    public void moveRight()
    {
        // put your code here
        _piece.moveRight();
    }
    public void turnRight()
    {
        // put your code here
        _piece.turnRight();
    }
    public void turnLeft()
    {
        // put your code here 
        _piece.turnLeft();
    }
    public void fill(java.awt.Graphics2D aBrush)
    {
        // put your code here
        _piece.fill(aBrush);
    }
    public void draw(java.awt.Graphics2D aBrush)
    {
        // put your code here
        _piece.draw(aBrush);
    }
}
