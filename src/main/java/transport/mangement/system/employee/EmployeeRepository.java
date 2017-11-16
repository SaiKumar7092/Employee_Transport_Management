package transport.mangement.system.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * @author SAIKUMAR
 * Repository interface for Employee.
 *
 */
@Repository 
public interface EmployeeRepository extends CrudRepository<Employee, String> { 
	

}
