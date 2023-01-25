package com.condexo.util;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.condexo.model.Genre;
import com.condexo.model.User;
import com.condexo.model.UserType;
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
			user.setAddress(record[4]);
			user.setName(record[0]);
			user.setEmail(record[2]);
			user.setSurname(record[1]);
			user.setPhoneNumber(record[7]);
			user.setFiscalCode(record[3]);
			user.setDateOfBirth(dateOfBirth);
			if(record[11].equalsIgnoreCase("CONDOMINO"))
				user.setUserType(UserType.CONDOMINO);
			if(record[11].equalsIgnoreCase("AMMINISTRATORE"))
				user.setUserType(UserType.AMMINISTRATORE);
			if(record[11].equalsIgnoreCase("FORNITORE"))
				user.setUserType(UserType.FORNITORE);
			if(record[7].equalsIgnoreCase("Female"))
				user.setGenre(Genre.FEMALE);
			if(record[7].equalsIgnoreCase("Male"))
				user.setGenre(Genre.MALE);
			user.setZipCode(record[5]);
			user.setPassword(record[9]);
			user.setAge(Integer.parseInt(record[10]));
			userList.add(user);
		}
		reader.close();
		return userList;
	}

}
