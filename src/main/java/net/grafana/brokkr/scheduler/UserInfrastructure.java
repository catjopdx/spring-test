package net.grafana.brokkr.scheduler;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class UserInfrastructure {

	@Id
	public String id;
	
	public String infraId;
	public String email;
	public String workshopId;
	public LocalDate dateCreated;
	public String workshopType;
	public Object infraConfig;
	public boolean demoSystemRequest;
	public String state;
	

	public UserInfrastructure() {}

	public UserInfrastructure(String infraId, String email, String workshopId, LocalDate dateCreated, 
			String workshopType, Object infraConfig, boolean demoSystemRequest, String state) {
		
		this.infraId = infraId;
		this.workshopId = workshopId;
		this.email = email;
		this.dateCreated = dateCreated;
		this.workshopType = workshopType;
		this.infraConfig = infraConfig;
		this.demoSystemRequest = demoSystemRequest;
		this.state = state;

	}

	@Override
	public String toString() {
		return String.format(
				"UserInfrastructure[id=%s, infraId='%s', workshopId='%s', email='%s', dateCreated='%s', type='%s']",
				id, infraId, workshopId, email, dateCreated.toString(), workshopType);
	}

}

