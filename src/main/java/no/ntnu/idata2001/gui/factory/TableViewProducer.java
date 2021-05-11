package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idata2001.post.PostAddress;

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

        //Create iterator to iterate over PostAddress Field List
        Iterator it = post.getDisplayFields().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();

            TableColumn<PostAddress, String> column = new TableColumn<>(pair.getValue().toString());
            column.setCellValueFactory(new PropertyValueFactory<>(pair.getKey().toString()));
            postView.getColumns().add(column);
        }
        return postView;
    }
}
