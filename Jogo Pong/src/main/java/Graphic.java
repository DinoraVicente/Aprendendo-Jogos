import java.awt.*;
import java.awt.image.BufferStrategy;

public class Graphic {

    public static void initGraphics(
            Game game, Player player,
            Enemy enemy, Ball ball){

        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        var width = Game.width;
        var heigth = Game.heigth;
        var scale = game.scale;

        Graphics g = game.layer.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,heigth);

        player.render(g);
        enemy.render(g);
        ball.render(g);

        g= bs.getDrawGraphics();
        g.drawImage(game.layer, 0,0,width*scale,heigth*scale,null);
        bs.show();
    }
}
