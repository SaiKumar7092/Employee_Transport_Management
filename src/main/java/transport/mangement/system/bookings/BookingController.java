package transport.mangement.system.bookings;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import transport.mangement.system.exception.CustomException;

@RestController
public class BookingController {
	
	@Autowired
	public BookingService bookingService;
	
	@RequestMapping(method=RequestMethod.POST,value="/request")
	@GetMapping
	public Map generateRequestId(@RequestBody Booking booking) throws CustomException, JSONException{
		Map<String,String> value=new HashMap<String,String>();
		value.put("requestId", bookingService.validateBooking(booking));
		return value;
	}
	
	@RequestMapping("/request/{requestId}")
	public Booking getBooking(@PathVariable int requestId){
		return bookingService.getBooking(requestId);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/request/{requestId}/cancel")
	public String cancelBooking(@PathVariable int requestId) throws CustomException{
		return bookingService.cancelBooking(requestId);
	}
	
	
}
