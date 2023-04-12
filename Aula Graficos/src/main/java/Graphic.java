import java.awt.*;
import java.awt.image.BufferStrategy;

public class Graphic {

    public static void initGraphics(Game game){
        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            // otimiza a renderização - entre 2 e 3 buffers
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

        Graphics2D g2 = (Graphics2D) g;
//        g2.rotate(Math.toRadians(45),20+8,20+8);
        g2.drawImage(game.player[game.curAnimation], 20, 20, null);
        //performance
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0 ,0, width*scale, height*scale, null);
        bs.show();
    }

}
