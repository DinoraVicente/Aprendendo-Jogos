import java.awt.*;
import java.util.Random;

public class Ball {

    private final int widthBall;
    private final int heigthBall;
    public double x, y;

    public double dx, dy;
    public double speed = 1.6;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        this.widthBall = 4;
        this.heigthBall = 4;

        int angle = new Random().nextInt((120 - 45) + 46);

        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void update(){

        if ((x+dx*speed) + widthBall >= Game.width) {
            dx*=-1;
        } else if (x + (dx*speed) < 0){
            dx*=-1;
        }

        if(y >= Game.heigth) {
            System.out.println("Ponto do inimigo");
            new Game();
            return;
        }else if (y<0){
            System.out.println("Ponto nosso");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int) (x+(dx*speed)), (int) (y+(dy*speed)), widthBall, heigthBall);

        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y,Game.player.widthPlayer,Game.player.heigthPlayer);

        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y,Game.enemy.widthEnemy,Game.enemy.heigthEnemy);

        if (bounds.intersects(boundsPlayer)){
            int angle = new Random().nextInt((120 - 45) + 46);

            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy > 0) dy *= -1;
        } else if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt((120 - 45) + 46);

            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy < 0) dy*=-1;
        }

        x+=dx*speed;
        y+=dy*speed;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, widthBall, heigthBall);
    }
}
