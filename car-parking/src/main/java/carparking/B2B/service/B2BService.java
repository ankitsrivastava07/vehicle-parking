package carparking.B2B.service;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;

import java.util.concurrent.ExecutionException;

public interface B2BService {
    ResponseConstant saveUser(UserDto userDto) throws ExecutionException, InterruptedException;
}
