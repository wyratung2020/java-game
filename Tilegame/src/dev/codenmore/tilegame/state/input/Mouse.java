package dev.codenmore.tilegame.state.input;

//import static com.sun.tools.attach.VirtualMachine.list;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.nio.file.Files.list;
import static java.util.Collections.list;

/**
 *
 * @author asus
 */
public class Mouse implements MouseListener,MouseMotionListener {
    private boolean leftClick,rightClick;
    private int xMouse,yMouse;

    public boolean isLeftClick() {
        return leftClick;
    }

    public void setLeftClick(boolean leftClick) {
        this.leftClick = leftClick;
    }

    public boolean isRightClick() {
        return rightClick;
    }

    public void setRightClick(boolean rightClick) {
        this.rightClick = rightClick;
    }

    public int getxMouse() {
        return xMouse;
    }

    public void setxMouse(int xMouse) {
        this.xMouse = xMouse;
    }

    public int getyMouse() {
        return yMouse;
    }

    public void setyMouse(int yMouse) {
        this.yMouse = yMouse;
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
       if(e.getButton()==MouseEvent.BUTTON1)
           leftClick=true;
       if(e.getButton()==MouseEvent.BUTTON3)
           rightClick=true;
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       if(e.getButton()==MouseEvent.BUTTON1)
           leftClick=false;
       if(e.getButton()==MouseEvent.BUTTON3)
           rightClick=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       xMouse=e.getX();
       yMouse=e.getY();
       
      
        
            
        }
    
    
    
    
    
}
