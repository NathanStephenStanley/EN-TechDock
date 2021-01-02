package dock;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Spinner<Integer> numberOfItems;

    public static Stage stage = new Stage();

    public static Button btnMaximize;

    @Override
    public void start(Stage primaryStage) {
        StackPane stckPaneDock = new StackPane();
        stckPaneDock.setStyle("-fx-background-radius: 5 ;\n" +
                "-fx-border-radius: 5;\n" +
                "-fx-border-width:5;" +
                "-fx-opacity: 0.95;" +
                "-fx-background-color: black;");


        Rectangle dockRectangle = new Rectangle(1024, 60);
        dockRectangle.setArcHeight(5);
        dockRectangle.setArcWidth(5);
        dockRectangle.toBack();

        centerStage(stage, 316.0, 339.0);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem quitMenuItem = new MenuItem("Quit Dock");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        contextMenu.setX(screenBounds.getHeight() - 339.0 / 4);


        contextMenu.getItems().add(quitMenuItem);


        Button btnClose = new Button();
        btnClose.setGraphic(new ImageView(new Image("dock/Close.png")));
        btnClose.toFront();
        stckPaneDock.getChildren().add(btnClose);

        stckPaneDock.setClip(dockRectangle);

        Scene sceneDock = new Scene(stckPaneDock, 1024, 768);
        sceneDock.setFill(Color.TRANSPARENT);


        stckPaneDock.setOnContextMenuRequested(e -> contextMenu.show(stage, e.getX(), e.getY()));


        stage.setScene(sceneDock);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        stage.show();
        Button settingsButton = new Button("Settings");




    }


    public static void main(String[] args) {
        launch(args);
    }

    private void centerStage(Stage stage, double width, double height) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 4);
        stage.setY((screenBounds.getHeight() - height) / 4);
    }
}
