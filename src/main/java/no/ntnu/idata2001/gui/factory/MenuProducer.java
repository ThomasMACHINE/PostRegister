package no.ntnu.idata2001.gui.factory;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idata2001.datastructs.FileInfo;
import no.ntnu.idata2001.gui.MainStage;
import no.ntnu.idata2001.post.PostAddress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * MenuProducer is a factory class for producing different Menus
 */
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

        MenuItem advancedOpenFile = new MenuItem("Import from File Advanced");
        advancedOpenFile.setOnAction(e -> {
            try {
                FileInfo fileInfo = InputDisplayProducer.getFileInformation();
                if(fileInfo == null){
                    return;
                }
                else {
                    doLoadFileAdvanced(postView, fileInfo);
                }
            } catch (IOException ioException) {
                ErrorDisplay.displayError(ioException.getLocalizedMessage());
            }
        });
        //Add to menuFile
        menuFile.getItems().addAll(openFile, advancedOpenFile);
        //EditMenu

        //HelpMenu
        Menu menuView = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> doShowInfo());
        //Add to help
        menuView.getItems().addAll(about);
        //Add all menuFiles to the MenuBar
        menuBar.getMenus().addAll(menuFile, menuView);
        //Return MenuBar
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
        if(file == null){
            return;
        }
        else {
            parseFile(file, postView);
        }
    }

    /**
     * Parses a file with post addresses and adds them to the table view
     * @param file - File with post address data
     * @param postView - TableView that the addresses gets put into
     * @throws IOException - Throws exception if theres an error with the file
     */
    private static void parseFile(File file, TableView<PostAddress> postView) {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                PostAddress address = new PostAddress(data[1], data[0], data[3], data[2], data[4].charAt(0));
                MainStage.getPostList().add(address);
                //MainStage.getPostRegister().addPostAddress(address);
                //postView.getItems().add(address);
            }
        }catch (IOException e){
            ErrorDisplay.displayError(e.getLocalizedMessage());
        }finally{
            postView.refresh();
        }
    }

    /**
     * Opens a dialog to allow easy selection of .csv file, on success it parses it into postView
     * @param postView - TableView that contains all patients
     * @throws IOException - Throws IO exception if there is an error with the file
     */
    private static void doLoadFileAdvanced(TableView<PostAddress> postView, FileInfo fileInfo) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        File file = fileChooser.showOpenDialog(stage);
        parseFileAdvanced(file, postView, fileInfo);
    }

    /**
     * parseFileAdvanced gets input from user on how the file is supposed to be parsed and parses it like method parseFile
     * @param file - file to be parsed
     * @param postView - TableView to be updated
     * @param fileInfo - object that holds all information about the file
     */
    private static void parseFileAdvanced(File file, TableView<PostAddress> postView, FileInfo fileInfo) {
        String line;
        try {
            //Get index and splitter characters from fileInfo
            var index = fileInfo.getIndexes();
            var splitType = fileInfo.getSplitter();

            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            //If there is a header in the file, read that line so it does not get parsed
            if(fileInfo.hasHeader()){
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(splitType);
                PostAddress address = new PostAddress(data[index[0]], data[index[1]], data[index[2]], data[index[3]], data[index[4]].charAt(0));
                MainStage.getPostList().add(address);
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
        alert.setContentText("README: https://github.com/ThomasMACHINE/PostRegister");
        alert.showAndWait();
    }
}

