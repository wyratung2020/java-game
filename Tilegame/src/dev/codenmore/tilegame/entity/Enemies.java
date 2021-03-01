package dev.codenmore.tilegame.entity;
import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author asus
 */
public class Enemies extends Creature {
    
    private Animation animation;
    private long lastattack,timenextattack =800,timeattack=timenextattack;
   
    public Enemies(handler handler,float x, float y,BufferedImage[] frames) {
        super(handler,x, y,32,32);
        this.handler=handler;
        super.speed=1.1f;
        animation =new Animation(50,frames,3);
          bound.x=6;
        bound.y=10;
        bound.width=18;
        bound.height=20;
        
    }

    @Override
    public void update() {
        animation.update();
        Input();
        Move();
        checkattack();
        xMove=0;
        yMove=0;
    }
    public void Move() {
          float a=x+bound.x;
        float b=y+bound.y;
       if(Collision(a+xMove, b))xMove=0;
       if(Collision(a, b+yMove))yMove=0;
       if(Collision(a+xMove+bound.width, b))xMove=0;
       if(Collision(a+bound.width, b+yMove))yMove=0;
       if(Collision(a, b+bound.height+yMove))yMove=0;
       if(Collision(a+xMove, b+bound.height))xMove=0;
       if(Collision(a+bound.width, b+bound.height+yMove))yMove=0;
       if(Collision(a+bound.width+xMove, b+bound.height))xMove=0;
        if(speed==Math.abs(xMove)&&speed==Math.abs(yMove)){
            xMove=xMove/1.414213562f;
            yMove=yMove/1.414213562f;
           
            
        }
        x+=xMove;
        y+=yMove;
    }
    public boolean Collision(float x,float y){
        
        
       return  handler.getMap().findmap(x, y).isSolid();
    }
    public void Input() {
        if(Math.sqrt((handler.getPlayer().x-this.x)*(handler.getPlayer().x-this.x)+(handler.getPlayer().y-this.y)*(handler.getPlayer().y-this.y))<32*8){
        if(handler.getPlayer().x>this.x) xMove=speed;
        else if(handler.getPlayer().x<this.x) xMove=-speed;
        else xMove = 0;
         if(handler.getPlayer().y>this.y) yMove=speed;
         else if(handler.getPlayer().y<this.y) yMove=-speed;
        else yMove = 0;
        }
       
    }
    @Override
    public void render(Graphics g) {
       if(xMove!=0||yMove!=0){
           g.drawImage(animation.getCurrentFramerun(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       } else g.drawImage(animation.getCurrentFrameidle(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()), width,height, null);
        
     
    }

    @Override
    public void die() {
        System.out.println("enemy die");
    }
     private void checkattack() {
       timeattack+=System.currentTimeMillis()-lastattack;
       lastattack=System.currentTimeMillis();
       if(timeattack<timenextattack) return;
      
        Rectangle attack=new Rectangle((int)(x-5), (int)(y-5), 42 , 42);
        timeattack=0;
       
        Entity e ;
               e = handler.getPlayer();
           
           if(e.getCollisionBounds(0f,0f).intersects(attack)){
               e.getHit(1);
               System.out.println(e.health);
               handler.getPlayer().health=e.health;
           
    
       }   
    }
    
}
