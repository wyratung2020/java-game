package dev.codenmore.tilegame.display;

import dev.codenmore.tilegame.gfx.ImageLoader;
import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author asus
 */
public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width,height;
    
    public Display(String title,int width,int height){
         this.title=title;
         this.width=width;
         this.height=height;
         createDisplay();
    }
    private void createDisplay(){
        frame= new JFrame();
        frame.setTitle(title);// Đặt tiêu đề cho Frame.
        frame.setSize(width, height);//Cài đặt kích cỡ của Frame hiển thị.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cài đặt tắt chương trình khi ấn vào dấu X ở góc phải.
        frame.setResizable(false);//Cài đặt không cho phép phóng to màn hình.
        frame.setLocationRelativeTo(null);//Chương trình khi chạy sẽ hiển thị ở chính giữa màn hình.
        frame.setVisible(true);//Hiển thị Frame.
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        frame.add(canvas);
        frame.pack();
        canvas.setFocusable(false);
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Image image = ImageLoader.loadImage("/res/image/swordleft.png").getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        Point p = new Point(0,0);
        Cursor a = toolkit.createCustomCursor(image , p, "");
        frame.setCursor (a); 
      //  Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
      //  frame.setCursor(cursor);
                
    }
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
