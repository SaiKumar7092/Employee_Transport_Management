package transport.mangement.system.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.mangement.system.exception.CustomException;

/**
 * Service class for Employee.
 * 
 * @author SAIKUMAR
 *
 */
@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepository;

	/**
	 * Method to get all employee details.
	 * 
	 * @return List.
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;

	}

	/**
	 * Method to get a particular employee based on Id'
	 * 
	 * @param id
	 * @return Employee.
	 */
	public Employee getEmployee(String id) {
		return employeeRepository.findOne(id);
	}

	/**
	 * Method to add an employee.
	 * 
	 * @param employee
	 * @throws CustomException
	 */
	public void addEmployee(Employee employee) throws CustomException {
		if (validEmployeeDetails(employee)) {
			employeeRepository.save(employee);
		} else {
			throwException("DETAILS_EXIST");
		}
	}

	/**
	 * Method to throw a custom exception.
	 * 
	 * @param string
	 * @throws CustomException
	 */
	private void throwException(String string) throws CustomException {
		CustomException exception = new CustomException();
		exception.setMessage(string);
		throw exception;
	}

	/**
	 * Method to update employee.
	 * 
	 * @param employee
	 * @param id
	 */
	public void updateEmployee(Employee employee, String id) {
		employeeRepository.save(employee);

	}

	/**
	 * Method to delete an employee.
	 * 
	 * @param id
	 */
	public void deleteEmployee(String id) {
		employeeRepository.delete(id);
	}

	/**
	 * Method to validate employee details.
	 * 
	 * @param employee
	 * @return boolean.
	 */
	private boolean validEmployeeDetails(Employee employee) {
		if (employeeRepository.findOne(employee.getId()) != null) {
			return false;
		} else {
			return true;
		}
	}

}
