package it.polito.oop.milliways;

import static java.util.stream.Collectors.*;
import java.util.LinkedList;
import java.util.List;

public class Race {
	private String name;
	private List<String> requirements = new LinkedList<>();
    
	public Race(String name) {
		this.name = name;
	}

	public void addRequirement(String requirement) throws MilliwaysException {
		if(requirements.stream().filter(x -> x.equals(requirement)).findAny().orElse(null) != null)
			throw new MilliwaysException();
		requirements.add(requirement);
	}
	
	public List<String> getRequirements() {
        List<String> res = requirements.stream().sorted().collect(toList());
        return res;
	}
	
	public String getName() {
        return name;
	}
}
