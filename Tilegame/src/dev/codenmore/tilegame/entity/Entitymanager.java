package dev.codenmore.tilegame.entity;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Entitymanager {
    private handler handler;  
    private ArrayList<Entity> entity;
    private ArrayList<Entity> moveentity;

    public Entitymanager(handler handler) {
        this.handler = handler;
        
        entity = new ArrayList<Entity>();
        moveentity = new ArrayList<Entity>();
        
    }
    public void update(){
        for(int i=0;i<entity.size();i++){
            Entity e = entity.get(i);
            e.update();
            if(!e.isAlive){
                entity.remove(e);
            }
        }  
        for(int i=0;i<moveentity.size();i++){
            Entity e = moveentity.get(i);
            e.update();
            if(!e.isAlive){
                moveentity.remove(e);
            }
        }  
        
    }  
    public void render(Graphics g){
        for(int i=0;i<entity.size();i++){
            Entity e = entity.get(i);
            e.render(g);
        }
        for(int i=0;i<moveentity.size();i++){
            Entity e = moveentity.get(i);
            e.render(g);
        }
     
      
     
        
    }
    public void addEntity(Entity e){
       entity.add(e);
    }
    public void addMoveEntity(Entity e){
        moveentity.add(e);
    }

    public handler getHandler() {
        return handler;
    }

    public void setHandler(handler handler) {
        this.handler = handler;
    }

   

    public ArrayList<Entity> getEntity() {
        return entity;
    }

    public void setEntity(ArrayList<Entity> entity) {
        this.entity = entity;
    }

    public ArrayList<Entity> getMoveentity() {
        return moveentity;
    }

    public void setMoveentity(ArrayList<Entity> moveentity) {
        this.moveentity = moveentity;
    }
    
}
