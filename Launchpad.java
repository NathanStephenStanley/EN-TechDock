package dock;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launchpad extends Button {

    public Launchpad(){
        setGraphic(new ImageView(new Image("dock/EN Icons/launchpad.png")));
        setTranslateX(-575);
        setTranslateY(1);
        setBackground(Background.EMPTY);

        Pane launchpadPane = new Pane();
        Stage launchpadStage = new Stage();
        launchpadStage.setAlwaysOnTop(true);
        launchpadStage.initStyle(StageStyle.TRANSPARENT);
        launchpadStage.initModality(Modality.APPLICATION_MODAL);
        Scene launchpadScene = new Scene(launchpadPane);
        toFront();
        setHover(false);

        setOnMouseClicked(e -> {
            launchpadStage.setFullScreen(true);
            launchpadStage.setScene(launchpadScene);
            launchpadStage.show();
        });

        ContextMenu contextMenu = new ContextMenu();
        MenuItem NewItem = new MenuItem();
        NewItem.setText("New Shortcut");
        MenuItem NewFolder = new MenuItem();
        NewFolder.setText("New Folder");

        contextMenu.getItems().addAll(NewItem, NewFolder);
        launchpadPane.setOnMouseClicked(e -> {
            contextMenu.setX(e.getX());
            contextMenu.setY(e.getY());
        });

        Button close = new Button();
        close.setBackground(Background.EMPTY);
        close.setOnMouseClicked(e -> launchpadStage.close());
        close.setGraphic(new ImageView(new Image("dock/EN Icons/Close.png")));
        close.setOnMouseEntered(e -> close.setGraphic(new ImageView(new Image("dock/EN Icons/Close (hover).png"))));
        close.setOnMouseExited(e -> close.setGraphic(new ImageView(new Image("dock/EN Icons/Close.png"))));

        launchpadPane.getChildren().add(close);

        launchpadPane.setOnContextMenuRequested(e -> contextMenu.show(launchpadStage));
    }
}
