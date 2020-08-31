package it.polito.oop.milliways;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Party {
	private Map<Race, Integer> companions = new HashMap<>();

    public void addCompanions(Race race, int num) {
    	if(companions.get(race)==null)
    		companions.put(race, num);
    	else companions.put(race, companions.get(race)+num);
	}

	public int getNum() {
        return companions.values().stream().collect(Collectors.summingInt(x -> x));
	}

	public int getNum(Race race) {
	    return companions.get(race);
	}

	public List<String> getRequirements() {
		Set<String> res = new TreeSet<>();
		companions.keySet().stream().forEach(x -> x.getRequirements().stream().forEach(y -> res.add(y)));
        return res.stream().sorted().collect(Collectors.toList());
	}

    public Map<String,Integer> getDescription(){
    	Map<String,Integer> res = new HashMap<>();
    	for(Race r : companions.keySet()) {
    		res.put(r.getName(), companions.get(r));
    	}
    	return res;
    }

	public Map<Race, Integer> getCompanions() {
		return companions;
	}
    
}
