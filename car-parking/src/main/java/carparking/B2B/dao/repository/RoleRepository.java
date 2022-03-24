package carparking.B2B.dao.repository;
import carparking.B2B.dao.entity.RoleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RoleRepository extends MongoRepository<RoleEntity,String> {
    List<RoleEntity> findBySlugName(String slugName);
}
