package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="role")
@Data
public class RoleEntity {
    private String _id;
    private String name;
    private String slugName;
}
