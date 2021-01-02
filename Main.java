package dock;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Spinner<Integer> numberOfItems;

    public static Stage stage = new Stage();

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

        centerStage(stage);

        stckPaneDock.setClip(dockRectangle);

        Button btnClose = new Button();
        btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Close.png")));
        btnClose.toFront();
        btnClose.setBackground(Background.EMPTY);
        btnClose.setOnMouseEntered(e -> btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Close (hover).png"))));
        btnClose.setOnMouseExited(e -> btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Close.png"))));
        btnClose.setTranslateX(500);
        btnClose.setTranslateY(-20);
        btnClose.setOnMouseClicked(e -> stage.close());
        stckPaneDock.getChildren().add(btnClose);



        Scene sceneDock = new Scene(stckPaneDock, 1024, 60);


        stage.setScene(sceneDock);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    private void centerStage(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 316.0) / 5);
        stage.setY((screenBounds.getHeight() - 150) / 1);
    }
}
