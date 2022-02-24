package net.grafana.brokkr.scheduler;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfrastructureRepository extends MongoRepository<UserInfrastructure, String> {

	public WorkshopRequest findByInfraId(String infraId);
	public List<UserInfrastructure> findByEmail(String email);
	public List<UserInfrastructure> findByWorkshopId(String workshopId);
	public List<UserInfrastructure> findByDateCreated(LocalDate dateCreated);
	public List<UserInfrastructure> findByWorkshopType(String workshopType);

}
