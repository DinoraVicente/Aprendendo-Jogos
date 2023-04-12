import model.Fase;

import javax.swing.*;
import java.awt.*;

public class Container extends JFrame {

    public Container() {
        var jp = new JPanel();
        jp.setBackground(Color.BLACK);
        add(jp);
        add(new Fase());
        setTitle("Game");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }

    public static void main(String [] args) {
        new Container();
    }
}
