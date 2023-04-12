import java.awt.*;

public class Player {

    public boolean right, left;
    public int x, y;

    public int widthPlayer, heigthPlayer;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.widthPlayer = 40;
        this.heigthPlayer = 5;
    }

    public void update(){
        if (right){
            x++;
        } else if (left){
            x--;
        }
        if (x+widthPlayer > Game.width){
            x = Game.width - widthPlayer;
        } else if (x < 0){
            x = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(x, y, widthPlayer, heigthPlayer);
    }
}
