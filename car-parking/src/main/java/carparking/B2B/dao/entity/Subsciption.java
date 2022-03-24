package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.sql.Date;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscription")
@Data
public class Subsciption {
    @Id
    private String id;
    private Date startDate;
    private Date endDate;
    private ReferenceCode subscriptionStatus;
    private UserEntity user;
    private UserEntity createdBy;
    private UserEntity updatedBy;
}
