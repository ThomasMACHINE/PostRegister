package no.ntnu.idata2001.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idata2001.gui.factory.MenuProducer;
import no.ntnu.idata2001.gui.factory.SearchBarProducer;
import no.ntnu.idata2001.gui.factory.TableViewProducer;
import no.ntnu.idata2001.post.PostAddress;
import no.ntnu.idata2001.post.PostRegister;

public class MainStage {
    private static ObservableList<PostAddress> postList = FXCollections.observableArrayList(new PostRegister("Post").getAddresses());
    private static FilteredList<PostAddress> filteredList = new FilteredList<>(postList, p -> true);

    public static Scene createMainStage(){
        TableView<PostAddress> postTable = TableViewProducer.create("PostAddress");
        MenuBar menuBar = MenuProducer.create("Main Menu", postTable);
        HBox searchBar = SearchBarProducer.create("MainStage PostAddress", filteredList);
        VBox vBox = new VBox(menuBar, postTable, searchBar);
        return new Scene(vBox);
    }
    public static ObservableList<PostAddress> getPostList(){
        return postList;
    }
    public static FilteredList<PostAddress> getFilteredList(){
        return filteredList;
    }
}
