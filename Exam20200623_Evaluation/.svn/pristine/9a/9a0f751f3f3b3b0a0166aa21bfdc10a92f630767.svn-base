package evaluation;

import java.util.HashMap;
import java.util.Map;

public class Journal {
	private String name;
	private String discipline;
	private int score;
	private Map<String,Paper> papers = new HashMap<>();
	
	
	public Journal(String name, String discipline, int score) {
		this.name = name;
		this.score = score;
		this.discipline = discipline;
	}

	public String getName() {
		return name;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void addPaper(Paper p) {
		papers.put(p.getTitle(), p);
	}

	public Map<String, Paper> getPapers() {
		return papers;
	}

	public int getScore() {
		return score;
	}

}
