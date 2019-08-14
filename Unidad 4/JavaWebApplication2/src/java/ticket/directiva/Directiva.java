package ticket.directiva;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drone
 */
public class Directiva {
    public static int VISITAS = 0;
    public String currentDate(){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        return date;
    }
    
    public String currentTime(){
        String pattern = "HH:mm aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        return date;
    }
    
    public String getNumberClient(){
        Random r = new Random();
        int x = r.nextInt(1000 + 1) + 1000;
        return x+"";
    }
}
