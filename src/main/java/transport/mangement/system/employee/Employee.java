package transport.mangement.system.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import transport.mangement.system.cab.Cab;

/**
 * @author SAIKUMAR Entity class to represent the employee details.
 */

@Entity
public class Employee {

	/** Variable for id */
	@javax.persistence.Id
	private String id;
	/** Variable for fullName */
	private String fullName;
	/** Variable for designation */
	private String designation;
	/** Variable for joiningDate */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	private Date joiningDate;
	/** Variable for email */
	private String email;
	/** Variable for phone */
	private String phone;
	/** Variable for address */
	private String address;
	/** Variable for employee */
	@OneToOne(mappedBy = "emp")
	private Cab cab;
	
	/**
	 * Empty Constructor for initializing objects.
	 */
	public Employee() {

	}
	/**
	 * Empty Constructor for initializing objects.
	 */
	public Employee(String id) {
		super();
		this.id=id;

	}

	/**
	 * Parameterized Constructor for initializing objects.
	 */
	public Employee(String id, String fullName, String designation, Date joiningDate, String email, String address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.designation = designation;
		this.joiningDate = joiningDate;
		this.email = email;
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate
	 *            the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the cab
	 */
	public Cab getCab() {
		return cab;
	}

	/**
	 * @param cab the cab to set
	 */
	public void setCab(Cab cab) {
		this.cab = cab;
	}
}
