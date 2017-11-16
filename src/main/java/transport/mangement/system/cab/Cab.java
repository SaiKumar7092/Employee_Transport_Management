package transport.mangement.system.cab;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import transport.mangement.system.employee.Employee;

/**
 * Entity class for Cab.
 * 
 * @author SAIKUMAR
 *
 */
@Entity
public class Cab {

	/** Variable for cabId */
	@javax.persistence.Id
	private String cabId;
	/** Variable for registrationNumber */
	private String registrationNumber;
	/** Variable for driverId */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId")
	private Employee emp;
	/** Variable for cabStatus */
	private String cabStatus;
	/** Variable for comments */
	private String comments;
	/** Variable for vacancy */
	private int vacancy;

	/**
	 * Empty Constructor for initializing objects.
	 */
	public Cab() {

	}

	/**
	 * @return the cabId
	 */
	public String getCabId() {
		return cabId;
	}

	/**
	 * @param cabId
	 *            the cabId to set
	 */
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the cabStatus
	 */
	public String getCabStatus() {
		return cabStatus;
	}

	/**
	 * @param cabStatus
	 *            the cabStatus to set
	 */
	public void setCabStatus(String cabStatus) {
		this.cabStatus = cabStatus;
	}

	/**
	 * @return the emacommentsil
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param emacommentsil
	 *            the emacommentsil to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the vacancy
	 */
	public int getVacancy() {
		return vacancy;
	}

	/**
	 * @param vacancy
	 *            the vacancy to set
	 */
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return emp;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}

}
