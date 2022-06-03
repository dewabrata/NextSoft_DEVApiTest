package service;

import model.User;

public interface UserService {

	public  User createUser(String firstname, String lastname, String email, String password, String repeatPassword);
}
