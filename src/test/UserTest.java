import static org.junit.Assert.*;

import org.junit.Test;

import classes.User;

public class UserTest {

	@Test
	public void defaultConstructorTest() {
		User user = new User();
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		
		assertEquals(0, id);
		assertEquals(null, firstName);
		assertEquals(null, lastName);
		assertEquals(null, email);
		assertEquals(null, password);
		assertEquals(null, phoneNumber);
	}
	
	@Test
	public void fullConstructorTest() {
		User user = new User(1, "success", "success2", "success3", "success4", "success5");
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
	}
	
	@Test
	public void settersAndGettersTest() {
		User user = new User(-1, "fail", "fail2", "fail3", "fail4", "fail5");
		
		user.setId(1);
		user.setFirstName("success");
		user.setLastName("success2");
		user.setEmail("success3");
		user.setPassword("success4");
		user.setPhoneNumber("success5");
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
	}

}
