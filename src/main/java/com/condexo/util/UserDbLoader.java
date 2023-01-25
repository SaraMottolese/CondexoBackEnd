package com.condexo.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.condexo.model.User;
import com.condexo.serviceImpl.UserServiceImpl;

@Component
public class UserDbLoader implements CommandLineRunner{
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Value("${condexo.userPath}")
	private String userPath;

	@Override
	public void run(String... args) throws Exception {
		FileReader fileReader = new FileReader(userPath);
		try {
			List<User> userList = new ArrayList<>();
			userList = UserListReader.read(fileReader);
			for (User user : userList)
				userServiceImpl.post(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
