package dock;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;

public class DockItem extends Button {
    public static final int HEIGHT = 55;
    public static final int WIDTH = 55;

    public DockItem(){
        setPrefHeight(HEIGHT);
        setPrefWidth(WIDTH);
        toFront();
        setBackground(Background.EMPTY);
    }
}
