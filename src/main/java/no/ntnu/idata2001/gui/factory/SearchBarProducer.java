package no.ntnu.idata2001.gui.factory;

import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchBarProducer {

    public static HBox create(String searchBarType, FilteredList<PostAddress> filteredList){

        switch (searchBarType){
            case "MainStage PostAddress":
                return createSearchBar(filteredList);
            default:
                return null;
        }
    }

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
        choiceBox.setValue("Filter by");

        TextField textField = new TextField();
        textField.setPromptText("Search Field");
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
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
        //choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue));

        HBox hBox = new HBox(choiceBox, textField);
        return hBox;
    }
}
