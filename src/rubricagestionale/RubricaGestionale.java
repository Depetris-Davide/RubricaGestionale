package rubricagestionale;

import java.io.IOException;
import javax.swing.*;

public class RubricaGestionale extends JFrame {

    private MenuPanel panel;

    public RubricaGestionale() throws IOException {
        this.setTitle("Directory - Menu");
        this.setBounds(700, 200, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new MenuPanel();
        this.add(panel);

        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new RubricaGestionale();
    }

}
