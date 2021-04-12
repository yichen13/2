
/**
 * Write a description of class Z here.
 *
 * @author Greg Johnson
 * @version 9/1/17
 */
public class Z extends Tetrimino
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Z
     */
    public Z(int x, int y)
    {
        super(java.awt.Color.RED);
        // initialise instance variables
        this.setLocation(x,y);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block3.setLocation(x,y);
        _block2.setLocation(x+TetrisConstants.BLOCK_SIZE,y);
        _block1.setLocation(x+TetrisConstants.BLOCK_SIZE,y+TetrisConstants.BLOCK_SIZE);
        _block4.setLocation(x+(2*TetrisConstants.BLOCK_SIZE),y+TetrisConstants.BLOCK_SIZE);
    }
}
