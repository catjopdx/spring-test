package net.grafana.brokkr.scheduler;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import org.json.simple.JSONObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SchedulerApplication {
	
	private WorkshopRequestRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		repository.deleteAll();
		JSONObject config =  new JSONObject();
		config.put("directives", new String[]{"baseInfra", "k8s", "grafanaCloudInstance"});
	    config.put("description", "i am a description");
	    JSONObject k8s = new JSONObject();
	    k8s.put("machineType", "e2-medium");
	    k8s.put("numNodes", 3);
	    k8s.put("diskSize", 100);
	    config.put("kubernetes",  k8s);

		repository.save(new WorkshopRequest("theworkshopid", "catherine.johnson@grafana.com",
				LocalDate.parse("2022-04-01 12:12:12.PST"), "sfdcid1", "observability1", config, 
				Boolean.TRUE, "requested", Boolean.FALSE));
		
		repository.save(new WorkshopRequest("theworkshopid2", "eamon.ryan@grafana.com",
				LocalDate.parse("2022-04-02 12:12:12.PST"), "sfdcid2", "observability1", config, 
				Boolean.TRUE, "requested", Boolean.FALSE));
		
		System.out.println("WorkshopRequests found with findAll()");
		System.out.println("-------------------------------------");
		for (WorkshopRequest request : repository.findAll())
		{
			System.out.println(request.toString());
		}
		
		System.out.println("WorkshopRequests found with findByWorkshopId");
		System.out.println("-------------------------------------");
		WorkshopRequest request = repository.findByWorkshopId("theworkshopid");
		System.out.println(request.toString());
		
		System.out.println("WorkshopRequests found with findByRequester)");
		System.out.println("-------------------------------------");
		for (WorkshopRequest request2 : repository.findByRequester("catherine.johnson@grafana.com"))
		{
			System.out.println(request2.toString());
		}
		
		System.out.println("WorkshopRequests found with findByDate)");
		System.out.println("-------------------------------------");
		for (WorkshopRequest request2 : repository.findByWorkshopDate(LocalDate.parse("2022-04-01")))
		{
			System.out.println(request2.toString());
		}
		
		System.out.println("WorkshopRequests found with findByCampaignId");
		System.out.println("-------------------------------------");
		request = repository.findByCampaignId("sfdcid2");
		System.out.println(request.toString());
		
		System.out.println("WorkshopRequests found with findByWorkshopType)");
		System.out.println("-------------------------------------");
		for (WorkshopRequest request2 : repository.findByWorkshopType("observability1"))
		{
			System.out.println(request2.toString());
		}
		
				
	}

}

