import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.dao.RequestDAO;
import com.revature.project1.model.Employee;
import com.revature.project1.model.Request;

public class DAOtests {

	@Test
	public void testSaveRequest() {
		Request request = new Request(2, "printer", "pending", 50.00);
		RequestDAO.instance().saveRequest(request);
		assertTrue(RequestDAO.instance().getRequests().contains(request));
		//need get request
	}
	
	@Test
	public void testUpdateRequest() {
		Request request = new Request(100, 2, "printer", "pending", 25.00);
		RequestDAO.instance().updateRequest(request);
		assertTrue(RequestDAO.instance().getRequests().contains(request));
		//need get request
	}

	@Test
	public void testGetRequests() {
		assertNotNull(RequestDAO.instance().getRequests());
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
		fail("not implemented");
		//need auto increment or delete
	}
}
