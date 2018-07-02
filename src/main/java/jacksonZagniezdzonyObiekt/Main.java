package jacksonZagniezdzonyObiekt;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		
		try {
			//utworzenie mapperra
			ObjectMapper objectMapper = new ObjectMapper();
			
			//wczytanie pliku JSON i konwersja do POJO
			Student student = objectMapper.readValue(new File("json/sample-full.json"), Student.class);
			
			//wydruk pol
			System.out.println(student);
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}