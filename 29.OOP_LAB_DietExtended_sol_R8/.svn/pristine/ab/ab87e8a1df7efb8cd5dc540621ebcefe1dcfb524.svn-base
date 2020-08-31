package diet;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import diet.Order.OrderStatus;
import diet.Order.PaymentMethod;

/**
 * Represents an order in the take-away system
 */
public class Order {
 
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
			
	private Time delivery_time;
	private OrderStatus orderStatus;
	private PaymentMethod paymentType;
	private SortedMap<Menu, Integer> menuOrder;
	private Restaurant restaurant;
	private User user;
	
	public Order(Restaurant restaurant, User user, int h, int m) {
		this.restaurant = restaurant;
		this.user = user;
		this.orderStatus = OrderStatus.ORDERED;
		this.paymentType = PaymentMethod.CASH;
		this.delivery_time = restaurant.checkTime(new Time(h,m));
		this.menuOrder = new TreeMap<Menu, Integer>(Comparator.comparing(Menu::getName));
	}
	
	/**
	 * define payment method
	 * 
	 * @param method payment method
	 */
	public void setPaymentMethod(PaymentMethod pm) {
		this.paymentType = pm;
	}
	
	/**
	 * get payment method
	 * 
	 * @return payment method
	 */
	public PaymentMethod getPaymentMethod() {
		return this.paymentType;
	}
	
	/**
	 * change order status
	 * @param newStatus order status
	 */
	public void setStatus(OrderStatus os) {
		this.orderStatus = os;
	}
	
	/**
	 * get current order status
	 * @return order status
	 */
	public OrderStatus getStatus()
	{
		return this.orderStatus;
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
		Menu m = restaurant.getMenu(menu);
		if (!menuOrder.containsKey(m)) {
			menuOrder.put(m, quantity);
		} else {
			menuOrder.replace(m, quantity);
		}
		return this;
	}
	
	public Restaurant getRestaurant() {
		return this.restaurant;
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
		StringBuffer b = new StringBuffer();
		b.append(restaurant.getName()).append(", ").append(user).append(" : (");
		b.append(delivery_time).append("):\n");
		for (Map.Entry<Menu, Integer> m : menuOrder.entrySet()) {
			b.append("\t").append(m.getKey().getName()).append("->").append(m.getValue().toString()).append("\n");
		}
		return b.toString();
	}
	
	User getUser() {
		return user;
	}
	
	Time getDeliveryTime() {
		return this.delivery_time;
	}
}
