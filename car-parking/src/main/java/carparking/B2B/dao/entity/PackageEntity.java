package carparking.B2B.dao.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "package")
public class PackageEntity {
    private String id;
    private UserEntity createdBy;
    private UserEntity updatedBy;
    private Date createdDate;
    private Date updatedDate;
    private String title;
    private String duration;
    private Boolean active;
}

