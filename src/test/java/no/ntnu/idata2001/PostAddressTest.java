package no.ntnu.idata2001;

import no.ntnu.idata2001.post.PostAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PostAddressTest class is a class for testing all PostAddress functionalities
 */
public class PostAddressTest {

    private PostAddress post;
    private PostAddress identicalPost;
    @BeforeEach
    void setup() {
        post = new PostAddress("Orkanger", "7300", "Orkland", "5059", 'G');
        identicalPost = new PostAddress("Orkanger", "7300", "Orkland", "5059", 'G');
    }

    /**
     * Testing constructor
     */
    @Test
    void constructorTest(){
        assertNotNull(post);
    }

    /**
     * Testing if mutator methods for string fields work
     */
    @Test
    void editStringFields(){
        post.setPostTown("Sheffield");
        post.setMunicipalityName("England");
        post.setZipCode("1234");
        post.setMunicipalityNumber("1245");
        assertTrue(post.getPostTown().equals("Sheffield") &&
                post.getMunicipalityName().equals("England") &&
                post.getZipCode().equals("1234") &&
                post.getMunicipalityNumber().equals("1245"));
    }

    /**
     * Testing if mutator methods on character fields works
     */
    @Test
    void editCharFields(){
        post.setCategory('P');
        assertTrue(post.getCategory() == 'P');
    }

    /**
     * Checks that the equal methods works
     */
    @Test
    void checkEqual(){
        boolean result = post.equals(identicalPost);
        assertTrue(result);
    }
    // ============================== NEGATIVE TESTS =========================================
    /**
     * Tests if constructor (which uses the mutator methods) handles empty character properly
     */
    @Test
    void emptyChar(){
        boolean result = false;
        try{
            PostAddress post = new PostAddress("null", "null", "null", "a", 'P');
            result = true;
        }catch (IllegalArgumentException ignored) {}

        assertTrue(result == false);
    }

    /**
     * Tests if it is possible to initialize with empty string fields
     */
    @Test
    void emptyString() {
        boolean result = false;
        try{
            PostAddress post = new PostAddress("", "", "", "", 'P');
            result = true;
        }catch (IllegalArgumentException ignored) {}

        assertTrue(result == false);
    }

    /**
     * Tests if constructor (which uses the mutator methods) handles null values properly
     */
    @Test
    void nullValuesInConstructor(){
        boolean result = false;
        try{
            PostAddress post = new PostAddress(null, null, null, null, 'P');
            result = true;
        }catch (NullPointerException ignored) {}

        assertTrue(result == false);
    }
}
