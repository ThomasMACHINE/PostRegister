package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idata2001.post.PostAddress;

public class TableViewProducer {

    public static TableView<PostAddress> create(String tableType){
        switch (tableType){
            case "PostAddress":
                return createPostAddressTable();
            default:
                return null;
        }
    }
    /**
     * Creates the tableView that can hold PostAddresses in the UI
     * This TableView contains columns for all fields that the PostAddresses have
     */
    public static TableView<PostAddress> createPostAddressTable(){
        //Setting columns for respective Patient Data
        TableColumn<PostAddress, String> column1 = new TableColumn<>("Post Town");
        column1.setCellValueFactory(new PropertyValueFactory<>("postTown"));
        column1.setMinWidth(column1.getPrefWidth());

        TableColumn<PostAddress, String> column2 = new TableColumn<>("Zip Code");
        column2.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        column2.setMinWidth(column2.getPrefWidth());

        TableColumn<PostAddress, String> column3 = new TableColumn<>("Municipality");
        column3.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));
        column3.setMinWidth(column3.getPrefWidth());

        TableColumn<PostAddress, String> column4 = new TableColumn<>("Municipality Number");
        column4.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));
        column4.setMinWidth(column4.getPrefWidth());

        TableColumn<PostAddress, String> column5 = new TableColumn<>("Category");
        column5.setCellValueFactory(new PropertyValueFactory<>("category"));
        column5.setMinWidth(column5.getPrefWidth());

        TableView<PostAddress> postView = new TableView<>();
        //Add columns to tableView
        postView.getColumns().addAll(column1, column2, column3, column4, column5);

        return postView;
    }
}
