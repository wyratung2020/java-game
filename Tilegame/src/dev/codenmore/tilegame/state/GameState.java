package dev.codenmore.tilegame.state;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entity.Chest;
import dev.codenmore.tilegame.entity.Enemies;
import dev.codenmore.tilegame.entity.Player;
import dev.codenmore.tilegame.entity.Torch;
import dev.codenmore.tilegame.entity.handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.map.buildmap;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class GameState extends State {
    private Player player;
    private Enemies enemy,enemy1,enemy2;
    private buildmap map,map1;
    private Chest chest;
    private Torch torch;
    public GameState(handler handler) {
        super(handler);
        
        map = new buildmap(handler,"F:\\Tilegame-20200611T030646Z-001\\Tilegame\\src\\res\\map\\Gach3.txt");
        map1 = new buildmap(handler,"F:\\Tilegame-20200611T030646Z-001\\Tilegame\\src\\res\\map\\Vien3.txt");
        handler.setMap(map);
         player= new Player(handler,map.spawnX*32, map.spawnY*32);
         handler.setPlayer(player);
         handler.getMap().getEntityManager().addMoveEntity(player);
         
         enemy=new Enemies(handler, 32*10, 32*30,Assets.godblin);
         enemy1=new Enemies(handler, 32*6, 32*37,Assets.slime);
         enemy2=new Enemies(handler, 32*2, 32*40,Assets.flyingaim);
         chest=new Chest(handler, 32*9, 32*40);
         torch=new Torch(handler, 32*8, 32*39);
        Torch torch1 = new Torch(handler, 32*5, 32*20);
        Torch torch2 = new Torch(handler, 32*10, 32*20);
        Torch torch3 = new Torch(handler, 32*19, 32*25);
        Torch torch4 = new Torch(handler, 32*5, 32*27);
                  handler.getMap().getEntityManager().addMoveEntity(enemy);
         handler.getMap().getEntityManager().addMoveEntity(enemy1);
         handler.getMap().getEntityManager().addMoveEntity(enemy2);
         handler.getMap().getEntityManager().addEntity(chest);
         handler.getMap().getEntityManager().addEntity(torch);
         handler.getMap().getEntityManager().addEntity(torch1);
         handler.getMap().getEntityManager().addEntity(torch2);
         handler.getMap().getEntityManager().addEntity(torch3);
         handler.getMap().getEntityManager().addEntity(torch4);

         
    }

    @Override
    public void update() {
        map.update();
        map1.update();
 
        
          
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, handler.getwidth(), handler.getheight());
        map.render(g);
      
       
            map1.render(g);
        handler.getPlayer().render(g);
        
           
    }
    
    
}
