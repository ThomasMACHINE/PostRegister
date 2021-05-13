package no.ntnu.idata2001.post;

import java.util.ArrayList;
import java.util.Objects;

/**
 * PostRegister is the class that holds PostAddresses
 */
public class PostRegister {
    private String registerName; //Register name
    private ArrayList<PostAddress> addresses; //ArrayList for holding all PostAddresses

    /**
     * Constructor, creates a new PostRegister object
     * @param registerName - the name of the register
     */
    public PostRegister(String registerName) {
        setRegisterName(registerName);
        this.addresses = new ArrayList<>();
    }

    /**
     * Accessor method for register name
     * @return register name
     */
    public String getRegisterName() {
        return registerName;
    }

    /**
     * Adds postAddress to the list if it is not equal to any of the other addresses in the list
     * @param address - address to be added
     */
    public void addPostAddress(PostAddress address){
        Objects.requireNonNull(address, "Address cannot be null");

        for(PostAddress existingAddress : addresses) {
            if (existingAddress.equals(address)) {
                throw new IllegalArgumentException("Address already exists");
            }
        }
        //Valid address
        addresses.add(address);
    }

    /**
     * Mutator method, changes register name
     * @param registerName - new register name
     */
    public void setRegisterName(String registerName) {
        //Check not null
        Objects.requireNonNull(registerName, "Register Name cannot be null");
        //Check not empty
        if(registerName.equals("")){
            throw new IllegalArgumentException("Register Name cannot be empty");
        }
        //Valid Register name
        this.registerName = registerName;
    }

    /**
     * Find address by zip
     * @param zip - zip code of the post address to be found
     * @return - postAddress if found
     */
    public PostAddress getAddressByZip(String zip){
        for(PostAddress address : addresses){
            if(address.getZipCode().equals(zip)){
                return address;
            }
        }
        return null;
    }
    public ArrayList<PostAddress> getAddresses() {
        return addresses;
    }

    /**
     * Mutator method, delete by Zip as it is unique for every countrys post-addresses
     * @param zip - zip code of the address
     */
    public void deleteAddressByZip(String zip){
        PostAddress post = getAddressByZip(zip);

        if(post == null){
            return;
        }
        else{
            addresses.remove(post);
        }
    }

    /**
     * Mutator method, deletes a post from the list
     * @param post - post to be deleted
     */
    public void deleteAddress(PostAddress post){
        if(post == null){
            throw new NullPointerException();
        }
        else {
            addresses.remove(post);
        }
    }
}
