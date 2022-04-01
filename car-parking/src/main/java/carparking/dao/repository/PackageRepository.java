package carparking.dao.repository;
import carparking.dao.entity.PackageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepository extends MongoRepository<PackageEntity,String> {
}
