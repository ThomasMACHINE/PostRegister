package no.ntnu.idata2001.post;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Displayable interface is for all the classes of PostAddresses that will be displayed inside a TableView
 * it's main purpose is to present data to the producers to allow the producer classes to format the object for any class
 * in the same function
 */
public interface Displayable {
    /**
     * All PostAddress objects implements their own getDisplayFields method to tell the TableViewProducer
     * which fields of the object should be displayed with which name
     * @return
     */
    LinkedHashMap<String, String> getDisplayFields();
}
