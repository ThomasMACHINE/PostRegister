package no.ntnu.idata2001.post;

import java.util.ArrayList;
import java.util.Objects;

public class PostRegister {
    private String registerName; //Register name
    private ArrayList<PostAddress> addresses; //ArrayList for holding all PostAddresses

    public PostRegister(String registerName) {
        setRegisterName(registerName);
        this.addresses = new ArrayList<>();
    }

    public String getRegisterName() {
        return registerName;
    }

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

    public ArrayList<PostAddress> getAddresses() {
        return addresses;
    }
}
