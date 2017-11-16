package transport.mangement.system.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import transport.mangement.system.exception.CustomException;

/**
 * Controller class for Employee.
 * 
 * @author SAIKUMAR
 *
 */
@RestController
public class EmployeeController {
	/** Variable for employeeService */
	@Autowired
	public EmployeeService employeeService;

	/**
	 * Method to get all employees
	 * 
	 * @return List<Employees>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/**
	 * Method to get a particular employee.
	 * 
	 * @param id
	 * @return Employee.
	 */
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	/**
	 * Method to add an employee.
	 * 
	 * @param employee
	 * @throws CustomException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public void addEmployee(@RequestBody Employee employee) throws CustomException {
		employeeService.addEmployee(employee);
	}

	/**
	 * Method to update an employee.
	 * 
	 * @param employee
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		employeeService.updateEmployee(employee, id);
	}

	/**
	 * Method to delete an employee.
	 * 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}
}
