import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SpriteSheet {

    public static BufferedImage spriteSheet;

    public static BufferedImage[] playerFront;

    public static BufferedImage tileWall;

    public static BufferedImage[] enemyFront;

    //302, 221 - 320, 221
    public SpriteSheet() {
        try {
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("/spritesheet.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        playerFront = new BufferedImage[2];
        playerFront[0] = getSpriteSheet(0, 11, 16, 16);
        playerFront[1] = getSpriteSheet(16, 11, 16, 16);

        tileWall = getSpriteSheet(280, 221, 16, 16);

        enemyFront = new BufferedImage[2];
        enemyFront[0] = getSpriteSheet(303, 221, 16, 16);
        enemyFront[1] = getSpriteSheet(320, 221, 16, 16);
    }

    public static BufferedImage getSpriteSheet(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x, y, width, height);
    }

}
