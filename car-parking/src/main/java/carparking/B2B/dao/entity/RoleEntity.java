package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection="role")
@Data
public class RoleEntity {
    @Id
    @Field(name = "id",targetType = FieldType.STRING)
    private String id;
    private String name;
    private String slugName;
}
