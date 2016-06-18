package siit.java3.mayorelection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVVoteFormater {

	private static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MMM-dd hh:mm");

	/*
	 * Adds a vote to CSV
	 */
	public String toCSV(Vote vote) {
		return DATE_FORMATER.format(vote.getDate()) + "," + vote.getCNP() + "," + vote.getName() + "," + vote.getCandidate();

	}

	/*
	 * Creates a vote instance that is generated from the CSV file
	 */
	public Vote fromCSV(String csvLine) throws ParseException {
		String[] tokens = csvLine.split(",");
		Date d = DATE_FORMATER.parse(tokens[0]);
		String cnp = tokens[1];
		String n = tokens[2];
		CandidateList c = CandidateList.valueOf(tokens[3]);

		return new Vote(d, cnp, n, c);

	}

}
