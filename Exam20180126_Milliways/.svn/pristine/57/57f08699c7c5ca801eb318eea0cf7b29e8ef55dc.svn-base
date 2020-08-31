package it.polito.oop.milliways;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Hall {
	private int idHall;
	private List<String> facilities = new LinkedList<>();
	private List<Party> parties = new LinkedList<>();

	public Hall(int id) {
		this.idHall = id;
	}

	public int getId() {
		return idHall;
	}

	public void addFacility(String facility) throws MilliwaysException {
		if(facilities.stream().filter(x -> x.compareTo(facility)==0).findAny().orElse(null) != null)
			throw new MilliwaysException();
		facilities.add(facility);
	}

	public List<String> getFacilities() {
        return facilities.stream().sorted().collect(Collectors.toList());
	}
	
	int getNumFacilities(){
        return facilities.size();
	}

	public boolean isSuitable(Party party) {
		boolean suitable = false;
		for(String r : party.getRequirements()) {
			if(facilities.stream().filter(x -> x.equals(r)).findFirst().orElse(null)==null)
				return false;
		}
		return true;
	}
	
	public void addParty(Party party) {
		parties.add(party);
	}

	public int getIdHall() {
		return idHall;
	}

	public List<Party> getParties() {
		return parties;
	}
	
}
