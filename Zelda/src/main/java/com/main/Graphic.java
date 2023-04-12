package com.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Graphic {

    public static void initGraphics(Game game){
        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        var width = game.width;
        var height = game.height;
        var scale = game.scale;
        var image = game.image;

        Graphics g = image.getGraphics();
        g.setColor(new Color(19,19,19));
        g.fillRect(0,0, width, height);

//        Graphics2D g2 = (Graphics2D) g;

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0 ,0, width*scale, height*scale, null);
        bs.show();
    }

}
