package groups;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.security.acl.Group;


public class GroupHandling {
	private Map<String, Product> products = new HashMap<>();
	private Map<String, Supplier> suppliers = new HashMap<>();
	private Map<String, AGroup> groups = new HashMap<>();
	private Map<String, Customer> customers = new HashMap<>();
	private List<Bid> bids = new LinkedList<>();
	
//R1	
	public void addProduct (String productTypeName, String... supplierNames) 
			throws GroupHandlingException {
		if(products.values().stream().filter(x -> x.getName().equals(productTypeName)).findFirst().orElse(null)!=null)
			throw new GroupHandlingException();
		
		Product p = new Product(productTypeName);
		products.put(productTypeName, p);
		for(String s : supplierNames) {
			if(s==null)
				break;
			Supplier supp = new Supplier(s);
			p.addSupplier(supp);
			supp.addProduct(p);
			suppliers.put(s, supp);
		}
	}
	
	public List<String> getProductTypes (String supplierName) {
		List<String> res = products.values().stream().filter(x -> x.getSuppliers().stream().filter(s -> s.compareTo(supplierName)==0)
							.findFirst().orElse(null)!=null).map(x -> x.getName()).sorted().collect(toList());
		return res;
	}
	
//R2	
	public void addGroup (String name, String productName, String... customerNames) 
			throws GroupHandlingException {
		if(!products.containsKey(productName) || 
				groups.values().stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null)!=null)
			throw new GroupHandlingException();
		
		AGroup g = new AGroup(name, products.get(productName));
		
		for(String s : customerNames) {
			Customer c = new Customer(s);
			customers.put(s, c);
			g.addCustomer(c);
			c.addGroup(g);	
		} 
	}
	
	public List<String> getGroups (String customerName) {
        return customers.get(customerName).getGroups().stream().map(x-> x.getName()).sorted().collect(Collectors.toList());
	}

//R3
	public void setSuppliers (String groupName, String... supplierNames)
			throws GroupHandlingException {
		for(String s : supplierNames) {
			if(suppliers.get(s).getProducts().stream().filter(x-> x.getName().equals
					(groups.get(groupName).getProduct().getName())).findFirst().orElse(null)==null ||
					!suppliers.containsKey(s)) {
				throw new GroupHandlingException();
			}
		}
		for(String s : supplierNames) {
			groups.get(groupName).addSupplier(suppliers.get(s));
		}
	}
	
	public void addBid (String groupName, String supplierName, int price)
			throws GroupHandlingException {
		if(groups.get(groupName).getSuppliers().stream().filter(x -> x.getName().equals(supplierName)).findFirst().orElse(null)==null)
			throw new GroupHandlingException();
		Bid b = new Bid(groupName, supplierName, price);
		bids.add(b);
	}
	
	public String getBids (String groupName) {
        return bids.stream().sorted(Comparator.comparing(Bid::getPrice).thenComparing((Bid b1, Bid b2) ->
         							{return b1.getSupplierName().compareTo(b2.getSupplierName());} ))
         		.map(x -> x.getSupplierName()+":"+x.getPrice()).collect(Collectors.joining(","));
	}
	
	
//R4
	public void vote (String groupName, String customerName, String supplierName)
			throws GroupHandlingException {
		//TODO r3 completata, mancano ultimi due requisiti
	}
	
	public String  getVotes (String groupName) {
        return null;
	}
	
	public String getWinningBid (String groupName) {
        return null;
	}
	
//R5
	public SortedMap<String, Integer> maxPricePerProductType() { //serve toMap
        return null;
	}
	
	public SortedMap<Integer, List<String>> suppliersPerNumberOfBids() {
        return null;
	}
	
	public SortedMap<String, Long> numberOfCustomersPerProductType() {
        return null;
	}
	
}
