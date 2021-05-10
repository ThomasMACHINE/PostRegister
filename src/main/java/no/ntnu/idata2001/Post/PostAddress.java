package no.ntnu.idata2001.Post;

import java.util.Objects;

public class PostAddress {
    private String postTown;
    private String zipCode;
    private String streetAddress;

    /**
     * Creates a new PostAddress object using the mutator methods inside the class
     * @param postTown - The town of the post
     * @param zipCode - zipCode for the post
     * @param streetAddress - streetAddress for the post
     */
    public PostAddress(String postTown, String zipCode, String streetAddress) {
        setPostTown(postTown);
        setZipCode(zipCode);
        setStreetAddress(streetAddress);
    }


    //Mutator methods

    /**
     * Sets the Post Town of the post address
     * @param postTown - new Post Town
     */
    public void setPostTown(String postTown) {
        //Check for null
        Objects.requireNonNull(postTown, "Post Town cannot be Null");
        //Check for empty string
        if(postTown.equals("")){
            throw new IllegalArgumentException("Post Town cannot be empty");
        }
        //Valid Post Town, set Post Town
        this.postTown = postTown;
    }

    /**
     * Sets the Zip Code of the post address
     * @param zipCode - new Zip Code
     */
    public void setZipCode(String zipCode) {
        //Check for Null
        Objects.requireNonNull(zipCode, "Zip Code cannot be Null");
        //Check for empty zipCode
        if(zipCode.equals("")){
            throw new IllegalArgumentException("Zip code cannot be empty");
        }
        //Valid Zip Code, set zipCode
        this.zipCode = zipCode;
    }

    /**
     * Sets the Street Address of the post address
     * @param streetAddress - new Street Address
     */
    public void setStreetAddress(String streetAddress) {
        //Check for Null
        Objects.requireNonNull(streetAddress, "Street Address cannot be Null");
        //Check for empty address
        if(streetAddress.equals("")){
            throw new IllegalArgumentException("Street Address cannot be empty");
        }
        //Valid Street Address, set Street Address
        this.streetAddress = streetAddress;
    }


    //Accessor methods
    /**
     * getZipCode is an accessor method for the zipCode field of the post address
     * @return post town of the post address
     */
    public String getPostTown() {
        return postTown;
    }

    /**
     * getZipCode is an accessor method for the zipCode field of the post address
     * @return zip code of the post address
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * getZipCode is an accessor method for the zipCode field of the post address
     * @return street address of the post address
     */
    public String getStreetAddress() {
        return streetAddress;
    }
}
