package diet;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents an order in the take-away system
 */
public class Order {
	private User user;
	private Restaurant restaurant;
	private Time deliveryTime;
	private OrderStatus orderStatus = OrderStatus.ORDERED;
	private PaymentMethod paymentMethod = PaymentMethod.CASH;
	private Map<String, MenuQuantity> menuQty = new TreeMap<>(); 
	
//	public Order(User user, Restaurant restaurant, String deliveryTime) {
//		this.user = user;
//		this.restaurant = restaurant;
//		this.deliveryTime = restaurant.checkTime(deliveryTime);
//	}
	
	public Order(User user, Restaurant restaurant, int h, int m) {
		this.user = user;
		this.restaurant = restaurant;
		this.deliveryTime = restaurant.checkTime(new Time(h, m));
	}
	
	private class MenuQuantity{
		Menu menu;
		int quantity;
		
		MenuQuantity(Menu menu, int quantity){
			this.menu = menu;
			this.quantity = quantity;
		}
		
		public Menu getMenu() {
			return menu;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}
 
	/**
	 * Defines the possible order status
	 */
	public enum OrderStatus {
		ORDERED, READY, DELIVERED;
	}
	/**
	 * Defines the possible valid payment methods
	 */
	public enum PaymentMethod {
		PAID, CASH, CARD;
	}
		
	/**
	 * Total order price
	 * @return order price
	 */
	public double Price() {
		return -1.0;
	}
	
	/**
	 * define payment method
	 * 
	 * @param method payment method
	 */
	public void setPaymentMethod(PaymentMethod method) {
		this.paymentMethod = method;
	}
	
	/**
	 * get payment method
	 * 
	 * @return payment method
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * change order status
	 * @param newStatus order status
	 */
	public void setStatus(OrderStatus newStatus) {
		this.orderStatus = newStatus;
	}
	
	/**
	 * get current order status
	 * @return order status
	 */
	public OrderStatus getStatus(){
		return orderStatus;
	}
	
	/**
	 * Add a new menu with the relative order to the order.
	 * The menu must be defined in the {@link Food} object
	 * associated the restaurant that created the order.
	 * 
	 * @param menu     name of the menu
	 * @param quantity quantity of the menu
	 * @return this order to enable method chaining
	 */
	public Order addMenus(String menu, int quantity) {
		if(menuQty.get(menu)!=null)
			menuQty.get(menu).setQuantity(quantity);
		else {
			MenuQuantity mq = new MenuQuantity(restaurant.getMenu(menu), quantity);
			menuQty.put(menu, mq);
		}
		return this;
	}
	
	/**
	 * Converts to a string as:
	 * <pre>
	 * RESTAURANT_NAME, USER_FIRST_NAME USER_LAST_NAME : DELIVERY(HH:MM):
	 * 	MENU_NAME_1->MENU_QUANTITY_1
	 * 	...
	 * 	MENU_NAME_k->MENU_QUANTITY_k
	 * </pre>
	 */
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(restaurant.getName()).append(", ").append(user).append(" : (").append(deliveryTime).append(") :\n");
		for(MenuQuantity m : menuQty.values()) {
			res.append("\t" + m.getMenu().getName()).append("->").append(m.getQuantity() + "\n");
		}
		return res.toString();
	}
	
}
