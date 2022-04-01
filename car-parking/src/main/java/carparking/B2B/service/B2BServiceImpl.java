package carparking.B2B.service;
import carparking.B2B.dao.B2BDao;
import carparking.B2B.dao.entity.LicenseEntity;
import carparking.B2B.dao.entity.RoleEntity;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.RoleRepository;
import carparking.B2B.dao.repository.UserRepository;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;
import carparking.constant.ParkingConstant;
import carparking.convertor.Convertor;
import carparking.dto.CreateUserDto;
import carparking.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.UUID;

@Service
public class B2BServiceImpl implements B2BService{
   @Autowired B2BDao b2BDao;
   @Autowired RoleRepository repository;
   @Autowired UserRepository userRepository;

    @Override
    public ResponseConstant saveUser(UserDto userDto){
        ResponseConstant responseConstant= null;
           if((responseConstant=emailOrMobileAlreadyExist(userDto.getEmail(),userDto.getMobile()))!=null)
                return responseConstant;
        UserEntity userEntity = Convertor.dtoToEntityConversion(userDto, UserEntity.class);
        userEntity.setPassword(UUID.randomUUID().toString());
        UserDto userDto1 = Convertor.entityToDtoConversion(b2BDao.saveUser(userEntity),UserDto.class);
        b2BDao.saveUser(userEntity);
        responseConstant = new ResponseConstant();
        responseConstant.setMessage(ParkingConstant.DEFAULT_RESPONSE_MESSAGE);
        responseConstant.setHttpStatusCode(HttpStatus.CREATED.value());
        responseConstant.setStatus(Boolean.TRUE);
        return responseConstant;
    }

    public ResponseConstant emailOrMobileAlreadyExist(String ...element){
       ResponseConstant responseConstant = new ResponseConstant();
        if(b2BDao.emailOrMobileAlreadyExist(element[0])!=null){
           responseConstant.setStatus(Boolean.FALSE);
           responseConstant.setMessage("Given email already exist in the system , please enter new one");
           responseConstant.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
           return responseConstant;
       }
      else if(b2BDao.emailOrMobileAlreadyExist(element[1])!=null){
            responseConstant.setStatus(Boolean.FALSE);
            responseConstant.setMessage("Given mobile number already exist in the system , please enter new one");
            responseConstant.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return responseConstant;
        }
        return null;
    }

    @Override
    public ResponseConstant addUser(CreateUserDto createUserDto){
        ResponseConstant responseConstant=null;
        if((responseConstant=emailOrMobileAlreadyExist(createUserDto.getEmail(),createUserDto.getMobile()))!=null)
            return responseConstant;

        UserEntity userEntity = Convertor.dtoToEntityConversion(createUserDto,UserEntity.class);

        RoleEntity role= new RoleEntity();
        role.setSlugName("Admin");
        role.setName("Admin");
        userEntity.setRole(Arrays.asList(role));
        userEntity = b2BDao.addAdmin(userEntity);

        LicenseEntity licenseEntity = new LicenseEntity();
          licenseEntity.setLicenseKey(licenseKey());
          licenseEntity.setUser(userEntity);

        responseConstant = new ResponseConstant();
        responseConstant.setHttpStatusCode(HttpStatus.CREATED.value());
        responseConstant.setMessage("Successfull admin created ");
        responseConstant.setStatus(Boolean.TRUE);
        return responseConstant;
    }

    @Override
    public DashboardDto dashBoardData(){
        DashboardDto dto = new DashboardDto();
        Long totalUsers = userRepository.findAllUsers(ParkingConstant.ADMIN);
        dto.setTotalUsers(totalUsers);
        return dto;
    }

    private String licenseKey(){
        return UUID.randomUUID().toString();
    }
}
