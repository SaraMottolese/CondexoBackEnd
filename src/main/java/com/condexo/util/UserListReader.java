package com.condexo.util;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.condexo.model.User;
import com.opencsv.CSVReader;

public class UserListReader {
	
	public static List<User> read(FileReader file) throws IOException, ParseException {
		CSVReader reader= new CSVReader(file,',','\'');
		List<User> userList= new ArrayList<>();
		String[] record=null;
		while ((record = reader.readNext()) != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dateOfBirth = LocalDate.parse(record[6], formatter);
			User user= new User();
			user.setAddress(record[3]);
			user.setName(record[0]);
			user.setEmail(record[2]);
			user.setSurname(record[1]);
			user.setPhoneNumber(record[4]);
			user.setFiscalCode(record[5]);
			user.setDateOfBirth(dateOfBirth);
			userList.add(user);
		}
		reader.close();
		return userList;
	}

}
