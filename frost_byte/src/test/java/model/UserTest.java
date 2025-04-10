/**
 * @author Katie Turner
 */
package model;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.model.User;



public class UserTest {
   

    private UUID testId = UUID.randomUUID();
    
    private User user = new User(testId, "testUser", "John", "Doe", "john.doe@example.com", "securePass123", true);
    //private User user;
    @Test
    public void testTesting(){
        assertTrue(true);
    }
    
    @Test
    public void testToString() {
        String expectedString = "username: testUser\n, first name: \nJohn, last name: \nDoe, password: \nsecurePass123";
        assertEquals(expectedString, user.toString());
    }
    
}
