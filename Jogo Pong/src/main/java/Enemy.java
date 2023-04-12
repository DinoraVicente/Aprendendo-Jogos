import java.awt.*;

public class Enemy {

    public final int widthEnemy;
    public final int heigthEnemy;
    public double x, y;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        this.widthEnemy = 40;
        this.heigthEnemy = 5;
    }

    public void update(){
        x+= (Game.ball.x - x - 6) * 0.07;
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, widthEnemy, heigthEnemy);
    }
}
