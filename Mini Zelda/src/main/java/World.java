import java.awt.*;
import java.util.ArrayList;

public class World {

    public static ArrayList<Blocks> blocos = new ArrayList<>();

    public World(){
        for (int xx = 0; xx < 15 * 2; xx++){
            blocos.add(new Blocks(xx * 32,0));
        }
        for (int xx = 0; xx < 15 * 2; xx++){
            blocos.add(new Blocks(xx * 32,480 - 32));
        }

        for (int yy = 0; yy < 15 * 2; yy++){
            blocos.add(new Blocks(0,yy * 32));
        }

        for (int yy = 0; yy < 15 * 2; yy++){
            blocos.add(new Blocks(640 - 32,yy * 32));
        }
    }

    public static boolean isFree(int x, int y){
        for (Blocks blocoAtual : blocos) {
            if (blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }
        return true;
    }

    public void render(Graphics g) {
        for (Blocks bloco : blocos) {
            bloco.render(g);
        }
    }
}
