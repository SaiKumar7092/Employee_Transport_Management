package transport.mangement.system.cab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import transport.mangement.system.exception.CustomException;

/**
 * Controller class for Booking.
 * 
 * @author SAIKUMAR
 *
 */
@RestController
public class CabController {

	/** Variable for cabService */
	@Autowired
	public CabService cabService;

	/**
	 * Method for getting all cabs.
	 * 
	 * @return
	 */
	@RequestMapping("/cabs")
	public List<Cab> getAllCabs() {
		return cabService.getAllCabs();
	}

	/**
	 * Method for getting a cab.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/cab/{id}")
	public Cab getCab(@PathVariable String id) {
		return cabService.getCab(id);
	}

	/**
	 * Method for adding cab.
	 * 
	 * @param cab
	 * @throws CustomException 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/cab")
	public void addCab(@RequestBody Cab cab) throws CustomException {
		cabService.addCab(cab);
	}

	/**
	 * Method for updating cab.
	 * 
	 * @param cab
	 * @param cabId
	 * @throws CustomException 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/cab/{cabId}")
	public void updateCab(@RequestBody Cab cab, @PathVariable String cabId) throws CustomException {
		cabService.updateCab(cab, cabId);
	}

	/**
	 * Method for updating cab.
	 * 
	 * @param cab
	 * @param id
	 * @throws CustomException 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/cab/{id}/available")
	public void updateCabAvailable(@RequestBody Cab cab, @PathVariable String id) throws CustomException {
		cab.setCabStatus("AVAILABLE");
		cabService.updateCab(cab, id);
	}

	/**
	 * Method for updating cab.
	 * 
	 * @param cab
	 * @param id
	 * @throws CustomException 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/cab/{id}/unavailable")
	public void updateCabUnavailable(@RequestBody Cab cab, @PathVariable String id) throws CustomException {
		cab.setCabStatus("UNAVAILABLE");
		cabService.updateCab(cab, id);
	}

	/**
	 * Method for deleting cab.
	 * 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/cab/{id}")
	public void deleteCab(@PathVariable String id) {
		cabService.deleteCab(id);
	}
}
