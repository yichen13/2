import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
/**
 * Write a description of class KeyLeftListener here.
 * 
 * @author (Yi) 
 * @version (a version number or a date)
 */
private class KeyLeftListener extends KeyInteractor
{
    public KeyLeftListener(JPanel p)
    {
        super(p,KeyEvent.VK_LEFT);
    }
    public void actionPerformed(ActionEvent e)
    {
        _piece.turnRight();
        repaint();
    }
}
