package ch.zhaw.exercise.le05a.task8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;


public class PersonCsvConverter {

	public  String personToCsv(Person person, String splitter) {

		return person.getName() + splitter +
				person.getVorname() + splitter +
				person.getStrasse() + splitter +
				person.getHausnummer() + splitter +
				person.getPlz() + splitter +
				person.getWohnort() + splitter +
				person.getGeburtsdatum().get(Calendar.DAY_OF_MONTH) + "." +
				person.getGeburtsdatum().get(Calendar.MONTH) + "." +
				person.getGeburtsdatum().get(Calendar.YEAR);
	}


	public  Person csvToPerson(String line,  String splitter) {
		String [] result = line.split(splitter + "|\r|\\.");
		GregorianCalendar tmpDate = new GregorianCalendar(
				Integer.parseInt(result[8]),
				Integer.parseInt(result[7])-1,
				Integer.parseInt(result[6])
		);

		return new Person(result[0], // Name
				result[1], // Vorname
				tmpDate,   // Geburtsdatum
				result[2], // Strasse
				result[3], // Hausnummer
				result[5], // Wohnort
				Integer.parseInt(result[4]));  // PLZ
	}

	public  List<Person> readPersonFile (String fileName, String splitter) throws IOException {

		String line;
		List<Person> persons = new ArrayList<Person>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while ((line = reader.readLine()) != null)  {
				persons.add(csvToPerson(line, splitter));
			}
		}
		return persons;
	}

	public void writePersonFile (Collection<Person> persons, String fileName, String splitter)
			throws IOException {

		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
			for  (Person person : persons) {
				String line = personToCsv(person, splitter);
				writer.println(line);
			}
		}

	}
}
