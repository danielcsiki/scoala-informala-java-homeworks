package siit.java3.mayorelection;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class VoteTest {

	@Test
	public void addingVotes() throws Exception {
		CSVVoteRepository repo = new CSVVoteRepository();
		VoteRecords records = new VoteRecords(repo);

		records.addVote(new Vote(new Date(), "1900909002236", "Rajit", CandidateList.Bundy));
		records.addVote(new Vote(new Date(), "2900904302236", "Rambo", CandidateList.Mutley));
		records.addVote(new Vote(new Date(), "8888888888888", "Idiot", CandidateList.Gringo));
		records.addVote(new Vote(new Date(), "9555682954009", "Sandeep", CandidateList.Mutley));
		records.addVote(new Vote(new Date(), "6789293661803", "Random Guy", CandidateList.Bundy));
		records.addVote(new Vote(new Date(), "6789293661803", "Samir", CandidateList.Bundy));

		Map<CandidateList, Integer> report = records.generateReport();
		for (Entry<CandidateList, Integer> entry : report.entrySet()) {
			System.out.println(entry.getKey().name() + " - " + entry.getValue() + "%");
		}
	}

}
