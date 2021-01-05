package dock;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) {
        

        centerStage(stage);


        Dock dock = new Dock(stage);

        Scene sceneDock = new Scene(dock, 1024, 60);
        sceneDock.setFill(Color.TRANSPARENT);

        stage.setScene(sceneDock);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        stage.setMinWidth(1375);
        stage.getIcons().add(new Image("dock/EN Icons/Big Sur/profile pic.png"));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    private void centerStage(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 300.0) / 6);
        stage.setY((screenBounds.getHeight() - 110) / 1);
    }
}
