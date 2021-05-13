package no.ntnu.idata2001.gui.factory;

import javafx.collections.transformation.FilteredList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchBarProducer {
    /**
     * Produces a search bar, type dictates which searchBar is produced
     * @param searchBarType - The type of search bar
     * @param filteredList - The list that the search bar should search on
     * @return Hbox with a search bar
     */
    public static HBox create(String searchBarType, FilteredList<PostAddress> filteredList){

        switch (searchBarType){
            case "MainStage PostAddress":
                return createSearchBar(filteredList);
            default:
                return null;
        }
    }

    /**
     * Creates a search bar for filtering the post addresses by their fields
     * @param filteredList - the list that is in the table view
     * @return
     */
    private static HBox createSearchBar(FilteredList<PostAddress> filteredList) {

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        //Create iterator to iterate over PostAddress Field List
        //Ideally I would add the predicate setting inside here, but I cant think of another way
        //Other than using switches, so that has to be done manually
        Iterator it = PostAddress.getDisplayFields().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            choiceBox.getItems().add(pair.getValue().toString());
        }


        TextField textField = new TextField();
        textField.setPromptText("<-- Apply a filter and filter in here!");
        textField.setMinWidth(250);
        //Add Listener to update the table when new filter values are written
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            if(choiceBox.getValue() == null){
                textField.setText("<--- Please apply filter");
                return; //Do nothing if a filter is not applied
            }
            switch (choiceBox.getValue()) {
                case "Post Town":
                    filteredList.setPredicate(p -> p.getPostTown().toLowerCase().contains(newValue.toLowerCase()));
                    return;
                case "Zip Code":
                    filteredList.setPredicate(p -> p.getZipCode().toLowerCase().startsWith(newValue.toLowerCase()));
                    //To make it show all data with the value arbitrarily placed inside the value:
                    //contains(newValue.toLowerCase()));
                    return;
                case "Municipality":
                    filteredList.setPredicate(p -> p.getMunicipalityName().toLowerCase().contains(newValue.toLowerCase()));
                    return;
                case "Municipality Number":
                    filteredList.setPredicate(p -> p.getMunicipalityNumber().toLowerCase().startsWith(newValue.toLowerCase()));
                    //To make it show all data with the value arbitrarily placed inside the value:
                    //contains(newValue.toLowerCase()));
                    return;
                case "Category":
                    //filteredList.setPredicate(p -> p.getCategory());
                    return;
            }
        });
        //Set text field to "" if filter method is changed
        choiceBox.setOnAction(e -> textField.setText(""));
        //Add to HBox and return
        HBox hBox = new HBox(choiceBox, textField);
        return hBox;
    }
}
