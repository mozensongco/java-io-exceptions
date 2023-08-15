package userValidator;

import java.io.*;

public class UserDataValidator {
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter validWriter = null;
		BufferedWriter errorWriter = null;
		
		try {
			reader = new BufferedReader(new FileReader("src/data/user_data.txt"));
			validWriter = new BufferedWriter(new FileWriter ("src/data/valid_data.txt"));
			errorWriter = new BufferedWriter(new FileWriter("src/data/invalid_data.txt"));
			
			String stuff;
			while ((stuff = reader.readLine()) != null) {
				String[] things = stuff.split(","); 
				String name;
				String email;
				int age;
				
				try {
					if (things.length != 3) {
						throw new Exception("Missing Data");
					} else {
						name = things[0].trim();
						email = things[1].trim();
						age = Integer.parseInt(things[2].trim());
						if (age <= 0) {
							throw new Exception("Invalid Age");
						}
						validWriter.write(stuff + "\n");
					}
				} catch (Exception e) {
					errorWriter.write(stuff + " " + e + "\n");
				}
			}
			reader.close();
			validWriter.close();
			errorWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		

	}
}