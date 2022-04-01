package carparking.B2B.dao;
import carparking.B2B.dao.entity.UserEntity;
import org.apache.catalina.User;

import java.util.concurrent.ExecutionException;

public interface B2BDao {
    UserEntity saveUser(UserEntity userEntity);
    UserEntity emailOrMobileAlreadyExist(String element);
    UserEntity addAdmin(UserEntity userEntity);
}
