package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection="license")
public class LicenseEntity {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private UserEntity createdBy;
    private UserEntity updatedBy;
    private String licenseKey;
    private ReferenceCode status;
    private UserEntity user;
    private Date expireAt;
    private PackageEntity packageType;
}
