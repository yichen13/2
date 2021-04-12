
/**
 * Write a description of class KeyPListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
private class KeyPListener extends KeyIterator
{
    public KeyListener(Jpanel p)
    {super(p, KeyEvent.VK_P);
    }
    public void actionPerformed (ActionEvent e)
    {
        if (paused == false){
          paused = true;
          _time.stop();
     }
    else if (paused == true){
        paused = false;
        _timer.start();
    }
}

