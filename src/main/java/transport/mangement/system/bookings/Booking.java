package transport.mangement.system.bookings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author SAIKUMAR
 * 
 *         Booking Entity class for storing the booking details.
 *
 */
@Entity
public class Booking {

	/** Variable for requestId */
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "requestId", updatable = false, nullable = false)
	private int requestId;
	/** Variable for requestStatus */
	private String requestStatus;
	/** Variable for comments */
	private String comments;
	/** Variable for bookingId */
	private String bookingId;
	/** Variable for sourceLocation */
	private String sourceLocation;
	/** Variable for dateTimeOfJourney */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm:ss", timezone = "IST")
	private Date dateTimeOfJourney;
	/** Variable for cabId */
	private String cabId;
	
	/**
	 * @return the requestId
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}

	/**
	 * @param requestStatus
	 *            the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 *            the bookingId to set
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the sourceLocation
	 */
	public String getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * @param sourceLocation
	 *            the sourceLocation to set
	 */
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	/**
	 * @return the dateTimeOfJourney
	 */
	public Date getDateTimeOfJourney() {
		return dateTimeOfJourney;
	}

	/**
	 * @param dateTimeOfJourney
	 *            the dateTimeOfJourney to set
	 */
	public void setDateTimeOfJourney(Date dateTimeOfJourney) {
		this.dateTimeOfJourney = dateTimeOfJourney;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/** Variable for employeeId */
	private String employeeId;

	/**
	 * Empty Constructor for initializing objects.
	 */
	public Booking() {

	}

	/**
	 * @return the cabId
	 */
	public String getCabId() {
		return cabId;
	}

	/**
	 * @param cabId the cabId to set
	 */
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

}