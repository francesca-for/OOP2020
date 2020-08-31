package mountainhuts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Class {@code Region} represents the main facade
 * class for the mountains hut system.
 * 
 * It allows defining and retrieving information about
 * municipalities and mountain huts.
 *
 */
public class Region {
	private String name;
	private List<AltitudeRange> ranges = new LinkedList<>();
	private Map<String, Municipality> municipalities = new HashMap<>();
	private Map<String, MountainHut> mountainHuts = new HashMap<>();
	
	/**
	 * Create a region with the given name.
	 * 
	 * @param name
	 *            the name of the region
	 */
	public Region(String name) {
		this.name = name;
	}

	/**
	 * Return the name of the region.
	 * 
	 * @return the name of the region
	 */
	public String getName() {
		return name;
	}

	/**
	 * Create the ranges given their textual representation in the format
	 * "[minValue]-[maxValue]".
	 * 
	 * @param ranges
	 *            an array of textual ranges
	 */
	public void setAltitudeRanges(String... ranges) {
		for(String r : ranges) {
			AltitudeRange a = new AltitudeRange(r);
			this.ranges.add(a);
		}
	}

	/**
	 * Return the textual representation in the format "[minValue]-[maxValue]" of
	 * the range including the given altitude or return the default range "0-INF".
	 * 
	 * @param altitude
	 *            the geographical altitude
	 * @return a string representing the range
	 */
	public String getAltitudeRange(Integer altitude) {
		String a = altitude.toString();
		
//		for(AltitudeRange r : ranges) {
//			if(r.includes(a) == true);
//			return r.toString();
//		}
//		return "0-INF";
		
//		oppure usando gli stream
		List<AltitudeRange> validRanges = ranges.stream().filter(x -> x.getMinAltitude().compareTo(a)<=0 &&
				x.getMaxAltitude().compareTo(a)>=0).collect(Collectors.toList());
		if(validRanges.size() == 0)
			return "0-INF";
		return validRanges.get(0).toString();
	}

	/**
	 * Create a new municipality if it is not already available or find it.
	 * Duplicates must be detected by comparing the municipality names.
	 * 
	 * @param name
	 *            the municipality name
	 * @param province
	 *            the municipality province
	 * @param altitude
	 *            the municipality altitude
	 * @return the municipality
	 */
	public Municipality createOrGetMunicipality(String name, String province, Integer altitude) {
//		if(municipalities.containsKey(name))
//			return municipalities.get(name);
//		Municipality m = new Municipality(name, province, altitude);
//		municipalities.put(name, m);
//		return m;
		
		// usando gli stream
		Optional<Municipality> mun = municipalities.values().stream().filter(x -> x.getName().equals(name)).findFirst();
		return mun.orElseGet(()-> {
			Municipality m = new Municipality(name, province, altitude);
			municipalities.put(name, m);
			return m;
		});
		// findFirst() restituisce primo elemento, se non c'è restituisce Optional vuoto 
		// se il comune esiste già –> Optional pieno
		// altrimenti eseguo supplier contenuto
		// Optional.orElseGet({supplier}); –> definisco una lambda expression
	}

	/**
	 * Return all the municipalities available.
	 * 
	 * @return a collection of municipalities
	 */
	public Collection<Municipality> getMunicipalities() {
		Collection<Municipality> res = municipalities.values();
		return res;
	}

	/**
	 * Create a new mountain hut if it is not already available or find it.
	 * Duplicates must be detected by comparing the mountain hut names.
	 *
	 * @param name
	 *            the mountain hut name
	 * @param category
	 *            the mountain hut category
	 * @param bedsNumber
	 *            the number of beds in the mountain hut
	 * @param municipality
	 *            the municipality in which the mountain hut is located
	 * @return the mountain hut
	 */
	public MountainHut createOrGetMountainHut(String name, String category, Integer bedsNumber,
			Municipality municipality) {
//		if(mountainHuts.containsKey(name))
//			return mountainHuts.get(name);
//		
//		MountainHut m = new MountainHut(name, category, bedsNumber, municipality);
//		mountainHuts.put(name, m);
//		return m;
		
		// con gli stream
		return mountainHuts.values().stream().filter(x -> x.getName().equals(name)).findFirst().orElseGet(()-> {
			MountainHut m = new MountainHut(name, null, category, bedsNumber, municipality);
			mountainHuts.put(name, m);
			return m;
		});
	}

	/**
	 * Create a new mountain hut if it is not already available or find it.
	 * Duplicates must be detected by comparing the mountain hut names.
	 * 
	 * @param name
	 *            the mountain hut name
	 * @param altitude
	 *            the mountain hut altitude
	 * @param category
	 *            the mountain hut category
	 * @param bedsNumber
	 *            the number of beds in the mountain hut
	 * @param municipality
	 *            the municipality in which the mountain hut is located
	 * @return a mountain hut
	 */
	public MountainHut createOrGetMountainHut(String name, Integer altitude, String category, Integer bedsNumber,
			Municipality municipality) {
//		if(mountainHuts.containsKey(name))
//			return mountainHuts.get(name);
//		
//		MountainHut m = new MountainHut(name, altitude, category, bedsNumber, municipality);
//		mountainHuts.put(name, m);
//		return m;
		
		// con gli stream
		return mountainHuts.values().stream().filter(x -> x.getName().equals(name)).findFirst().orElseGet(()-> {
			MountainHut m = new MountainHut(name, altitude, category, bedsNumber, municipality);
			mountainHuts.put(name, m);
			return m;
		});
	}

