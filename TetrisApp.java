import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisApp extends JFrame{
    private GamePanel _gamePanel;
    
    public TetrisApp(){
     super("Tetris");
     this.setResizable(false);
     _gamePanel = new GamePanel(); 
     _gamePanel.setPreferredSize(new java.awt.Dimension(TetrisConstants.BLOCK_SIZE*10, TetrisConstants.BLOCK_SIZE*20));
     this.setSize(TetrisConstants.BLOCK_SIZE*10, TetrisConstants.BLOCK_SIZE*20);
     this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
     this.add(_gamePanel);  
     this.setVisible(true);
    }
    
    public static void main(String[] args){
        TetrisApp app = new TetrisApp();
    }
}