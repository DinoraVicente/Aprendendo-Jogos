import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle {

    public int spd = 2;
    public int right= 1, up = 0, down = 0, left = 0;

    public int curAnimation = 0;

    public int curFrames = 0, targetFrames = 15;

    public static List<Bullet> bullets = new ArrayList<Bullet>();

    public boolean shoot = false;

    public Enemy(int x, int y) {
        super(x,y,32,32);
    }

    public void chasePlayer() {
        Player player = Game.player;

        if(x < player.x && World.isFree(x+spd, y)){
            if (new Random().nextInt(100) < 50)
                x+=spd;
        } else if (x > player.x && World.isFree(x-spd, y)) {
            if (new Random().nextInt(100) < 50)
                x-=spd;
        }
        if(y < player.y && World.isFree(x, y+spd)){
            if (new Random().nextInt(100) < 50)
                y+=spd;
        } else if (y > player.y && World.isFree(x, y-spd)) {
            if (new Random().nextInt(100) < 50)
                y-=spd;
        }

    }

    public void tick() {
        boolean moved = true;

        chasePlayer();

        if (moved) {
            curFrames++;
            if (curFrames == targetFrames) {
                curFrames = 0;
                curAnimation++;
                if (curAnimation == SpriteSheet.enemyFront.length) {
                    curAnimation = 0;
                }
            }
        }

        if (shoot) {
            shoot = false;
            bullets.add(new Bullet(x, y, 1));
        }

        for (int i =0; i < bullets.size(); i++) {
            bullets.get(i).tick();
        }

    }

    public void render(Graphics g) {
        g.drawImage(SpriteSheet.enemyFront[curAnimation], x, y, 32, 32, null);

        for (int i =0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
        }
    }
}

