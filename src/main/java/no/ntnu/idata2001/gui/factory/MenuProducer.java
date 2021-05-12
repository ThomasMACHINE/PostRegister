package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MenuProducer {

    /**
     * The Menu Producer, it takes the type as a parameter to find out which Menu to create
     * @param menuType - The type of menu that should be created
     * @param postView - The active TableView of Addresses
     * @return Menu bar that was chosen by "menuType"
     */
    public static MenuBar create(String menuType, TableView<PostAddress> postView){
        switch (menuType){
            case "Main Menu":
                return createMainMenu(postView);
            default:
                return null;
        }
    }

    /**
     * createMenus creates the menu bar used in the application along with its buttons
     * @return - A menubar with all the items that goes into the mainStage
     */
    public static MenuBar createMainMenu(TableView<PostAddress> postView){
        // Create the Menu Bar to hold all the menus
        MenuBar menuBar = new MenuBar();

        // The File-menu
        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Import from File");
        openFile.setOnAction(e -> {
            try {
                doLoadFile(postView);
            } catch (IOException ioException) {
                ErrorDisplay.displayError(ioException.getLocalizedMessage());
            }
        });

        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(openFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);
        //EditMenu

        //HelpMenu
        Menu menuView = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> doShowInfo());
        //Add to help
        menuView.getItems().addAll(about);

        menuBar.getMenus().addAll(menuFile, menuView);

        return menuBar;
    }
    /**
     * Opens a dialog to allow easy selection of .csv file, on success it parses it into postView
     * @param postView - TableView that contains all patients
     * @throws IOException - Throws IO exception if there is an error with the file
     */
    private static void doLoadFile(TableView<PostAddress> postView) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        File file = fileChooser.showOpenDialog(stage);
        parseFile(file, postView);
    }

    /**
     * Parses a file with post addresses and adds them to the table view
     * @param file - File with post address data
     * @param postView - TableView that the addresses gets put into
     * @throws IOException - Throws exception if theres an error with the file
     */
    private static void parseFile(File file, TableView<PostAddress> postView) throws IOException {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                PostAddress address = new PostAddress(data[1], data[0], data[3], data[2], data[4].charAt(0));
                MainStage.getPostList().add(address);
                //postView.getItems().add(address);
            }
        }catch (IOException e){
            ErrorDisplay.displayError(e.getLocalizedMessage());
        }finally{
            postView.refresh();
        }
    }

    /**
     * Shows information about application in popup|
     */
    private static void doShowInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("An awesome creation, created by me, T H O M A S");
        alert.setContentText("A wonderful application to save patient data");
        alert.showAndWait();
    }
    
    
}

