package carparking.B2B.dao.repository;
import carparking.B2B.dao.entity.RoleEntity;
import carparking.B2B.dao.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    @Query(value = "{'role.name': ?1,'email': ?0}")
    UserEntity findByEmailAndRole(String email, String role);

    @Query(value="{$or:[{'email': ?0},{'mobile': ?0}]}")
    UserEntity findByEmailOrMobile(String element);

    @Query(value="{$and: ["
            +"{$or:[{'email': ?0},{'mobile': ?0}]}"
            +",{'password': ?1}"
            + "]}")
    UserEntity findByEmailOrMobileAndPassword(String email,String password);

    @Query(value="{" +
            "{'_id' : {'_id' : ?1}}" +
            "{$set : {'firstName':?0}}" +
            "}")
    UserEntity findById(String firstName,String id);

    @Query("{'role.name':?0}")
    UserEntity findByRole(String role);

    @Query(value = "{'role.name' : ?0}",count = true)
    Long findAllUsers(String role);

    @Query("{$or : [{'email': ?0},{'mobile' : ?0}]}")
    UserEntity findByEmail(String email);
}
