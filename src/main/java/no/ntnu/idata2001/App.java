package no.ntnu.idata2001;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;
import no.ntnu.idata2001.post.PostRegister;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = MainStage.createMainStage();

        stage.setTitle("PostRegister");
        stage.setScene(scene);
        stage.show();
    }
}
