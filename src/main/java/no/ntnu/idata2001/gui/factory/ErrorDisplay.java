package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.Alert;

/**
 * ErrorDisplay is a class for displaying errors to the users as it is better suited than terminal responses for GUI applications
 */
public class ErrorDisplay {

    /**
     * Display error creates an alert box that displays the error
     * @param error - the error message that will be shown
     */
    public static void displayError(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Please read below");
        alert.setContentText(error);
        //Show the alert
        alert.showAndWait();
    }
}
