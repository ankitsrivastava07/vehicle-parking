package carparking.B2B.dao.entity;
import carparking.dao.entity.PackageEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Document(collection="subscription")
public class SubscriptionEntity {

    private String _id;
    private UserEntity createdBy;
    private UserEntity updatedBy;
    private LocalDateTime subscriptionStartDate;
    private LocalDateTime subcriptionEndDate;
    private String title;
    @Field(name = "package")
    private PackageEntity packageEntity;
    private ReferenceCode status;
    private Double amount;
    private Double dueAmount;
    private UserEntity buyer;
    private PaymentEntity payment;
}
