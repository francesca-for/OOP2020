package groups;
//import java.util.*;

public class Bid {
	String supplierName;
	int price;
	String productName;
	int nVotes = 0;
	Bid (String supplierName, int price, String productName) {
		this.supplierName = supplierName; this.price = price;
		this.productName = productName;
	}
	int getPrice() {return price;}
	String getSupplierName() {return supplierName;}
	String getProductName() {return productName;}
	int getNVotes() {return nVotes;}

}
