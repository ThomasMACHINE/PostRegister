package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.Alert;

public class ErrorDisplay {

    /**
     * Display error creates an alert box that displays the error
     * @param error - the error message that will be shown
     */
    public static void displayError(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Something weird happened");
        alert.setContentText(error);
        //Show the alert
        alert.showAndWait();
    }
}
