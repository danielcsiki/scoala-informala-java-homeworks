package siit.java3.mayorelection;
import java.util.List;

public interface VoteRepository {
	/* 
	 * saves a vote
	 */
	void save(Vote vote) throws Exception;
	/*
	 * loads all the votes
	 */
	List<Vote> loadAll() throws Exception;
	

}














