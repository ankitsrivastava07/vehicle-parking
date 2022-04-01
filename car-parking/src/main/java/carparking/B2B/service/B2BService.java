package carparking.B2B.service;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;
import carparking.dto.CreateUserDto;
import carparking.dto.DashboardDto;

public interface B2BService {
    ResponseConstant saveUser(UserDto userDto);
    ResponseConstant addUser(CreateUserDto createUserDto);
    DashboardDto dashBoardData();
}
