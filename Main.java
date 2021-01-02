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
import javafx.stage.Modality;
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
                "-fx-opacity: 0.9;" +
                "-fx-background-color: #d1d4cb;");


        Rectangle dockRectangle = new Rectangle(1024, 60);
        dockRectangle.setArcHeight(30);
        dockRectangle.setArcWidth(30);

        centerStage(stage, 316.0, 150.0);

        stckPaneDock.setClip(dockRectangle);

        Button btnClose = new Button();
        btnClose.setGraphic(new ImageView(new Image("dock/Close.png")));
        btnClose.toFront();
        stckPaneDock.getChildren().add(btnClose);



        Scene sceneDock = new Scene(stckPaneDock, 1024, 768);
        sceneDock.setFill(Color.TRANSPARENT);


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
        stage.setX((screenBounds.getWidth() - width) / 5);
        stage.setY((screenBounds.getHeight() - height) / 1);
    }
}
