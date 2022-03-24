package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.util.List;

@Document("user")
@Data
public class UserEntity {
    @Id
    @Field(targetType=FieldType.INT64)
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobile;
    private List<RoleEntity> role;

}
