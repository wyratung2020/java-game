package dev.codenmore.tilegame.map;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author asus
 */
public class map {
    public static final int WIDTH=32,HEIGHT=32; 
    protected  BufferedImage image;
    protected  final int id;
    private boolean issolid=false;
    public static map[] block =new map[256];
    public static map dirtblock =new map(65);
    
    
    public map(int id) {
        this.image = Assets.tilemap[id];
        this.id = id;
        block[id]=this;
        if(id>65) this.issolid=true;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }
   public void update(){
       
   }  
   public static map getblock(int i){
       return block[i];
   }
   public void render(Graphics g,int x,int y) { 
       g.drawImage(image, x, y,WIDTH,HEIGHT, null);
   }
   public boolean isSolid(){
       return issolid;
   }
       
}
