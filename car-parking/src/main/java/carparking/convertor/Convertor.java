package carparking.convertor;
import carparking.constant.ParkingConstant;
import carparking.error.ApiError;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import java.util.ArrayList;
import java.util.List;

@Data
public class Convertor {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ApiError errors(List<FieldError> fieldErrors){
        List<carparking.error.FieldError> fieldErrors1 = new ArrayList<>();
        for(FieldError fieldError : fieldErrors){
            carparking.error.FieldError fieldError1 = new carparking.error.FieldError();
            fieldError1.setFieldName(fieldError.getField());
            fieldError1.setRejectedValue(fieldError.getRejectedValue());
            fieldError1.setMessage(fieldError.getDefaultMessage());
            fieldErrors1.add(fieldError1);
        }
        ApiError apiError= new ApiError();
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setMessage(ParkingConstant.VALIDATION_FAILED);
        apiError.setErrors(fieldErrors1);
        apiError.setStatus(Boolean.FALSE);
        return apiError;
    }

    public static <D> D dtoToEntityConversion(Object source,Class<D> targetType){
      return modelMapper.map(source,targetType);
    }

    public static <D> D entityToDtoConversion(Object source,Class<D> targetType){
        return modelMapper.map(source,targetType);
    }

}
