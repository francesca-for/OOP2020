package evaluation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Member {
	private String name;
	private Map<String,Paper> papers = new HashMap<>();

	public Member(String m) {
		this.name = m;
	}

	public String getName() {
		return name;
	}

	public void addPaper(Paper p) {
		papers.put(p.getTitle(), p);	
	}

	public List<Paper> getPapers() {
		List<Paper> res = papers.values().stream().collect(Collectors.toList());
		return res;
	}

}
