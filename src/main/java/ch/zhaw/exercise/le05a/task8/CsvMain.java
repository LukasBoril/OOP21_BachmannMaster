package ch.zhaw.exercise.le05a.task8;

import java.io.IOException;
import java.util.List;

public class CsvMain {

	public static void main (String[] args){
		PersonCsvConverter pcc = new PersonCsvConverter();
		String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task8/";
		try {
			List<Person> persons = pcc.readPersonFile(pathToPackage + "personen.csv", ";");
			printPerson (persons);
			pcc.writePersonFile(persons, pathToPackage + "personen3.csv", ";");


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printPerson(List<Person> persons) {
		for (Person person : persons)
			System.out.println(person.print());
	}

}
