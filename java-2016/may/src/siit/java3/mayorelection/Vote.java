package siit.java3.mayorelection;

import java.util.Date;

public class Vote {
	/* date when voting was done */
	private Date date;
	/* CNP of voter */
	private String CNP;
	/* name of voter */
	private String name;
	/* list of candidates */
	private CandidateList candidate;

	/*
	 * Constructor for Vote class
	 */
	public Vote(Date date, String CNP, String name, CandidateList candidate) {
		this.date = date;
		this.CNP = CNP;
		this.name = name;
		this.candidate = candidate;

	}

	/* retuns date */
	public Date getDate() {
		return date;
	}

	/* retuns CNP */
	public String getCNP() {
		return CNP;
	}

	/* retuns name */
	public String getName() {
		return name;
	}
	/* returns the name of the candidate on witch the vote has benn casted */
	public CandidateList getCandidate() {
		return candidate;
	}

	@Override
	public String toString() {
		return "Vote [CNP=" + CNP + ", name=" + name + ", candidate=" + candidate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNP == null) ? 0 : CNP.hashCode());
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (CNP == null) {
			if (other.CNP != null)
				return false;
		} else if (!CNP.equals(other.CNP))
			return false;
		if (candidate != other.candidate)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
