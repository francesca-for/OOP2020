package evaluation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Group {
	private String name;
	private List<String> disciplines = new LinkedList<>();
	private Map<String, Member> members = new HashMap<>();

	public Group(String name, String[] disciplines) {
		this.name = name;
		for(String d : disciplines)
			this.disciplines.add(d);
	}

	public String getName() {
		return name;
	}

	public List<String> getDisciplines() {
		return disciplines;
	}

	public List<String> getMembers() {
		List<String> res = members.values().stream().map(x -> x.getName()).sorted().collect(Collectors.toList());
		return res;
	}

	public void addMember(Member member) {
		members.put(member.getName(), member);
	}

}
