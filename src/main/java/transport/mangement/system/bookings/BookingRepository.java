package transport.mangement.system.bookings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	

}
