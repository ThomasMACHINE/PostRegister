package no.ntnu.idata2001.post;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class PostAddress implements Displayable {
    private String postTown;
    private String zipCode;
    private String municipalityName;
    private String municipalityNumber;
    private char category;

    /**
     * Creates a new PostAddress object using the mutator methods inside the class
     * @param postTown - The town of the post
     * @param zipCode - zipCode for the post
     * @param municipalityName - name of the Municipality for the post address
     */
    public PostAddress(String postTown, String zipCode, String municipalityName, String municipalityNumber, char category) {
        setPostTown(postTown);
        setZipCode(zipCode);
        setMunicipalityName(municipalityName);
        setMunicipalityNumber(municipalityNumber);
        setCategory(category);
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
     * Sets the name of the Municipality of the post address
     * @param municipalityName - new Street Address
     */
    public void setMunicipalityName(String municipalityName) {
        //Check for Null
        Objects.requireNonNull(municipalityName, "Street Address cannot be Null");
        //Check for empty name
        if(municipalityName.equals("")){
            throw new IllegalArgumentException("Street Address cannot be empty");
        }
        //Valid Street Address, set Street Address
        this.municipalityName = municipalityName;
    }

    public void setMunicipalityNumber(String municipalityNumber) {
        //Check for null
        Objects.requireNonNull(municipalityNumber, "Municipality Number cannot be Null");
        //Check for empty number
        if(municipalityNumber.equals("")){
            throw new IllegalArgumentException("MunicipalityNumber cannot be empty");
        }
        this.municipalityNumber = municipalityNumber;
    }

    public void setCategory(char category) {
        //Check for empty char
        if(category == ' '){
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
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
    public String getMunicipalityName() {
        return municipalityName;
    }

    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    public char getCategory() {
        return category;
    }

    /**
     * toString returns information about the Post Address object
     * @return Post Address in JSON format
     */
    @Override
    public String toString() {
        return "PostAddress{" +
                "postTown='" + postTown + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", municipalityName='" + municipalityName + '\'' +
                ", municipalityNumber='" + municipalityNumber + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostAddress that = (PostAddress) o;
        return category == that.category && Objects.equals(postTown, that.postTown) && Objects.equals(zipCode, that.zipCode) && Objects.equals(municipalityName, that.municipalityName) && Objects.equals(municipalityNumber, that.municipalityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postTown, zipCode, municipalityName, municipalityNumber, category);
    }

    @Override
    public LinkedHashMap<String, String> getDisplayFields() {
        LinkedHashMap<String, String> nameMap = new LinkedHashMap<>();
        nameMap.put("postTown", "Post Town");
        nameMap.put("zipCode", "Zip Code");
        nameMap.put("municipalityName", "Municipality");
        nameMap.put("municipalityNumber", "Mun. Code");
        nameMap.put("category", "Category");
        return nameMap;
    }
}
