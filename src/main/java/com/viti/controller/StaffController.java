package com.viti.controller;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.Staff;
import com.viti.service.StaffService;

@RestController
public class StaffController {
	private static final Logger LOG = LoggerFactory.getLogger(StaffController.class);

	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/staff")
	public List<Staff> getStaff() {
		LOG.debug("Entering to get staff.");
		List<Staff> staff = staffService.getStaff();
		LOG.debug("Staff retrieved successfully");
		return staff;
	}

	@RequestMapping(value = "/staff/{id}")
	public Staff getStaff(@PathVariable String id) {
		// Call service method to get one staff
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/staff")
	public void addStaff(@RequestBody Staff staff) {
		LOG.info("Entering creating to staff");
		staffService.createStaff(staff);
		LOG.info("Successfully created staff");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/staff/{id}")
	public void updateStaff(@RequestBody Staff staff, @PathVariable String id) {
		// Call service method to update staff.
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/staff/{id}")
	public void deleteStaff(@PathVariable String id) {
		// Call service method to delete staff.

	}

	/*
	 * private static final Logger LOGGER =
	 * LoggerFactory.getLogger(StaffController.class);
	 * 
	 * private List<Staff> staff = new ArrayList<>( Arrays.asList(new
	 * Staff("Dr.Vikas", "M", "Sharma", "Male", "16/04/1985",
	 * "Vikas@viti.com")));
	 * 
	 * @RequestMapping(value = "/staff") public List<Staff> getStudent() {
	 * LOGGER.debug("Student added successfully"); return staff; }
	 * 
	 * @RequestMapping(value = "/staff/{id}") public Staff
	 * getStaff(@PathVariable String id) {
	 * 
	 * return staff.stream().filter(t ->
	 * t.getFirstName().equals(id)).findFirst().get();
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value = "/staff") public
	 * void addStaff(@RequestBody Staff staffs) {
	 * 
	 * staff.add(staffs);
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, value = "/staff/{id}") public
	 * void updateStaff(@RequestBody Staff staffs, @PathVariable String id) {
	 * 
	 * for (int i = 0; i < staff.size(); i++) { Staff s1 = staff.get(i); if
	 * (s1.getFirstName().equals(id)) { staff.set(i, (Staff) staffs); } } }
	 * 
	 * @RequestMapping(method = RequestMethod.DELETE, value = "/staff/{id}")
	 * public void deleteStaff(@PathVariable String id) { staff.removeIf(t ->
	 * t.getFirstName().equals(id));
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value = "/staff") public List<Staff> getStaff() {
	 * 
	 * List<Staff> staff = new ArrayList<>(); Calendar cal =
	 * Calendar.getInstance(); cal.set(1976, 4, 1); SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd/MM/yyyy"); Staff s = new Staff("Dr.Vikas", "M",
	 * "Sharma", "Male", sdf.format(cal.getTime()), "vikas.sharma@viti.com");
	 * staff.add(s); LOGGER.debug("Staff added successfully"); return staff; }
	 */


	/*private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

	private List<Staff> staff = new ArrayList<>(
			Arrays.asList(new Staff("Dr.Vikas", "M", "Sharma", "Male", "16/04/1985", "Vikas@viti.com")));

	@RequestMapping(value = "/staff")
	public List<Staff> getStudent() {
		LOGGER.debug("Student added successfully");
		return staff;
	}

	@RequestMapping(value = "/staff/{id}")
	public Staff getStaff(@PathVariable String id) {

		return staff.stream().filter(t -> t.getFirstName().equals(id)).findFirst().get();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/staff")
	public void addStaff(@RequestBody Staff staffs) {

		staff.add(staffs);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/staff/{id}")
	public void updateStaff(@RequestBody Staff staffs, @PathVariable String id) {

		for (int i = 0; i < staff.size(); i++) {
			Staff s1 = staff.get(i);
			if (s1.getFirstName().equals(id)) {
				staff.set(i, (Staff) staffs);
			}
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/staff/{id}")
	public void deleteStaff(@PathVariable String id) {
		staff.removeIf(t -> t.getFirstName().equals(id));

	}

	
	 * @RequestMapping(value = "/staff") public List<Staff> getStaff() {
	 * 
	 * List<Staff> staff = new ArrayList<>(); Calendar cal =
	 * Calendar.getInstance(); cal.set(1976, 4, 1); SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd/MM/yyyy"); Staff s = new Staff("Dr.Vikas", "M",
	 * "Sharma", "Male", sdf.format(cal.getTime()), "vikas.sharma@viti.com");
	 * staff.add(s); LOGGER.debug("Staff added successfully"); return staff; }
	 
*/
}
