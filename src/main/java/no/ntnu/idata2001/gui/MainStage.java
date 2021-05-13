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

/**
 * MainStage is the class that produces the primary stage off the application
 */
public class MainStage {
    private static PostRegister postRegister = new PostRegister("Norway");
    private static ObservableList<PostAddress> postList = FXCollections.observableArrayList(postRegister.getAddresses());
    private static FilteredList<PostAddress> filteredList = new FilteredList<>(postList, p -> true);

    /**
     * Creates the mainStage
     * @return - the prepared scene, ready to be ran on a Stage object
     */
    public static Scene createMainStage(){
        //Create the postTable
        TableView<PostAddress> postTable = TableViewProducer.create("PostAddress");
        //Create menuBar
        MenuBar menuBar = MenuProducer.create("Main Menu", postTable);
        //createSearchBar
        HBox searchBar = SearchBarProducer.create("MainStage PostAddress", filteredList);
        VBox vBox = new VBox(menuBar, postTable, searchBar);
        return new Scene(vBox);
    }

    /**
     * Accessor method for the PostList
     * @return PostList
     */
    public static ObservableList<PostAddress> getPostList(){
        return postList;
    }

    /**
     * Accessor method for FilteredList in table
     * @return filteredList
     */
    public static FilteredList<PostAddress> getFilteredList(){
        return filteredList;
    }

    /**
     * accessor method for postRegister object used
     * @return postRegister used in creating table
     */
    public static PostRegister getPostRegister() {
        return postRegister;
    }

    /**
     * Mutator method for setting the PostList
     * @param postList - new PostList
     */
    public static void setPostList(ObservableList<PostAddress> postList) {
        MainStage.postList = postList;
    }
}
