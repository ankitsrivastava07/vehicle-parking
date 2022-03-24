package carparking.B2B.dao;
import carparking.B2B.dao.entity.UserEntity;

import java.util.concurrent.ExecutionException;

public interface B2BDao {
    UserEntity saveUser(UserEntity userEntity);
    UserEntity emailOrMobileAlreadyExist(String element);
}
