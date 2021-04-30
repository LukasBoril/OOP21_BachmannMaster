package ch.zhaw.homework.le05.v4easy;

import java.io.IOException;
import java.util.List;

/**
 * IOStrategy to allow the implementation of several option for saving decisions to a file
 */
public interface IOStrategy {

	/**
	 * Save the decision to a file depending on the chosen strategy, e.g. ObjectStreamStrategy, FileIOStrategy
	 * @param fileName the fileName including path
	 * @param decisions the decision values to save
	 * @throws IOException in case of save exceptions
	 */
	void save(String fileName, List<String> decisions) throws IOException;

	/**
	 * Load the decision from a file depending on the chosen strategy, e.g. ObjectStreamStrategy, FileIOStrategy
	 * @param fileName the fileName including path
	 * @return the loaded decisions
	 * @throws IOException in case of save exceptions
	 * @throws ClassNotFoundException in case of casting exceptions
	 */
	List<String> load(String fileName) throws IOException, ClassNotFoundException;

}
