package diet;

import java.util.LinkedList;

/**
 * Represent a take-away system user
 *  
 */
public class User implements Comparable<User>{
		
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public User(String first_name, String last_name, String email, String phone_number) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.phoneNumber = phone_number;
	}
	
	/**
	 * get user's last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * get user's first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * get user's email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * get user's phone number
	 * @return  phone number
	 */
	public String getPhone() {
		return phoneNumber;
	}
	
	/**
	 * change user's email
	 * @param email new email
	 */
	public void SetEmail(String email) {
		this.email = email;
	}
	
	/**
	 * change user's phone number
	 * @param phone new phone number
	 */
	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	@Override
	public int compareTo(User u) {
		int last = this.lastName.compareTo(u.getLastName());
		if (last == 0) {
			return this.firstName.compareTo(u.getFirstName());
		} 
		return last;

	}
	
}
