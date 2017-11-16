package transport.mangement.system.cab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class for Cab.
 * 
 * @author SAIKUMAR
 *
 */
@Repository
public interface CabRepository extends CrudRepository<Cab, String> {

}
