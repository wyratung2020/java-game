package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author asus
 */
public class Animation {
    private int speed,index,cnt;
    private BufferedImage[] frames;
    private int lastframes;
    private long lasttime,timer;
    private int numberframes;

    public int getcurrent(){
        return lastframes;
    }
    

    public Animation(int speed, BufferedImage[] frames,int numberframes ) {
        this.speed = speed;
        this.frames = frames;
        this.numberframes=numberframes;
        index=0;
        lastframes=0;
    }
    
    public void update(){
        timer+=System.currentTimeMillis()-lasttime;
        lasttime=System.currentTimeMillis();
        if(timer>speed){
            index++;
            timer =0;
            if(index >=numberframes){
                if(cnt==0){
                    cnt=1;
                }else cnt=0;
                        
            
                index=0;
        }
    }
    }

    public int getIndex() {
        return index;
    }
    
    public BufferedImage getCurrentFrameDown(){
        lastframes=0;
        return frames[index];
        
    }
    public BufferedImage getCurrentFrameLeft(){
        lastframes=3;
        return frames[index+3];
        
    }
    public BufferedImage getCurrentFrameRight(){
        lastframes=6;
        return frames[index+6];
        
    }
    public BufferedImage getCurrentFrameUp(){
        lastframes=9;
        return frames[index+9];
        
    }

    public BufferedImage getLastframes() {
   
        return frames[index+lastframes];
    }
    public BufferedImage getCurrentFrameidle(){
        lastframes=0;
        return frames[index+3*cnt];
    }
    public BufferedImage getCurrentFramerun(){
        lastframes=0;
        return frames[6+index+3*cnt];
    }
    public BufferedImage getCurrentFrameidleleft(){
        lastframes=1;
        return frames[12+index+3*cnt];
    }
    public BufferedImage getCurrentFramerunleft(){
        lastframes=1;
        return frames[18+index+3*cnt];
    }
}
