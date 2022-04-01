package carparking;
import carparking.B2B.dao.entity.RoleEntity;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.RoleRepository;
import carparking.B2B.dao.repository.UserRepository;
import carparking.constant.ParkingConstant;
import carparking.dao.entity.PackageEntity;
import carparking.dao.repository.PackageRepository;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarParkingApplication {
	@Autowired static UserRepository userRepository;
	@Autowired static RoleRepository roleRepository;
	@Autowired static MongoClient mongoClient;
	@Autowired static PackageRepository packageRepository;

	public CarParkingApplication(UserRepository repository,RoleRepository roleRepository, MongoClient mongoClient, PackageRepository packageRepository){
		this.userRepository=repository;
		this.roleRepository=roleRepository;
		this.packageRepository=packageRepository;
		this.mongoClient=mongoClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarParkingApplication.class, args);
		saveAdmin();
		saveRecord();
	}

	public static void saveAdmin(){
		UserEntity userEntity =userRepository.findByEmailAndRole(ParkingConstant.SUPER_ADMIN_EMAIL,ParkingConstant.SUPER_ADMIN);
		if(userEntity!=null){
			return;
		}
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		UserEntity admin= new UserEntity();
		admin.setEmail("ankitsrivastava7835@gmail.com");
		admin.setFirstName("Ankit");
		admin.setLastName("Srivastava");
		admin.setPassword(bCryptPasswordEncoder.encode("ankit@123"));
		admin.setMobile("9990545169");
		RoleEntity adminRole= new RoleEntity();
		adminRole.setSlugName("SUPER_ADMIN");
		adminRole.setName("SUPER_ADMIN");
		adminRole = roleRepository.save(adminRole);
		admin.setRole(Arrays.asList(adminRole));
		admin= userRepository.save(admin);
	}

	public static void saveRecord(){
		List<String>list = mongoClient.getDatabase("parking").listCollectionNames().into(new ArrayList<>());
		UserEntity createdBy = list.contains("user")? userRepository.findByRole(ParkingConstant.SUPER_ADMIN) : null;
		if(!list.contains("package")) {
			PackageEntity p1= new PackageEntity();
			p1.setPackageType(ParkingConstant.PACKAGE_TYPE_UNDER_TRIAL);
			p1.setCreatedBy(createdBy);
			p1.setUpdatedBy(createdBy);
			p1.setCreatedDate(LocalDateTime.now());
			p1.setUpdatedDate(LocalDateTime.now());
			p1.setDescription("Under Trial ");
			p1.setDuration(10);
			p1=packageRepository.save(p1);
			System.out.println(p1);
		}
	}
}
