package no.ntnu.idata2001;

import no.ntnu.idata2001.post.PostAddress;
import no.ntnu.idata2001.post.PostRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PostRegisterTest class is a class for testing all PostRegister functionalities
 */
public class PostRegisterTest {

    private PostRegister register;
    private PostAddress post;
    private PostAddress identicalPost;
    private PostAddress post2;

    @BeforeEach
    void setup() {
        register = new PostRegister("Norway");
        post = new PostAddress("Orkanger", "7300", "Orkland", "5059", 'G');
        identicalPost = new PostAddress("Orkanger", "7300", "Orkland", "5059", 'G');
        post2 = new PostAddress("a","a","a","a", 'p');
    }

    @Test
    void constructorTest(){
        assertNotNull(register);
    }
    // =============== POSITIVE TESTS ======================

    /**
     * Checks if adding post works
     */
    @Test
    void addTest(){
        int before = register.getAddresses().size();
        //Add address
        register.addPostAddress(post);
        int after = register.getAddresses().size();

        assertNotEquals(before, after);
    }

    /**
     * Tests if it removes a post that exists in the address list
     */
    @Test
    void deleteByPost(){
        register.addPostAddress(post);
        int before = register.getAddresses().size();
        register.deleteAddress(post);
        int after = register.getAddresses().size();
        assertNotEquals(before, after);
    }

    /**
     * Check if adding post works
     */
    @Test
    void addPost(){
        int before = register.getAddresses().size();
        register.addPostAddress(post);
        int after = register.getAddresses().size();
        assertNotEquals(before, after);
    }
    /**
     * Check if finding an Address by zip works
     */
    @Test
    void checkZipSearch(){
        register.addPostAddress(post);
        String zip = post.getZipCode();
        PostAddress foundPost = register.getAddressByZip(zip);
        assertNotNull(foundPost);
    }
    /**
     * Check if editing register name works
     */
    @Test
    void changeRegisterName(){
        register.setRegisterName("Spain");
        assert(register.getRegisterName().equals("Spain"));
    }
    //================ NEGATIVE TESTING ===============================
    /**
     * Checks that adding an identical Post will not get added to the register
     */
    @Test
    void addIdenticalPost(){
        register.addPostAddress(post);
        var result = false;
        try {
            register.addPostAddress(identicalPost);
            result = true;
        } catch (IllegalArgumentException ignored){}
        assertFalse(result);
    }
    /**
     * Checks if deleting Null post is handled by throwing an exception
     */
    @Test
    void deleteByPostNull(){
        boolean result = false;
        try {
            register.deleteAddress(null);
            result = true;
        }catch (NullPointerException ignore) {}
        assert(result == false);
    }

    /**
     * Check that deleting a nonExistingPost in list does not delete anything
     */
    @Test
    void deleteNonExistentPost(){
        register.addPostAddress(post);
        int before = register.getAddresses().size();
        register.deleteAddress(post2);
        int after = register.getAddresses().size();
        assertEquals(before, after);
    }

    /**
     * Checks that PostRegister handles adding null properly
     */
    @Test
    void addNullToRegister(){
        boolean result = false;
        try {
            register.addPostAddress(null);
            result = true;
        } catch (NullPointerException ignore) {}
        assertFalse(result);
    }
}
