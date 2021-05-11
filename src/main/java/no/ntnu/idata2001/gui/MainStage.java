package no.ntnu.idata2001.gui;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idata2001.gui.factory.MenuProducer;
import no.ntnu.idata2001.gui.factory.TableViewProducer;
import no.ntnu.idata2001.post.PostAddress;

public class MainStage {

    public static Scene createMainStage(){
        TableView<PostAddress> postTable = TableViewProducer.create("PostAddress");
        MenuBar menuBar = MenuProducer.create("Main Menu", postTable);
        VBox vBox = new VBox(menuBar, postTable);
        return new Scene(vBox);
    }
}
