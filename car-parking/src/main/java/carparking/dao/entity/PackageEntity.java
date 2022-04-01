package carparking.dao.entity;
import carparking.B2B.dao.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "package")
public class PackageEntity {

    private String _id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String packageType;
    private UserEntity createdBy;
    private UserEntity updatedBy;
    private String description;
    private Integer duration;
}
