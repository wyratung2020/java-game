package dev.codenmore.tilegame.state.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author asus
 */
public class readfilemap {
    public static String loadfile(String path){
          StringBuilder builder=new StringBuilder();
          try{
           BufferedReader br = new BufferedReader(new FileReader(path));
           String line;
           while((line=br.readLine())!=null)
               builder.append(line+"\n");
           br.close();
          }catch(IOException e){
              e.printStackTrace();
          }
         return builder.toString();
    }
    public static int parseInt(String number){
        return Integer.parseInt(number);
    }
    
}
