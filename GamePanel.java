  import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 import java.util.Random;
 import java.awt.Color;
    
/**
* Write a description of class GamePanel here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class GamePanel extends JPanel implements ActionListener
    {
    private PieceProxy _piece;
    private Random _rand;
    private KeyInteractor _upListener, _downListener;
    private KeyInteractor _leftListener, _rightListener, _pListener;
    private Timer _timer;
    private boolean paused;
    private Tetrimino r_tetrinimo;
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
       super();
       
       this.setSize(TetrisConstants.BOARD_WIDTH,TetrisConstants.BOARD_HEIGHT);
       this.setBackground(java.awt.Color.lightGray);
       _rand = new Random();
       _piece = new PieceProxy();
       _piece.setPiece(this.tetriminoFactory());
       tetriminoFactory();
       _timer = new javax.swing.Timer(1000,this);
       paused = false;
       _timer.start();
       
       _upListener = new KeyUpListener(this); //Missing "this" as an argument
       _downListener = new KeyDownListener(this);
       _leftListener = new KeyLeftListener(this);
       _rightListener = new KeyRightListener(this);
       _pListener = new KeyPListener(this);
    }
    
    public void paintComponent (java.awt.Graphics aBrush)
    {
        super.paintComponent(aBrush);
        java.awt.Graphics2D betterBrush = (java.awt.Graphics2D)aBrush;
        
        _piece.fill(betterBrush);
        _piece.draw(betterBrush);
    }
    
    public Tetrimino tetriminoFactory()
    {
        int r_starting_x = _rand.nextInt(6) + 2;
        int r_starting_y = 1;
        int selection = _rand.nextInt(7);
        Tetrimino r_tetrimino;
        
        switch (selection)
        {
            case 0:
                r_tetrimino = new J(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 1:
                r_tetrimino = new I(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 2:
                r_tetrimino = new Z(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 3:
                r_tetrimino = new S(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 4:
                r_tetrimino = new O(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 5:
                r_tetrimino = new T(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            case 6:
                r_tetrimino = new L(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
            default:
                r_tetrimino = new L(TetrisConstants.BLOCK_SIZE*r_starting_x,TetrisConstants.BLOCK_SIZE*r_starting_y);
                break;
        }
        return r_tetrimino;
    }

    public void actionPerformed(ActionEvent e){
        _piece.moveDown();
        repaint();
    }
    private class KeyUpListener extends KeyInteractor 
    {
        public KeyUpListener(JPanel p)
        {
            super(p,KeyEvent.VK_UP);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.turnRight();
            repaint();
        }
    }
    private class KeyRightListener extends KeyInteractor 
    {
        public KeyRightListener(JPanel p)
        {
            super(p,KeyEvent.VK_RIGHT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveRight();
            repaint();
        }
    }
    private class KeyLeftListener extends KeyInteractor 
    {
        public KeyLeftListener(JPanel p)
        {
            super(p,KeyEvent.VK_LEFT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveLeft();
            repaint();
        }
    }
    private class KeyDownListener extends KeyInteractor 
    {
        public KeyDownListener(JPanel p)
        {
            super(p,KeyEvent.VK_DOWN);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveDown();
            repaint();
        }
    }

    private class KeyPListener extends KeyInteractor
    {
  
      public KeyPListener(JPanel p)
        {
            super(p,KeyEvent.VK_P);
        }
      public  void actionPerformed (ActionEvent e) 
      {
          if (paused == false) {
          paused = true;
          _timer.stop();
        }
        else if (paused == true) {
            paused = false;
          _timer.start();
        }
      }
    }
}
