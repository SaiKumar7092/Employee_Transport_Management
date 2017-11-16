package transport.mangement.system.cab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.mangement.system.exception.CustomException;

/**
 * Service class for Cab.
 * 
 * @author SAIKUMAR
 *
 */
@Service
public class CabService {
	/** Variable for cabRepository */
	@Autowired
	public CabRepository cabRepository;

	/**
	 * Method for getting all cabs.
	 * 
	 * @return
	 */
	public List<Cab> getAllCabs() {
		List<Cab> cabs = new ArrayList<>();
		cabRepository.findAll().forEach(cabs::add);
		return cabs;

	}

	/**
	 * Method for getting a cab.
	 * 
	 * @param id
	 * @return
	 */
	public Cab getCab(String id) {
		return cabRepository.findOne(id);
	}

	/**
	 * Method for adding cab.
	 * 
	 * @param cab
	 * @throws CustomException 
	 */
	public void addCab(Cab cab) throws CustomException {
		if(validateCabDetails(cab)){
			cabRepository.save(cab);
		}
		else {
			throwException("INVALID DETAILS");
		}
	}

	/**
	 * @param string
	 * @throws CustomException 
	 */
	private void throwException(String string) throws CustomException {
		CustomException customException=new CustomException();
		customException.setMessage(string);
		throw customException;
	}

	/**
	 * @param cab
	 * @return
	 */
	private boolean validateCabDetails(Cab cab) {
		if(cabRepository.findOne(cab.getCabId())!=null || (!validateVacancy(cab))) {
			return false;
		}
		else if(!(cab.getCabStatus().equalsIgnoreCase("AVAILABLE")
				|| cab.getCabStatus().equalsIgnoreCase("UNAVAILABLE"))) {
			return false;
		}
		return true;
	}

	/**
	 * @param cab
	 * @return
	 */
	private boolean validateVacancy(Cab cab) {
		if(cab.getVacancy()>4 ||cab.getVacancy()<0) {
			return false;
		}
		return true;
	}

	/**
	 * Method for updating cab.
	 * 
	 * @param cab
	 * @param id
	 * @throws CustomException 
	 */
	public void updateCab(Cab cab, String id) throws CustomException {
		if((cab.getCabStatus().equalsIgnoreCase("AVAILABLE")
				|| cab.getCabStatus().equalsIgnoreCase("UNAVAILABLE")) && validateCabDetails(cab)) {
		cabRepository.save(cab);
		}
		else {
			throwException("INVALID_CAB_STATUS");
		}

	}

	/**
	 * Method for deleting cab.
	 * 
	 * @param id
	 */
	public void deleteCab(String id) {
		cabRepository.delete(id);
	}

}
