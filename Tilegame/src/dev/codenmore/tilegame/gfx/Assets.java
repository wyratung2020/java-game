package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

//https://o-lobster.itch.io/simple-dungeon-crawler-16x16-pixel-pack

/**
 *
 * @author asus
 */
public class Assets {
  private static final int width=16,height=16;
  static SpriteSheet sheet= new SpriteSheet(ImageLoader.loadImage("/res/image/Soldier.png"));
  static SpriteSheet sheet1= new SpriteSheet(ImageLoader.loadImage("/res/image/floor_1.png"));
  static SpriteSheet sheet2= new SpriteSheet(ImageLoader.loadImage("/res/image/floor_6.png"));
  static SpriteSheet sheet3= new SpriteSheet(ImageLoader.loadImage("/res/image/wall_1.png"));
  static SpriteSheet sheetgoblinidle= new SpriteSheet(ImageLoader.loadImage("/res/image/goblinidle.png"));
  static SpriteSheet sheetgoblinrun= new SpriteSheet(ImageLoader.loadImage("/res/image/godblinrun.png"));
  static SpriteSheet sheetslimeidle= new SpriteSheet(ImageLoader.loadImage("/res/image/slimeidle.png"));
  static SpriteSheet sheetslimerun= new SpriteSheet(ImageLoader.loadImage("/res/image/slimerun.png"));
  static SpriteSheet sheetflyaim= new SpriteSheet(ImageLoader.loadImage("/res/image/flyanim.png"));
  static SpriteSheet sheetknightidle= new SpriteSheet(ImageLoader.loadImage("/res/image/knight_idle_spritesheet.png"));
  static SpriteSheet sheetknightrun= new SpriteSheet(ImageLoader.loadImage("/res/image/knight_run_spritesheet.png"));
  static SpriteSheet sheetknightidleleft= new SpriteSheet(ImageLoader.loadImage("/res/image/knight_idle_spritesheetleft.png"));
  static SpriteSheet sheetknightrunleft= new SpriteSheet(ImageLoader.loadImage("/res/image/knight_run_spritesheetleft.png"));
  static SpriteSheet sheetchest= new SpriteSheet(ImageLoader.loadImage("/res/image/chest_spritesheet.png"));
  static SpriteSheet sheetslash= new SpriteSheet(ImageLoader.loadImage("/res/image/slash_effect_anim_spritesheet.png"));
  static SpriteSheet sheetslashleft= new SpriteSheet(ImageLoader.loadImage("/res/image/slash_effect_anim_spritesheetleft.png"));
  static SpriteSheet sheettorch= new SpriteSheet(ImageLoader.loadImage("/res/image/torch_spritesheet.png"));
  static SpriteSheet sheetmenu= new SpriteSheet(ImageLoader.loadImage("/res/image/AH_Parallax_Space.png"));
  static SpriteSheet sheettilemap= new SpriteSheet(ImageLoader.loadImage("/res/image/full tilemap.png"));
  public static BufferedImage dirt,grass,wall,e,button,buttonpress,menu;
  public static BufferedImage character[]=new BufferedImage[24];
  public static BufferedImage godblin[]=new BufferedImage[12];
  public static BufferedImage slime[]=new BufferedImage[12];
  public static BufferedImage flyingaim[]=new BufferedImage[12];
  public static BufferedImage chest[]=new BufferedImage[8];
  public static BufferedImage slash[]=new BufferedImage[3];
  public static BufferedImage slashleft[]=new BufferedImage[3];
  public static BufferedImage torch[]=new BufferedImage[6];
  public static BufferedImage tilemap[]=new BufferedImage[256];

  public static void init(){
      for (int i=0;i<6;i++){
          torch[i]=sheettorch.crop(i*16, 0, 16, 16);
          godblin[i]=sheetgoblinidle.crop(i*16, 0, 16, 16);
          godblin[i+6]=sheetgoblinrun.crop(i*16, 0, 16, 16);
      }
        for (int i=0;i<6;i++){
          slime[i]=sheetslimeidle.crop(i*16, 0, 16, 16);
          slime[i+6]=sheetslimerun.crop(i*16, 0, 16, 16);
          character[i]=sheetknightidle.crop(i*16, 0, 16, 16);
          character[i+6]=sheetknightrun.crop(i*16, 0, 16, 16);
          character[i+12]=sheetknightidleleft.crop(i*16, 0, 16, 16);
          character[i+18]=sheetknightrunleft.crop(i*16, 0, 16, 16);
      }
          for (int i=0;i<4;i++){
        
          flyingaim[i]=sheetflyaim.crop(i*16, 0, 16, 16);
          flyingaim[i+4]=sheetflyaim.crop(i*16, 0, 16, 16);
          flyingaim[i+8]=sheetflyaim.crop(i*16, 0, 16, 16);
      }
          for (int i=0;i<8;i++){
        
          chest[i]=sheetchest.crop(i*16, 0, 16, 16);
       
          
      }
          for (int i=0;i<3;i++){
              slash[i]=sheetslash.crop(i*16, 0, 16, 16);
              slashleft[i]=sheetslashleft.crop(32-i*16, 0, 16, 16);
          }
      for (int i = 0; i < 9; i++) 
          for(int j=0;j<8;j++)
      {
         tilemap[j*16+1+i]= sheettilemap.crop(i*16,j*16,16,16);
          
      } 
     
      dirt=sheet1.crop(0, 0, width, height);
      grass=sheet2.crop(0, 0, width, height);
      wall=sheet3.crop(0, 0, width, height);
     // e=sheet.crop(width, width, width, height);
      menu=sheetmenu.crop(0, 0, 192, 192);
      button=ImageLoader.loadImage("/res/image/menu_button.png");
      buttonpress=ImageLoader.loadImage("/res/image/menu_button_press.png");

  }
  
}    

