package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.Console;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;
import org.apache.maven.plugin.surefire.log.api.ConsoleLoggerUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import model.User;

public class UserServiceTest {
	public UserService userService ;
	public String firstname ;
	public String lastname ;
	public String email;
	public String password;
	public String repeatPassword ;
	
	
	
	@BeforeEach
	public void init() {
		 userService = new UserServiceImpl();
		 firstname = "Antoni";
		 lastname ="Kurniawan";
		 email = "antoni@email.com";
		 password = "rahasia";
		 repeatPassword ="rahasia";
		 
	}
	
	//green test / positive test
	@DisplayName("User object is created")
	@Test
	//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testCreateUser_WhenDetailIsProvide_ReturnUserObject() {
		
	
	
		//Act
	  
	    
		User user = userService.createUser(firstname, lastname, email, password, repeatPassword);
		
		
		 
		
		assertTimeout(Duration.ofMillis(500), ()->{
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		  
		//Assert
		
		assertNotNull(user,"if createuser success should not return null");
		assertEquals(firstname, user.getFirstName(),"User first name is incorrect");
		assertEquals(lastname, user.getLastName(),"User lastName name is incorrect");
		assertEquals(email, user.getEmail(),"User email  is incorrect");
		assertNotNull(user.getId(),"User id cannot null");
		
		
	}
	
	
	//red test / negative test
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
		
		//Arrange
		
		String	 firstname = "";
	
		String expectedExceptionMessage = "User first name is empty";
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstname, lastname, email, password, repeatPassword);
		},"Empyt first name cause Illegal Argument Exception");
		
		
		//Assert
		assertEquals(expectedExceptionMessage, thrown.getMessage());
	}
	
	//red test / negative test
	@DisplayName("Empty last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameIsEmpty_ThrowsIllegalException() {
		//Arrange
	
		String	 lastname ="";
	
				String expectedExceptionMessage = "User last name is empty";
				//Act
				IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
					userService.createUser(firstname, lastname, email, password, repeatPassword);
				},"Empyt last name cause Illegal Argument Exception");
	
	//Assert
			assertEquals(expectedExceptionMessage, thrown.getMessage());
	}
}
