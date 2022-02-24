package net.grafana.brokkr.scheduler;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class WorkshopRequest {

	@Id
	public String id;
	
	public String workshopId;
	public String requester;
	public LocalDate workshopDate;
	public String campaignId;
	public String workshopType;
	public Object workshopConfig;
	public boolean demoSystemRequest;
	public String state;
	public boolean approved;
	

	public WorkshopRequest() {}

	public WorkshopRequest(String workshopId, String requester, LocalDate workshopDate, String campaignId,
			String workshopType, Object workshopConfig, boolean demoSystemRequest, String state, 
			boolean approved) {
		
		this.workshopId = workshopId;
		this.requester = requester;
		this.workshopDate = workshopDate;
		this.campaignId = campaignId;
		this.workshopType = workshopType;
		this.workshopConfig = workshopConfig;
		this.demoSystemRequest = demoSystemRequest;
		this.state = state;
		this.approved = approved;

	}

	@Override
	public String toString() {
		return String.format(
				"WorkshpoRequest[id=%s, workshopId='%s', requester='%s', date='%s', type='%s', campaign='%s']",
				id, workshopId, requester, workshopDate.toString(), workshopType, campaignId);
	}

}

