package carparking.B2B.dao;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class B2BDaoImpl implements B2BDao{
    @Autowired UserRepository userRepository;
    @Override
    public UserEntity saveUser(UserEntity userEntity){
      return userRepository.save(userEntity);
    }

    @Override
    public UserEntity emailOrMobileAlreadyExist(String element){
      return userRepository.findByEmailOrMobile(element);
    }
}
