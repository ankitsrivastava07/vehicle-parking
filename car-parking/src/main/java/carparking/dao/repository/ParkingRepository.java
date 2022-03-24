package carparking.dao.repository;
import carparking.dao.entity.ParkingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ParkingRepository extends MongoRepository<ParkingEntity,Long> {
    List<ParkingEntity> findByName(String name);
}
