package no.ntnu.idata2001.datastructs;

import java.util.Objects;

/**
 * File info is a Class that contains the information about how a file is constructed
 * With this information the parser has all information it needs to parse files
 */
public class FileInfo {
    private boolean header; // If the file contains an initial line explaining what each field is
    private int[] indexes; //The indexes of data that we want
    private String splitter; //The character that data is split by

    public FileInfo(boolean header, int[] indexes, String splitter) {
        this.header = header;
        setIndexes(indexes);
        setSplitter(splitter);
    }


    /**
     * Set splitter field
     * @param splitter - the characters that file is split by
     */
    public void setSplitter(String splitter) {
        //check for null
        Objects.requireNonNull(splitter, "Splitter cannot be null");
        //Check for empty string
        if(splitter.equals("")){
            throw new IllegalArgumentException("Splitter cannot be empty, how are we supposed to know how your file is split?");
        }
        this.splitter = splitter;
    }

    /**
     * Set index field
     * @param indexes - array of integers
     */
    public void setIndexes(int[] indexes) {
        //Check if null
        Objects.requireNonNull(indexes, "Indexes cannot be null");
        if(indexes.length < 5){
            throw new IllegalArgumentException("There must be 5 indexes to parse by");
        }
        this.indexes = indexes;
    }

    public int[] getIndexes() {
        return indexes;
    }

    public String getSplitter() {
        return splitter;
    }

    public boolean hasHeader() {
        return header;
    }
}
