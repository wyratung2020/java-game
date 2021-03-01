package dev.codenmore.tilegame.map;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entity.Chest;
import dev.codenmore.tilegame.entity.Entitymanager;
import dev.codenmore.tilegame.entity.Player;
import dev.codenmore.tilegame.entity.handler;
import dev.codenmore.tilegame.state.input.readfilemap;
import java.awt.Graphics;


/**
 *
 * @author asus
 */
public class buildmap {
    private handler handler;
    private int width,height;
    public int spawnX,spawnY;
    private int[][] listmap;
    private Entitymanager entityManager;
    public buildmap(handler handler,String path){
        this.handler=handler;
        entityManager = new Entitymanager(handler);
    
        setmap(path);
       

    }

    public Entitymanager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Entitymanager entityManager) {
        this.entityManager = entityManager;
    }
    public map findmap(float x,float y){
       int a=(int)(x/map.WIDTH);
       int b=(int)(y/map.HEIGHT);
      //  System.out.println(a);
     //   System.out.println(b);
      //  System.out.println(x);
      //  System.out.println(y);
        if(a>=width||a<0)return map.dirtblock;
        if(b>=height||b<0)return map.dirtblock;
        
          map t = map.getblock(listmap[a][b]);
        if(t ==null) return map.dirtblock;
        else return t;
      
    }
    public map getmap(int x,int y){
        
        map t = new map(listmap[x][y]);
        if(t ==null) return map.dirtblock;
        else return t;
    }
    private void setmap(String path){
       
            String filesss = readfilemap.loadfile(path);
        
        String[] number = filesss.split("\\s+");
        width = readfilemap.parseInt(number[0]);
        height = readfilemap.parseInt(number[1]);
        spawnX = readfilemap.parseInt(number[2]);
        spawnY = readfilemap.parseInt(number[3]);
       
        listmap = new int[width][height];
        for(int x=0;x<width;x++)
        for(int y=0;y<height;y++)
            listmap[x][y]=readfilemap.parseInt(number[x+y*width+4]);
        
        
        
    }
    public void update(){
        entityManager.update();
        
    }
    public void render(Graphics g){
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++){
                getmap(j,i).render(g, (int)(j*map.WIDTH-handler.getGamecamera().getXoffset()), (int)(i*map.HEIGHT-handler.getGamecamera().getYoffset()));
            }
       entityManager.render(g);
    }
}
