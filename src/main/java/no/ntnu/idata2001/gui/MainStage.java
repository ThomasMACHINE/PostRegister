package no.ntnu.idata2001.gui;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idata2001.gui.factory.TableViewProducer;
import no.ntnu.idata2001.post.PostAddress;

public class MainStage {

    public static Scene createMainStage(){
        TableView<PostAddress> postTable = TableViewProducer.create("PostAddress");
        VBox vBox = new VBox(postTable);
        return new Scene(vBox);
    }
}
