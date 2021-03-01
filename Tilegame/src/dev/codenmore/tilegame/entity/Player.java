package dev.codenmore.tilegame.entity;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.state.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author asus
 */
public class Player extends Creature {
    
    private Animation animation;
    private Slash slash ;
    private int MP;
    private boolean isleft=false;
    private long lastattack,timenextattack =800,timeattack=timenextattack;

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }
    public Player(handler handler,float x, float y) {
        super(handler,x, y,Creature.WIDTH,Creature.HEIGHT);
        this.health=health;
        slash=new Slash(this.handler);
        animation =new Animation(35,Assets.character,3);
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
        handler.getGamecamera().centrerEntity(this);
        if(handler.getKeyboard().shift){
            for(int i=1;i<30;i++){
              animation.update();
        
        Input();
        Move();
        handler.getGamecamera().centrerEntity(this);
            }
           
        }
        if(handler.getKeyboard().space){
         
              slash.update();}
        checkattack();
        
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
     
        if(!handler.getKeyboard().shift){
              if(EntityCollision(xMove, 0f))xMove=0;
       if(EntityCollision(0f, yMove))yMove=0;
        }
    // if(!EntityCollision(xMove, 0f))   System.out.println(EntityCollision(xMove, 0f));
         
        
        
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
        xMove = 0;
        yMove = 0;
        if(handler.getKeyboard().up){
            yMove=-speed;
        }
         if(handler.getKeyboard().down){
            yMove=+speed;
        }
          if(handler.getKeyboard().right){
            xMove=+speed;
        }
           if(handler.getKeyboard().left){
            xMove=-speed;
        }
    }
    @Override
    public void render(Graphics g) {
       if(xMove>0){
           g.drawImage(animation.getCurrentFramerun(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       } else if(xMove<0){
           g.drawImage(animation.getCurrentFramerunleft(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
           isleft=true;
       } else if(yMove!=0&&animation.getcurrent()==0){
           g.drawImage(animation.getCurrentFramerun(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       } else if(yMove!=0&&animation.getcurrent()==1){
           g.drawImage(animation.getCurrentFramerunleft(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
           isleft=true;
       }else  if(animation.getcurrent()==0){
           g.drawImage(animation.getCurrentFrameidle(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       }else  {
           g.drawImage(animation.getCurrentFrameidleleft(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
           isleft=true;
       }    /* if(handler.getKeyboard().shift){
            for(int i=1;i<4;i++){
                if(xMove>0){
           g.drawImage(animation.getCurrentFramerun(), (int) ((int)x-handler.getGamecamera().getXoffset()+i*10), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       } else if(xMove<0){
           g.drawImage(animation.getCurrentFramerunleft(), (int) ((int)x-handler.getGamecamera().getXoffset()+i*10), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       } else if(yMove!=0&&animation.getcurrent()==0){
           g.drawImage(animation.getCurrentFramerun(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()+i*10),width,height, null);
       } else if(yMove!=0&&animation.getcurrent()==1){
           g.drawImage(animation.getCurrentFramerunleft(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()+i*10),width,height, null);
       }else  if(animation.getcurrent()==0){
           g.drawImage(animation.getCurrentFrameidle(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
       }else  
           g.drawImage(animation.getCurrentFrameidleleft(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),width,height, null);
            }
        }
       /* if(xMove!=0||yMove!=0){
           g.drawImage(animation.getCurrentFramerun(), (int)x, (int)y,width,height, null);
       } else g.drawImage(animation.getCurrentFrameidle(), (int)x, (int)y, width,height, null);
        */

        if(handler.getKeyboard().space){
             slash.render(g);
        }else      { g.drawImage(ImageLoader.loadImage("/res/image/sword.png"), (int) ((int)x-handler.getGamecamera().getXoffset())+18, (int) ((int)y-handler.getGamecamera().getYoffset())+10,16,16, null);
                     g.drawImage(ImageLoader.loadImage("/res/image/swordleft.png"), (int) ((int)x-handler.getGamecamera().getXoffset())-2, (int) ((int)y-handler.getGamecamera().getYoffset())+10,16,16, null);
        }

      g.setColor(Color.red);
      g.fillRect(12, 13, 32*(1+this.health)-2, height-5);
       g.drawImage(ImageLoader.loadImage(("/res/image/health.png")), 10, 10,160,32, null);
     //   System.out.println(this.health);
    }

    @Override
    public void die() {
         State.setCurrentState(handler.getGame().GameOver);
    }

    private void checkattack() {
       timeattack+=System.currentTimeMillis()-lastattack;
       lastattack=System.currentTimeMillis();
       if(timeattack<timenextattack) return;
       if(handler.getKeyboard().space){
        Rectangle attack=new Rectangle((int)(x-32), (int)(y-32), 96 , 96);
        timeattack=0;
        for(Entity e : handler.getMap().getEntityManager().getEntity()){
           if(e.equals(this))
               continue;
           if(e.getCollisionBounds(0f,0f).intersects(attack)){
               e.getHit(1);
           }
    }
        for(Entity e : handler.getMap().getEntityManager().getMoveentity()){
           if(e.equals(this))
               continue;
           if(e.getCollisionBounds(0f,0f).intersects(attack)){
               e.getHit(1);
           }
    }
       }   
    }
       
}
