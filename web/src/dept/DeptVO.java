package dept;

public class DeptVO {
	private Integer Department_id;
	private String Department_name;
	private Integer Manager_id;
	private Integer Location_id;
	
	public DeptVO() {
		
	}
	
	public DeptVO(Integer department_id) {
		super();
		Department_id = department_id;
	}
	
	public DeptVO(int department_id, String department_name) {
		super();
		Department_id = department_id;
		Department_name = department_name;
	}
	
	@Override
	public String toString() {
		return "DeptVO [Department_id=" + Department_id + ", Department_name=" + Department_name + ", Manager_id="
				+ Manager_id + ", Location_id=" + Location_id + "]";
	}

	public Integer getDepartment_id() {
		return Department_id;
	}
	public void setDepartment_id(Integer department_id) {
		Department_id = department_id;
	}
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	public Integer getManager_id() {
		return Manager_id;
	}
	public void setManager_id(Integer manager_id) {
		Manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return Location_id;
	}
	public void setLocation_id(Integer location_id) {
		Location_id = location_id;
	}

	
	
}