	/**
	 * Return all the mountain huts available.
	 * 
	 * @return a collection of mountain huts
	 */
	public Collection<MountainHut> getMountainHuts() {
		Collection<MountainHut> res = mountainHuts.values();
		return res;
	}

	/**
	 * Factory methods that creates a new region by loadomg its data from a file.
	 * 
	 * The file must be a CSV file and it must contain the following fields:
	 * <ul>
	 * <li>{@code "Province"},
	 * <li>{@code "Municipality"},
	 * <li>{@code "MunicipalityAltitude"},
	 * <li>{@code "Name"},
	 * <li>{@code "Altitude"},
	 * <li>{@code "Category"},
	 * <li>{@code "BedsNumber"}
	 * </ul>
	 * 
	 * The fields are separated by a semicolon (';'). The field {@code "Altitude"}
	 * may be empty.
	 * 
	 * @param name
	 *            the name of the region
	 * @param file
	 *            the path of the file
	 * @throws FileNotFoundException 
	 */
	public static Region fromFile(String name, String file) {
	// Region.formFile() svolge il ruolo di un costruttore e crea un nuovo oggetto Region
	// infatti è un metodo statico che chiamo all'interno della classe stessa
		Region region = new Region(name);
		List<String> lines = readData(file);
		
		String[] headers = lines.remove(0).split(";"); // restituisce la linea 0 e la rimuove dalla lista
		
		Map<String, Integer> h2i = new HashMap<>();
		for(int i=0; i<headers.length; i++) {
			h2i.put(headers[i], i);
		}
		
		for(String l : lines) {
			String[] fields = l.split(";");
			
			Municipality m = region.createOrGetMunicipality( fields[(h2i.get("Municipality")).intValue()],
					fields[(h2i.get("Province")).intValue()], Integer.parseInt(fields[(h2i.get("MunicipalityAltitude")).intValue()]) );
			
			String altitude = fields[h2i.get("Altitude").intValue()];
			if(altitude.equals("")) {
				region.createOrGetMountainHut( fields[h2i.get("Name").intValue()], fields[h2i.get("Category").intValue()],
						Integer.parseInt(fields[h2i.get("BedsNumber").intValue()]), m );
			}
			else {
				region.createOrGetMountainHut( fields[h2i.get("Name").intValue()], Integer.parseInt(altitude), fields[h2i.get("Category").intValue()],
					Integer.parseInt(fields[h2i.get("BedsNumber").intValue()]), m );
			}
		}
		
		return region;
	}

	/**
	 * Internal class that can be used to read the lines of
	 * a text file into a list of strings.
	 * 
	 * When reading a CSV file remember that the first line
	 * contains the headers, while the real data is contained
	 * in the following lines.
	 * 
	 * @param file the file name
	 * @return a list containing the lines of the file
	 */
	@SuppressWarnings("unused")
	private static List<String> readData(String file) {
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			return in.lines().collect(toList());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Count the number of municipalities with at least a mountain hut per each
	 * province.
	 * 
	 * @return a map with the province as key and the number of municipalities as
	 *         value
	 */
	public Map<String, Long> countMunicipalitiesPerProvince() {
		
		return null;
	}

	/**
	 * Count the number of mountain huts per each municipality within each province.
	 * 
	 * @return a map with the province as key and, as value, a map with the
	 *         municipality as key and the number of mountain huts as value
	 */
	public Map<String, Map<String, Long>> countMountainHutsPerMunicipalityPerProvince() {
		return null;
	}

	/**
	 * Count the number of mountain huts per altitude range. If the altitude of the
	 * mountain hut is not available, use the altitude of its municipality.
	 * 
	 * @return a map with the altitude range as key and the number of mountain huts
	 *         as value
	 */
	public Map<String, Long> countMountainHutsPerAltitudeRange() {
		return null;
	}

	/**
	 * Compute the total number of beds available in the mountain huts per each
	 * province.
	 * 
	 * @return a map with the province as key and the total number of beds as value
	 */
	public Map<String, Integer> totalBedsNumberPerProvince() {
		return null;
	}

	/**
	 * Compute the maximum number of beds available in a single mountain hut per
	 * altitude range. If the altitude of the mountain hut is not available, use the
	 * altitude of its municipality.
	 * 
	 * @return a map with the altitude range as key and the maximum number of beds
	 *         as value
	 */
	public Map<String, Optional<Integer>> maximumBedsNumberPerAltitudeRange() {
		return null;
	}

	/**
	 * Compute the municipality names per number of mountain huts in a municipality.
	 * The lists of municipality names must be in alphabetical order.
	 * 
	 * @return a map with the number of mountain huts in a municipality as key and a
	 *         list of municipality names as value
	 */
	public Map<Long, List<String>> municipalityNamesPerCountOfMountainHuts() {
		return null;
	}

}
