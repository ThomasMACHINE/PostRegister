package no.ntnu.idata2001.gui.factory;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import no.ntnu.idata2001.datastructs.FileInfo;

import java.util.Optional;

import static java.lang.Integer.parseInt;

public class InputDisplayProducer {
    /**
     * Creates a dialog that prompts for input on file structure, it then creates a FileInfo object based on inputs
     * @return file info object
     */
    public static FileInfo getFileInformation(){
        Dialog<FileInfo> dialog = new Dialog<>();
        dialog.setTitle("Select File Info");
        dialog.setHeaderText("Please select all the fields for the fields so that the program can parse it. Do not add quotation marks in splitter field.");
        //Create labels and text fields for input fields
        Label townLabel = new Label("Post Town Index: ");
        TextField townText = new TextField();

        Label zipLabel = new Label("Zip Code Index: ");
        TextField zipText = new TextField();

        Label municLabel = new Label("Municipality Name index: ");
        TextField municText = new TextField();

        Label municNumberLabel = new Label("Municipality Number index: ");
        TextField municNumberText = new TextField();

        Label categoryLabel = new Label("Category index: ");
        TextField categoryText = new TextField();

        Label splitterLabel = new Label("Splitter characters: ");
        TextField splitterText = new TextField();

        Label headerLabel = new Label("Is the first line an address?");
        ChoiceBox header = new ChoiceBox();
        header.getItems().add("Yes");
        header.getItems().add("No");
        header.setValue("No");

        //Add all the labels and text fields to a Grid Pane
        GridPane grid =  new GridPane();
        grid.addRow(0, townLabel, townText);
        grid.addRow(1, zipLabel, zipText);
        grid.addRow(2, municLabel, municText );
        grid.addRow(3, municNumberLabel, municNumberText);
        grid.addRow(4, categoryLabel, categoryText);
        grid.addRow(5, splitterLabel, splitterText);
        grid.addRow(6, header);
        //set content
        dialog.getDialogPane().setContent(grid);

        ButtonType okButton = new ButtonType("Confirm Input", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(okButton);

        dialog.setResultConverter(new Callback<ButtonType, FileInfo>() {
            @Override
            public FileInfo call(ButtonType buttonType) {

                if(buttonType == okButton){
                    try{
                        //Convert ChoiceBox value to boolean
                        boolean result;
                        String choice = header.getValue().toString();

                        if(choice.equals("Yes")){
                            result = true;
                        }
                        else{
                            result = false;
                        }
                        //Convert the input to integer, exception is thrown if user sent a non-number
                        int town = Integer.parseInt(townText.getText());
                        int zip = Integer.parseInt(zipText.getText());
                        int munic = Integer.parseInt(municText.getText());
                        int municNumber = Integer.parseInt(municNumberText.getText());
                        int category = Integer.parseInt(categoryText.getText());
                        //add indexes to the integer array
                        int indexes[] = {town, zip, munic, municNumber, category};
                        String splitter = splitterText.getText();


                        return new FileInfo(result, indexes, splitter);
                    }catch (Exception e){
                        ErrorDisplay.displayError(e.getLocalizedMessage());
                    }
                }
                return null;
            }
        });

        Optional<FileInfo> result = dialog.showAndWait();
        //If it is closed by any other means, then fuck this function am i right?
        if (result.isPresent()) {
            return result.get();
        }
        else{
            return null;
        }
    }
}
