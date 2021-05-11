package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Dialog {

    /**
     * Creates a dialog with information that user can accept or decline
     * @param message - description of the action the user has to accept or decline
     * @return - true if they accept, false if not
     */
    public static boolean createDialog(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you agree with this action?");
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
