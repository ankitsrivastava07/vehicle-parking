package carparking.B2B.service;
import carparking.B2B.dao.B2BDao;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;
import carparking.constant.ParkingConstant;
import carparking.convertor.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class B2BServiceImpl implements B2BService{
   @Autowired B2BDao b2BDao;

    @Override
    public ResponseConstant saveUser(UserDto userDto) throws ExecutionException, InterruptedException {
        ResponseConstant responseConstant= null;
           if((responseConstant=emailOrMobileAlreadyExist(userDto))!=null)
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
    public ResponseConstant emailOrMobileAlreadyExist(UserDto userDto){
       ResponseConstant responseConstant = new ResponseConstant();
        if(b2BDao.emailOrMobileAlreadyExist(userDto.getEmail())!=null){
           responseConstant.setStatus(Boolean.FALSE);
           responseConstant.setMessage("Given email already exist in the system , please enter new one");
           responseConstant.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
           return responseConstant;
       }
      else if(b2BDao.emailOrMobileAlreadyExist(userDto.getMobile())!=null){
            responseConstant.setStatus(Boolean.FALSE);
            responseConstant.setMessage("Given mobile number already exist in the system , please enter new one");
            responseConstant.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return responseConstant;
        }
        return null;
    }
}
