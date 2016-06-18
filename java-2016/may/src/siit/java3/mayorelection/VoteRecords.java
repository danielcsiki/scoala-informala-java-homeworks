package siit.java3.mayorelection;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class VoteRecords {

	private VoteRepository repo;

	/*
	 * Constructor for VoteRepository class
	 */
	public VoteRecords(VoteRepository repo) {
		super();
		this.repo = repo;
	}
	
	/*
	 * Adds vote in repository
	 */
	public void addVote(Vote vote) throws Exception {
		if (validateCNP(vote.getCNP())) {

			repo.save(vote);
		}

	}

	/*
	 * Checks if CNP is valid or not
	 */
	private boolean validateCNP(String cnp) {
		if (cnp.length() == 13) {
			return true;
		}
		return false;

	}

	/*
	 * Genereates report on all casted votes
	 * The winner of the elections is printed
	 */
	public Map<CandidateList, Integer> generateReport() throws Exception {
		List<Vote> votes = repo.loadAll();
		Map<CandidateList, Integer> report = new HashMap<>();
		int totalVotes = calculateTotalVotes(votes);
		int winningPercentage = 0;
		String winnerName = null;
		for (CandidateList candidate : CandidateList.values()) {
			int candidateTotal = calculateTotalforCandidate(candidate, votes);
			report.put(candidate, calculatePercentage(totalVotes, candidateTotal));
			if(candidateTotal> winningPercentage){
				winningPercentage = candidateTotal;
				winnerName = candidate.name();
			}
			
		}
		System.out.println("Elected Mayor: " +winnerName);
		return report;
	}

	/*
	 * Returns the percentage of votes that the candidate has obtained in the elections
	 */
	private Integer calculatePercentage(int totalVotes, int candidateTotal) {

		return candidateTotal * 100 / totalVotes;
	}

	/*
	 * Returns the total number of votes that a candidate has received
	 */
	private int calculateTotalforCandidate(CandidateList candidate, List<Vote> votes) {
		int totalVotes = 0;
		for (Vote v : votes) {
			if (candidate.equals(v.getCandidate())) {
				totalVotes += 1;
			}
		}
		return totalVotes;
	}

	/*
	 * Returns the total number of votes
	 */
	private int calculateTotalVotes(List<Vote> votes) {
		int totalVotes = 0;
		for (Vote v : votes) {
			totalVotes += 1;
		}
		return totalVotes;
	}
	
	
		
	}

