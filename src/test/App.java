package test;

import javax.swing.*;
import java.awt.*;


public class App extends JFrame {
    // constants
    private static final int WIDTH  = 512;
    private static final int HEIGHT = 512 + 128;

    // swing components
    private BorderLayout layout;
    private MapComponent mapComponent;
    private ButtonPanel buttonPanel;

    // constructor(s)
    public App() {
        super("MapGenerator");

        layout = new BorderLayout();
        setLayout(layout);

        mapComponent = new MapComponent();
        buttonPanel = new ButtonPanel(mapComponent);

        this.add(mapComponent, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // default settings for JFrame component
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
    }


}
