package no.ntnu.idata2001.gui.factory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;
import no.ntnu.idata2001.post.PostRegister;

import java.util.Iterator;
import java.util.Map;


public class TableViewProducer {

    public static TableView<PostAddress> create(String tableType){
        switch (tableType){
            case "PostAddress":
                PostAddress post = new PostAddress("pT", "zip", "mun", "munN", 'p');
                return createPostAddressTable(post);

            default:
                return null;
        }
    }

    /**
     * createPostAddressTable creates a new table view based on the PostAddress class' "getDisplayFields" method
     * This method returns a hashmap with fieldName and displayName of all fields that should be in the TableView
     * @param post - PostAddress object
     * @return TableView with all columns set for the PostAddress fields
     */
    public static TableView<PostAddress> createPostAddressTable(PostAddress post){
        TableView<PostAddress> postView = new TableView<>();

        postView.setItems(MainStage.getFilteredList());

        //Create iterator to iterate over PostAddress Field List
        Iterator it = post.getDisplayFields().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            TableColumn<PostAddress, String> column = new TableColumn<>(pair.getValue().toString());
            column.setCellValueFactory(new PropertyValueFactory<>(pair.getKey().toString()));
            postView.getColumns().add(column);
        }
        postView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return postView;
    }
    public static TableView CreateTableView(){
        PostRegister a = new PostRegister("LOL");
        a.addPostAddress(new PostAddress("P", "p", "p","p", 'p'));
        var b  = new FilteredList<>(FXCollections.observableArrayList(a.getAddresses()));
        TableView asd = new TableView(b);
        asd.setItems(b);
        return asd;
    }
}
