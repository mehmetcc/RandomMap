package test;

import javax.swing.*;
import java.awt.*;


public class App extends JFrame {
    // constants
    private static final int WIDTH  = 512;
    private static final int HEIGHT = 512;

    // swing components
    private BorderLayout layout;
    private MapComponent mapComponent;

    // constructor(s)
    public App() {
        super();
        initializeGraphicalInterface();
    }


    //methods
    private void initializeGraphicalInterface() {
        layout = new BorderLayout();
        setLayout(layout);

        mapComponent = new MapComponent();
        this.add(mapComponent, BorderLayout.CENTER);

        // default settings for JFrame component
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
    }

}
