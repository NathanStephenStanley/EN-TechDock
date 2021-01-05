package dock;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Dock extends StackPane {
    public Dock(Stage stage){
        Launchpad btnLaunchpad = new Launchpad();

        setMaxWidth(1375);

        setStyle("-fx-background-radius: 5 ;\n" +
                "-fx-border-radius: 5;\n" +
                "-fx-border-width:5;" +
                "-fx-opacity: 0.97;" +
                "-fx-background-color: #EBEAF9;");

        Button btnClose = new Button();
        btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Close.png")));
        btnClose.toFront();
        btnClose.setBackground(Background.EMPTY);
        btnClose.setOnMouseEntered(e -> btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Close (hover).png"))));
        btnClose.setOnMouseExited(e -> btnClose.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Close.png"))));
        btnClose.setTranslateX(480);
        btnClose.setTranslateY(-20);
        btnClose.setOnMouseClicked(e -> stage.close());

        Rectangle dockRectangle = new Rectangle(1190, 60);
        dockRectangle.setArcHeight(30);
        dockRectangle.setArcWidth(30);

        setClip(dockRectangle);

        Finder btnFinder = new Finder();
        btnFinder.setTranslateX(-650);
        btnFinder.setOnMouseClicked(e -> {
            try {
                Process process = Runtime.getRuntime().exec("explorer");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        DockItem btnSafari = new DockItem();
        btnSafari.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Safari.png")));
        btnSafari.setTranslateX(-540);
        btnSafari.setOnMouseClicked(e -> {
            try{
                Runtime runtime = Runtime.getRuntime();

                Process process = runtime.exec("\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        DockItem btnMail = new DockItem();
        btnMail.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Mail.png")));
        btnMail.setTranslateX(-485);

        DockItem btnFaceTime = new DockItem();
        btnFaceTime.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Facetime.png")));
        btnFaceTime.setTranslateX(-430);

        DockItem btnMessages = new DockItem();
        btnMessages.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/messages.png")));
        btnMessages.setTranslateX(-375);

        DockItem btnMaps = new DockItem();
        btnMaps.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Maps.png")));
        btnMaps.setTranslateX(-320);

        DockItem btnPhotos = new DockItem();
        btnPhotos.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/Photos.png")));
        btnPhotos.setTranslateX(-265);

        DockItem btnContacts = new DockItem();
        btnContacts.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/contacts.png")));
        btnContacts.setTranslateX(-210);

        DockItem btnReminders = new DockItem();
        btnReminders.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/reminders.png")));
        btnReminders.setTranslateX(-155);

        DockItem btnNotes = new DockItem();
        btnNotes.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/notes.png")));
        btnNotes.setTranslateX(-100);

        DockItem btnMusic = new DockItem();
        btnMusic.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/music.png")));
        btnMusic.setTranslateX(-40);

        DockItem btnPodCasts = new DockItem();
        btnPodCasts.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/podcasts.png")));
        btnPodCasts.setTranslateX(20);

        DockItem btnAppleTV = new DockItem();
        btnAppleTV.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/apple tv.png")));
        btnAppleTV.setTranslateX(80);

        DockItem btnAppStore = new DockItem();
        btnAppStore.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/App Store.png")));
        btnAppStore.setTranslateX(135);

        DockItem btnSettings = new DockItem();
        btnSettings.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/settings.png")));
        btnSettings.setTranslateX(190);
        btnSettings.setOnMouseClicked(e -> {
            Robot keyboardRobot = new Robot();
            keyboardRobot.keyPress(KeyCode.WINDOWS);
            keyboardRobot.keyPress(KeyCode.I);
            keyboardRobot.keyRelease(KeyCode.I);
            keyboardRobot.keyRelease(KeyCode.WINDOWS);
        });

        DockItem btnZoom = new DockItem();
        btnZoom.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/zoom.png")));
        btnZoom.setTranslateX(257);
        btnZoom.setOnMouseClicked(e -> {
            try{
                Runtime runtime = Runtime.getRuntime();

                Process process = runtime.exec("\"C:\\Users\\eranj\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe\"");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        DockItem btnIdea = new DockItem();
        btnIdea.setGraphic(new ImageView(new Image("dock/EN Icons/Big Sur/idea.png")));
        btnIdea.setTranslateX(312);
        btnIdea.setOnMouseClicked(e -> {
            try {
                Process process = Runtime.getRuntime().exec("\"C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.1.1\\bin\\idea64.exe\"");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        ImageView imgViewSeperator = new ImageView(new Image("dock/EN Icons/Big Sur/separator.png"));
        imgViewSeperator.setTranslateX(223);


//        Adding Items
        getChildren().addAll(btnFinder, btnLaunchpad, btnSafari, btnMail,
                btnFaceTime, btnMessages, btnMaps, btnPhotos, btnContacts, btnReminders,
                btnNotes, btnMusic, btnPodCasts, btnAppleTV, btnAppStore, btnSettings, imgViewSeperator,
                btnZoom, btnIdea);
    }
}
