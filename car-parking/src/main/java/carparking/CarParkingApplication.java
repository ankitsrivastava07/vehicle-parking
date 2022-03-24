package carparking;
import carparking.B2B.dao.entity.RoleEntity;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.RoleRepository;
import carparking.B2B.dao.repository.UserRepository;
import carparking.constant.ParkingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarParkingApplication {
	@Autowired static UserRepository userRepository;
	@Autowired static RoleRepository roleRepository;

	public CarParkingApplication(UserRepository repository,RoleRepository roleRepository){
		this.userRepository=repository;
		this.roleRepository=roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarParkingApplication.class, args);
		saveAdmin();
	}

	public static void saveAdmin(){
		List<RoleEntity> role=roleRepository.findBySlugName(ParkingConstant.SUPER_ADMIN);
		if(!role.isEmpty()){
			UserEntity userEntity = userRepository.findByEmailAndRole("ankitsrivastava7835@gmail.com",role.get(0));
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
}
