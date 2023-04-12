import java.awt.event.KeyEvent;

public class KeyEvents {

    public static void eventPressed(KeyEvent e, Player player){
        var botao = e.getKeyCode();
        if (botao == KeyEvent.VK_RIGHT || botao == KeyEvent.VK_D) {
            player.right = true;
        } else if (botao == KeyEvent.VK_LEFT || botao == KeyEvent.VK_A) {
            player.left = true;
        }
    }

    public static void eventReleased(KeyEvent e, Player player){
        var botao = e.getKeyCode();
        if (botao == KeyEvent.VK_RIGHT || botao == KeyEvent.VK_D) {
            player.right = false;
        } else if (botao == KeyEvent.VK_LEFT || botao == KeyEvent.VK_A) {
            player.left = false;
        }
    }
}
