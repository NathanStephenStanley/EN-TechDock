package dock;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;

public class Finder extends Button {
    public Finder(){
        setGraphic(new ImageView(new Image("dock/EN Icons/finder.png")));
        setBackground(Background.EMPTY);
    }
}
