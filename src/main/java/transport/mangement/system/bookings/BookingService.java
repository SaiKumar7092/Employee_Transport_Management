package transport.mangement.system.bookings;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.mangement.system.cab.Cab;
import transport.mangement.system.cab.CabRepository;
import transport.mangement.system.exception.CustomException;
@Service
public class BookingService {
	@Autowired
	public BookingRepository bookingRepository;
	
	@Autowired
	public CabRepository cabRepository;
	
	
	List<String> soureLocations=Arrays.asList("MVP Colony","RK Beach","LB Colony", "HB Colony", "Complex","AU","Daba Gardens");


	public String generateRequestId(Booking booking) throws CustomException {
		generateCabId(booking);
		bookingRepository.save(booking);
		booking.setBookingId("B"+String.valueOf(booking.getRequestId()));
		bookingRepository.save(booking);
		return String.valueOf(booking.getRequestId());
	}


	/**
	 * @param booking
	 * @throws CustomException 
	 */
	private void generateCabId(Booking booking) throws CustomException {
		List<Cab> cabs=(List<Cab>) cabRepository.findAll();
		for(Cab cab:cabs) {
			if(cab.getCabStatus()!="UNAVAILABLE" && cab.getVacancy()>0) {
				booking.setCabId(cab.getCabId());
				return;
			}
		}
		if(booking.getCabId()==null) {
			CustomException e=new CustomException();
			e.setMessage("CAB_NOT_AVAILABLE");
			throw e;
		}
	}


	public String validateBooking(Booking booking) throws CustomException {
		if(!validateDayAndHours(booking)) {
			generateException(booking,"INVALID_TRIP_TIME");
			return "1";
		}
		else if(validateInvalidDateTime(booking)) {
			generateException(booking,"REQUEST_NOT_POSSIBLE");
			return "2";
		}
		else if(!validSourceLocation(booking)) {
			generateException(booking,"SOURCE_INVALID");
			return "3";			
		}
		else {
			booking.setRequestStatus("GENERATED");
			booking.setComments("SUCCESSFUL");
			booking.setBookingId(String.valueOf(booking.getRequestId()));
			return generateRequestId(booking);
		}
	}
	
	private void generateException(Booking booking, String id) throws CustomException {
		booking.setRequestStatus("FAILED");
		booking.setComments(id);
		saveBooking(booking);
		CustomException e=new CustomException();
		e.setMessage(id);
		throw e;
	
	}


	private void saveBooking(Booking booking) {
		bookingRepository.save(booking);
	}


	private boolean validSourceLocation(Booking booking) {
		for(int i=0;i<soureLocations.size();i++) {
			if(booking.getSourceLocation().equals(soureLocations.get(i))) {
				return true;
			}
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	private boolean validateDayAndHours(Booking booking) {
		 Calendar cal = Calendar.getInstance();
		  cal.setTime(booking.getDateTimeOfJourney());
		  int day=cal.get(Calendar.DAY_OF_WEEK);
		  if(booking.getDateTimeOfJourney().getHours()>=22 || booking.getDateTimeOfJourney().getHours()<=1) {
		  if((day==Calendar.SATURDAY)&&(booking.getDateTimeOfJourney().getHours()<=1)) {
			  return true;
		  }
		  else if(day==Calendar.SATURDAY || day==Calendar.SUNDAY) {
			return false;
		}
		  else {
			  return true;
		  }
		  }
		  else {
		return false;
		  }
	}


	@SuppressWarnings("deprecation")
	private boolean validateInvalidDateTime(Booking booking) {
		long d1=booking.getDateTimeOfJourney().getTime()/(60 * 60 * 1000);
		long d2=Calendar.getInstance().getTimeInMillis()/(60 * 60 * 1000);
		if(d1<d2 || ((d1-d2)>48 || (d1-d2)<12)) {
			return true;
		}
		
		return false;
	}


	public Booking getBooking(int requestId) {
		Booking booking= bookingRepository.findOne(requestId);
		if(booking.getBookingId()!=null) {
			return booking;
		}
		else {
			return null;
		}
	}


	public String cancelBooking(int requestId) throws CustomException {
		Booking booking=bookingRepository.findOne(requestId);
		if(null==booking || booking.getBookingId()==null) {
			CustomException e=new CustomException();
			e.setMessage("REQUEST_NOT_AVAILABLE");
			throw e;			
		}
		else if(validateCancellationTime(booking)) {
			booking.setRequestStatus("CANCELLED");
			booking.setComments("CANCELLED");
			bookingRepository.save(booking);
			return "CANCELLATION_SUCCESSFUL";
			
		}
		else {
			CustomException e=new CustomException();
			e.setMessage("CANCELLATION_NOT_POSSIBLE");
			throw e;
		}
	}


	private boolean validateCancellationTime(Booking booking) {
		long d1=booking.getDateTimeOfJourney().getTime()/(60 * 60 * 1000);
		long d2=Calendar.getInstance().getTimeInMillis()/(60 * 60 * 1000);
		if(d1<d2 || (d1-d2)<3 ) {
			return false;
		}
		
		return true;
	}
}
