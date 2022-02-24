package net.grafana.brokkr.scheduler;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkshopRequestRepository extends MongoRepository<WorkshopRequest, String> {

	public WorkshopRequest findByWorkshopId(String workshopId);
	public List<WorkshopRequest> findByRequester(String requester);
	public List<WorkshopRequest> findByWorkshopDate(LocalDate workshopDate);
	public WorkshopRequest findByCampaignId(String campaignId);
	public List<WorkshopRequest> findByWorkshopType(String workshopType);

}
