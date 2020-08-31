package it.polito.oop.milliways;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Restaurant {
	private List<Race> races = new LinkedList<>();
	private List<Party> parties = new LinkedList<>();
	private Map<Integer, Hall> halls = new LinkedHashMap<>();

    public Restaurant() {
	}
	
	public Race defineRace(String name) throws MilliwaysException{
		if(races.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null) != null)
			throw new MilliwaysException();
		Race r = new Race(name);
		races.add(r);
	    return r;
	}
	
	public Party createParty() {
		Party p = new Party();
		parties.add(p);
	    return p;
	}
	
	public Hall defineHall(int id) throws MilliwaysException{
	    if(halls.containsKey(id))
	    	throw new MilliwaysException();
	    Hall h = new Hall(id);
	    halls.put(id, h);
	    return h;
	}

	public List<Hall> getHallList() {
		List<Hall> res = halls.values().stream().collect(Collectors.toList());
		return res;
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
		if(hall.isSuitable(party)==false)
			throw new MilliwaysException();
		hall.addParty(party);
        return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {
		Hall h = halls.values().stream().filter(x -> x.isSuitable(party)).findFirst().orElse(null);
        if(h == null)
        	throw new MilliwaysException();
        h.addParty(party);
		return h;
	}
	
	// Il metodo statComposition() riassume la composizione dei gruppi, ovvero gli esseri che sono stati
	// seduti al ristorante, secondo la loro razza. Il metodo restituisce una Map con la razza come chiave,
	// e il numero totale di esseri di tale razza presenti nei diversi gruppi che sono stati seduti.
	public Map<Race, Integer> statComposition() {
		return halls.values().stream().flatMap(h -> h.getParties().stream().
							flatMap(p -> p.getCompanions().entrySet().stream()))
				.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
	}
	
	// Il metodo statFacility() restituisce tutti i servizi disponibili nel ristorante, ordinati in base
	// al numero decrescente di saloni in cui sono disponibili e, a parità di numero, alfabeticamente.
	public List<String> statFacility() {		
		return halls.values().stream().flatMap(x -> x.getFacilities().stream())
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry<String, Long>::getValue, Comparator.reverseOrder())
								.thenComparing( Map.Entry<String, Long>::getKey))
				.map(Map.Entry<String, Long>::getKey).collect(Collectors.toList());
	}
	
	// Il metodo statHalls() restituisce una Map avente per chiave il numero di servizi disponibili
	// e come valore la lista dei codici dei saloni che offrono tale numero di servizi.
	// Sia le chiavi che i saloni sono in ordine crescente.
	public Map<Integer,List<Integer>> statHalls() {
		return halls.values().stream().collect(groupingBy(Hall::getNumFacilities, TreeMap::new, mapping(
													Hall::getId, collectingAndThen(toList(), l -> {
																			Collections.sort(l); return l;}))));
	}

}
