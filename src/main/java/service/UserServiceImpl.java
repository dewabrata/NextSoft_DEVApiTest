package service;

import java.util.UUID;

import Util.File;
import Util.Sendmail;
import model.User;


//class factory
public class UserServiceImpl implements UserService , EmailService {

	public User createUser(String firstname, String lastname, String email, String password, String repeatPassword) {
		// TODO Auto-generated method stub
		if(firstname == null || firstname.trim().length()==0) {
			throw new IllegalArgumentException("User first name is empty");
		}
		
		
		if(lastname == null || lastname.trim().length()==0) {
			throw new IllegalArgumentException("User last name is empty");
		}
		
		
		
		return new User(firstname, lastname, email, UUID.randomUUID().toString());
	}

	public void Test() {
		
	}

	@Override
	public void addAttachment() {
		// TODO Auto-generated method stub
		File file = new File();
		file.createAttachment();
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		
		Sendmail mail = new Sendmail();
		mail.sendMail();
		
	}
	
	
	
	
	
}
