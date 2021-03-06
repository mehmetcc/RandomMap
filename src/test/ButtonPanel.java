package test;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A product of mehmetcc (Mehmet Can Altuntaş)
 * Generate beautiful worlds that makes sense
 */

public class ButtonPanel extends JPanel {
    // constants
    private static final int WIDTH  = 512;
    private static final int HEIGHT = 128;

    // swing components
    private MapComponent mapComponent;
    private JButton button;

    // constructor(s)
    public ButtonPanel(MapComponent mapComponent) {
        this.mapComponent = mapComponent;
        button = new JButton("Generate!");

        button.addActionListener(new ButtonListener());

        this.add(button);
        this.setSize(WIDTH, HEIGHT);
    }

    // button listener
    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mapComponent.reset();
        }
    }
}
