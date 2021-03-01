package dev.codenmore.tilegame.state;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entity.handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class MenuState extends State {
    private boolean button1=false,button2=false,button3=false;
    public MenuState(handler handler) {
        super(handler);
        
    }

    @Override
    public void update() {
         if(handler.getMouse().getxMouse()>=304&&handler.getMouse().getxMouse()<=496){
       if(handler.getMouse().getyMouse()>=100&&handler.getMouse().getyMouse()<=164){
           button1=true;}else button1=false;
       
       if(handler.getMouse().getyMouse()>=200&&handler.getMouse().getyMouse()<=264){
           button2=true;} else button2=false;
       if(handler.getMouse().getyMouse()>=300&&handler.getMouse().getyMouse()<=364){
           button3=true;} else button3=false;
   
         }
        if(handler.getMouse().isLeftClick()&&button1){
            State.setCurrentState(handler.getGame().gameState);
        }
        if(handler.getMouse().isLeftClick()&&button3){
            System.exit(0);
        }
   
    }
    @Override
    public void render(Graphics g) {
     
        //g.drawImage(Assets.menu, 0, 0,800,600, null);
   //    g.drawImage(ImageLoader.loadImage("/image/crosshair_1.png"), handler.getMouse().getxMouse(), handler.getMouse().getyMouse(),16,16, null);
   if(handler.getMouse().getxMouse()>=304&&handler.getMouse().getxMouse()<=496){
       if(handler.getMouse().getyMouse()>=100&&handler.getMouse().getyMouse()<=164){
           g.drawImage(Assets.buttonpress,304,100, 192, 64, null);
                   }else g.drawImage(Assets.button,304,100, 192, 64, null);
       if(handler.getMouse().getyMouse()>=200&&handler.getMouse().getyMouse()<=264){
           g.drawImage(Assets.buttonpress,304,200, 192, 64, null);
                   }else g.drawImage(Assets.button,304,200, 192, 64, null);
       if(handler.getMouse().getyMouse()>=300&&handler.getMouse().getyMouse()<=364){
           g.drawImage(Assets.buttonpress,304,300, 192, 64, null);
                   }else g.drawImage(Assets.button,304,300, 192, 64, null);
       
   }else{
     g.drawImage(Assets.button,304,100, 192, 64, null);
     g.drawImage(Assets.button,304,200, 192, 64, null);
     g.drawImage(Assets.button,304,300, 192, 64, null);
   }
      g.drawString("NEW GAME", 320, 132);
      g.drawString("LEVEL", 320, 232);
      g.drawString("EXIT GAME", 320, 332);
    }
    
}
