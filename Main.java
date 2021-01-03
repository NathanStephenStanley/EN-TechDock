package dock;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) {
        StackPane stckPaneDock = new StackPane();
        stckPaneDock.setStyle("-fx-background-radius: 5 ;\n" +
                "-fx-border-radius: 5;\n" +
                "-fx-border-width:5;" +
                "-fx-opacity: 0.97;" +
                "-fx-background-color: #EBEAF9;");


        Rectangle dockRectangle = new Rectangle(1320, 60);
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
        btnClose.setTranslateX(640);
        btnClose.setTranslateY(-20);
        btnClose.setOnMouseClicked(e -> stage.close());
        stckPaneDock.getChildren().add(btnClose);

        Launchpad btnLaunchpad = new Launchpad();

        stckPaneDock.setMaxWidth(1375);

        Finder btnFinder = new Finder();
        btnFinder.setTranslateX(-630);

        DockItem btnSafari = new DockItem();
        btnSafari.setGraphic(new ImageView(new Image("dock/EN Icons/Safari.png")));
        btnSafari.setTranslateX(-520);

        DockItem btnMail = new DockItem();
        btnMail.setGraphic(new ImageView(new Image("dock/EN Icons/Mail.png")));
        btnMail.setTranslateX(-465);

        DockItem btnFaceTime = new DockItem();
        btnFaceTime.setGraphic(new ImageView(new Image("dock/EN Icons/Facetime.png")));
        btnFaceTime.setTranslateX(-410);

        DockItem btnMessages = new DockItem();
        btnMessages.setGraphic(new ImageView(new Image("dock/EN Icons/messages.png")));
        btnMessages.setTranslateX(-355);

        DockItem btnMaps = new DockItem();
        btnMaps.setGraphic(new ImageView(new Image("dock/EN Icons/Maps.png")));
        btnMaps.setTranslateX(-300);

        DockItem btnPhotos = new DockItem();
        btnPhotos.setGraphic(new ImageView(new Image("dock/EN Icons/Photos.png")));
        btnPhotos.setTranslateX(-245);
        btnPhotos.setOnMouseClicked(e -> {
            try {
                Runtime.getRuntime().exec("start ms-photos:");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        DockItem btnContacts = new DockItem();
        btnContacts.setGraphic(new ImageView(new Image("dock/EN Icons/contacts.png")));
        btnContacts.setTranslateX(-190);

        DockItem btnReminders = new DockItem();
        btnReminders.setGraphic(new ImageView(new Image("dock/EN Icons/reminders.png")));
        btnReminders.setTranslateX(-135);

        DockItem btnNotes = new DockItem();
        btnNotes.setGraphic(new ImageView(new Image("dock/EN Icons/notes.png")));
        btnNotes.setTranslateX(-80);

        DockItem btnMusic = new DockItem();
        btnMusic.setGraphic(new ImageView(new Image("dock/EN Icons/music.png")));
        btnMusic.setTranslateX(-25);

        DockItem btnPodCasts = new DockItem();
        btnPodCasts.setGraphic(new ImageView(new Image("dock/EN Icons/podcasts.png")));
        btnPodCasts.setTranslateX(30);

        DockItem btnAppleTV = new DockItem();
        btnAppleTV.setGraphic(new ImageView(new Image("dock/EN Icons/apple tv.png")));
        btnAppleTV.setTranslateX(85);

        DockItem btnAppStore = new DockItem();
        btnAppStore.setGraphic(new ImageView(new Image("dock/EN Icons/App Store.png")));
        btnAppStore.setTranslateX(140);


//        Adding Items
        stckPaneDock.getChildren().addAll(btnFinder, btnLaunchpad, btnSafari, btnMail,
                btnFaceTime, btnMessages, btnMaps, btnPhotos, btnContacts, btnReminders,
                btnNotes, btnMusic, btnPodCasts, btnAppleTV, btnAppStore);



        Scene sceneDock = new Scene(stckPaneDock, 1024, 60);
        sceneDock.setFill(Color.TRANSPARENT);

        stage.setScene(sceneDock);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        stage.setMinWidth(1344);
        stage.getIcons().add(new Image("dock/EN Icons/profile pic.png"));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    private void centerStage(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 316.0) / 9);
        stage.setY((screenBounds.getHeight() - 110) / 1);
    }
}
