package siit.java3.mayorelection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVVoteRepository implements VoteRepository {

	protected static final String CSV_FILE_NAME = "votes.csv";
	protected CSVVoteFormater csvFormater = new CSVVoteFormater();

	/*
	 * (non-Javadoc)
	 * @see siit.java3.mayorelection.VoteRepository#save(siit.java3.mayorelection.Vote)
	 */
	 
	@Override
	public void save(Vote vote) throws Exception {

		File file = new File(CSV_FILE_NAME);
		try (FileWriter writer = new FileWriter(file, true)) {
			writer.append(csvFormater.toCSV(vote) + "\n");
		}

	}

	/*
	 * (non-Javadoc)
	 * @see siit.java3.mayorelection.VoteRepository#loadAll()
	 */
	@Override
	public List<Vote> loadAll() throws Exception {
		File file = new File(CSV_FILE_NAME);
		ArrayList<Vote> votes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				Vote e = csvFormater.fromCSV(line);
				votes.add(e);
				line = reader.readLine();
			}
		}

		return votes;
	}

	

}
