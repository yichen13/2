/**
 * Abstract class Tetrimino - write a description of the class here
 *
 * @author (Agean Binan)
 * @version 9/30
 * 
 * 
 */
public abstract class Tetrimino
{
    // instance variables - replace the example below with your own
    protected SmartRectangle _block1, _block2, _block3, _block4;
    protected int _x, _y;
    protected java.awt.Color _color;

    public Tetrimino (java.awt.Color color){
        _color = color;
        _block1 = new SmartRectangle(_color);
        _block1.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block2 = new SmartRectangle(_color);
        _block2.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block3 = new SmartRectangle(_color);
        _block3.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block4 = new SmartRectangle(_color);
        _block4.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block1.setBorderColor(java.awt.Color.WHITE);
        _block2.setBorderColor(java.awt.Color.WHITE);
        _block3.setBorderColor(java.awt.Color.WHITE);
        _block4.setBorderColor(java.awt.Color.WHITE);
    }
    public void draw(java.awt.Graphics2D aBrush)
    {
        _block1.draw(aBrush);
        _block2.draw(aBrush);
        _block3.draw(aBrush);
        _block4.draw(aBrush);
    }
    public void fill(java.awt.Graphics2D aBrush)
    {
        _block1.fill(aBrush);
        _block2.fill(aBrush);
        _block3.fill(aBrush);
        _block4.fill(aBrush);
    }
    
    public abstract void setLocation(int x, int y);
    
    public void moveRight(){
        SmartRectangle[] blocks = {_block1, _block2, _block3, _block4};
        double[][] locs = new double[4][2];
        int i = 0;
        // Check if they can move left
        for (SmartRectangle block: blocks)
        {
            double[] blockloc = block.getLocation();
            if (blockloc[0] + TetrisConstants.BLOCK_SIZE > TetrisConstants.BLOCK_SIZE * 8)
            {
                return;
            }
            locs[i][0] = blockloc[0];
            locs[i][1] = blockloc[1];
            i += 1;
        }
        i = 0;
        // If they can:
        for (SmartRectangle block: blocks)
        {
            block.setLocation(locs[i][0] + TetrisConstants.BLOCK_SIZE, locs[i][1]);
            i += 1;
        }
        _x += TetrisConstants.BLOCK_SIZE;
    }
    public void moveLeft(){
        SmartRectangle[] blocks = {_block1, _block2, _block3, _block4};
        double[][] locs = new double[4][2];
        int i = 0;
        // Check if they can move left
        for (SmartRectangle block: blocks)
        {
            double[] blockloc = block.getLocation();
            if (blockloc[0] - TetrisConstants.BLOCK_SIZE < 0)
            {
                return;
            }
            locs[i][0] = blockloc[0];
            locs[i][1] = blockloc[1];
            i += 1;
        }
        i = 0;
        // If they can:
        for (SmartRectangle block: blocks)
        {
            block.setLocation(locs[i][0] - TetrisConstants.BLOCK_SIZE, locs[i][1]);
            i += 1;
        }
        _x -= TetrisConstants.BLOCK_SIZE;
    }
    public void moveDown(){
        SmartRectangle[] blocks = {_block1, _block2, _block3, _block4};
        double[][] locs = new double[4][2];
        int i = 0;
        // Check if they can move down
        for (SmartRectangle block: blocks)
        {
            double[] blockloc = block.getLocation();
            if (blockloc[1] + TetrisConstants.BLOCK_SIZE >= 18 * TetrisConstants.BLOCK_SIZE)
            {
                return;
            }
            locs[i][0] = blockloc[0];
            locs[i][1] = blockloc[1];
            i += 1;
        }
        i = 0;
        // If they can:
        for (SmartRectangle block: blocks)
        {
            block.setLocation(locs[i][0], locs[i][1] + TetrisConstants.BLOCK_SIZE);
            i += 1;
        }
        _y += TetrisConstants.BLOCK_SIZE;
    }
    public void turnRight(){
        for (int i = 0; i < 3; i++)
        {
            turnLeft();
        }
    }
    public void turnLeft(){
        SmartRectangle[] blocks = {_block1, _block2, _block3, _block4};
        int i = 0;
        int setx = 0;
        int sety = 0;
        for (SmartRectangle block: blocks)
        {
            double[] blockloc = block.getLocation();
            double newx = _x - _y + blockloc[1];
            double newy = _y + _x - blockloc[0];
            block.setLocation(newx, newy);
            if (i == 2)
            {
                setx = (int)newx;
                sety = (int)newy;
            }
            i += 1;
        }
        _x = setx;
        _y = sety;
    }
}
