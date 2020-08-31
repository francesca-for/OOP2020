package groups;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GroupHandling {
	private Map<String, Product> products = new HashMap<>();
	private Map<String, Group> groups = new HashMap<>();
	private Map<String, Supplier> suppliers = new HashMap<>();
	List<Customer> customers = new LinkedList<>();
	
//R1	
	public void addProduct (String productTypeName, String... supplierNames) 
			throws GroupHandlingException {
		if(!products.containsKey(productTypeName)) throw new GroupHandlingException();
	
		for(String s : supplierNames) {
			if(s==null)
				break;
			Supplier supp = new Supplier(s);
			suppliers.put(s, supp);
		}
		Product p = new Product(productTypeName, suppliers.values().stream().collect(Collectors.toList()));
		products.put(productTypeName, p);
	}
	
	public List<String> getProductTypes (String supplierName) {
		Comparator<Product> cmp = Comparator.comparing(Product::getProductTypeName);
		
		return products.values().stream().filter(x -> x.getSuppliers().contains(suppliers.get(supplierName))).sorted(cmp).map(x -> x.getProductTypeName()).collect(Collectors.toList());
		
		// senza stream esterno
//		List<Product> res = new LinkedList<>();
//		for(Product p : products.values()) {
//			if(p.getSuppliers().stream().filter(x -> x.getName().equals(supplierName)).collect(Collectors.toList()).get(0)!=null)
//				res.add(p);
//		}
//		return res.stream().sorted(cmp).map(x -> x.getProductTypeName()).collect(Collectors.toList());
	}
	
//R2	
	public void addGroup (String name, String productName, String... customerNames) 
			throws GroupHandlingException {
		if(!groups.containsKey(name) || !products.containsKey(productName)) throw new GroupHandlingException();
		
		for(String c : customerNames) {
			if(c==null)
				break;
			Customer cus = new Customer(c);
			customers.add(cus);
		}
		Group g = new Group(name, productName, customers);
		customers.forEach(x -> x.addGroup(g));
		groups.put(name, g);
	}
	
	public List<String> getGroups (String customerName) {
		Comparator<Group> cmp = Comparator.comparing(Group::getName);
		return groups.values().stream().filter(x -> x.getCustomerNames().contains(customerName)).sorted(cmp).map(x -> x.getName()).collect(Collectors.toList());
	}

//R3
	public void setSuppliers (String groupName, String... supplierNames)
			throws GroupHandlingException {
		Product p = products.get(groups.get(groupName).getProductName());
		
		List<Supplier> groupSupp = new LinkedList<>();
		for(String s : supplierNames) {
			if(p.getSuppliers().stream().filter(x -> x.getName().equals(s)).collect(Collectors.toList()).get(0)!=null)
				groupSupp.add(suppliers.get(s));
			throw new GroupHandlingException();
		}
		suppliers.values().forEach(x -> x.addGroup(groups.get(groupName)));
		groups.get(groupName).setGroupSuppliers(groupSupp);
	}
	
	public void addBid (String groupName, String supplierName, int price)
			throws GroupHandlingException {
		if(!groups.get(groupName).getGroupSuppliers().contains(suppliers.get(supplierName))) throw new GroupHandlingException();
		Bid newBid = new Bid(suppliers.get(supplierName), price);
		groups.get(groupName).createNewBid(newBid);
		suppliers.get(supplierName).addBid(newBid);
	}
	
	public String getBids (String groupName) {
		Comparator<Bid> cmp = Comparator.comparing(Bid::getPrice).thenComparing((Bid b1, Bid b2) -> {
				return b1.getSupplier().getName().compareTo(b2.getSupplier().getName()); });
		
		StringBuffer res = new StringBuffer();
		groups.get(groupName).getBids().stream().sorted(cmp).forEachOrdered(x -> res.append(x.toString()).append(","));
        return res.toString();
	}
	
//R4	
	public void vote (String groupName, String customerName, String supplierName)
			throws GroupHandlingException {
		Bid b = groups.get(groupName).getBids().stream().filter(x-> x.getSupplier().getName().equals(supplierName)).collect(Collectors.toList()).get(0);
		
		if( (groups.get(groupName).getCustomerNames().stream().filter(x -> x.equals(customerName)).collect(Collectors.toList()).get(0) == null ) ||	(b == null) )
			throw new GroupHandlingException();
		b.addVote();
	}
	
	public String  getVotes (String groupName) {
		Comparator<Bid> cmp = ( (Bid b1, Bid b2) -> {return b1.getSupplier().getName().compareTo(b2.getSupplier().getName());} );
		StringBuffer res = new StringBuffer();
		
		List<Bid> sortedBids = groups.get(groupName).getBids().stream().filter(x -> x.getVotes()!=0).sorted(cmp).collect(Collectors.toList());
		
		for(Bid b : sortedBids)	{
			if(b != sortedBids.get(sortedBids.size()-1))
				res.append(b.getSupplier().getName()).append(":").append(b.getVotes()).append(",");
			else res.append(b.getSupplier().getName()).append(":").append(b.getVotes());
		}
        return res.toString();
	}
	
	public String getWinningBid (String groupName) {
		Bid winningBid = groups.get(groupName).getBids().stream().max(Comparator.comparing(Bid::getVotes).thenComparing(Bid::getPrice).reversed()).orElse(null);
        return winningBid.getSupplier().getName() + ":" + winningBid.getVotes();
	}
	
//R5
	public SortedMap<String, Integer> maxPricePerProductType() { //serve toMap
		return null;\\\\\\\\\
	}
	
	public SortedMap<Integer, List<String>> suppliersPerNumberOfBids() {
		return suppliers.values().stream().filter(x -> x.getBids().size() > 0).collect(Collectors.groupingBy(x -> x.getBids().size(),  () -> new TreeMap<Integer, List<String>>(Collection.reverseOrder()), Collectors.mapping(Supplier::getName, Collectors.toList())));
		// TODO da rivedere
	}
	
	public SortedMap<String, Long> numberOfCustomersPerProductType() {
        return null;
	}
	
}
