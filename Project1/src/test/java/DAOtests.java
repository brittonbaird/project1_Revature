import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.dao.RequestDAO;
import com.revature.project1.model.Employee;
import com.revature.project1.model.Request;

public class DAOtests {

	@Test
	public void testSaveRequest() {
		Request request = new Request(100, 3, "printer", "pending", 50.00);
		RequestDAO.instance().saveRequest(request);
		assertNotNull(RequestDAO.instance().getRequest(100));
		RequestDAO.instance().deleteRequest(request);
	}

	public void testDeleteRequest() {
		Request request = new Request(100, 3, "printer", "pending", 50.00);
		RequestDAO.instance().saveRequest(request);
		RequestDAO.instance().deleteRequest(request);
		assertNull(RequestDAO.instance().getRequest(100));
	}
	
	@Test
	public void testUpdateRequest() {
		Request request = new Request(3, 2, "fax", "pending", 25.00);
		RequestDAO.instance().updateRequest(request);
		assertEquals(request.getReason(), RequestDAO.instance().getRequest(3).getReason());
	}

	@Test
	public void testGetRequestsByEmployeeId() {
		assertNotNull(RequestDAO.instance().getRequest(1));
	}
	
	@Test
	public void testGetRequests() {
		assertNotNull(RequestDAO.instance().getRequests());
	}
	
	@Test
	public void testGetRequest() {
		assertNotNull(RequestDAO.instance().getRequest(1));
	}
	
	@Test
	public void testGetEmployee() {	
		assertEquals("britton", EmployeeDAO.instance().getEmployee("brittonb000@gmail.com").getFirstName());
	}
	
	@Test
	public void testGetEmployees() {
		assertNotNull(EmployeeDAO.instance().getEmployees());
	}
	
	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee(3, false, "jim", "john", "jim@google.com", "goodpassword"); 
		EmployeeDAO.instance().saveEmployee(employee);
		assertNotNull(EmployeeDAO.instance().getEmployee("jim@google.com"));
		EmployeeDAO.instance().deleteEmployee(employee);
	}
	
	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee(3, false, "jim", "john", "jim@google.com", "goodpassword"); 
		EmployeeDAO.instance().saveEmployee(employee);
		EmployeeDAO.instance().deleteEmployee(employee);
		assertNull(EmployeeDAO.instance().getEmployee("jim@google.com"));
	}
	
}
