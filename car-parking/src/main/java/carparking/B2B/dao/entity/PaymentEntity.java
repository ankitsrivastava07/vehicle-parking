package carparking.B2B.dao.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "payment")
public class PaymentEntity {
    private String _id;
    private Double amount;
    private String paymentMethod;
    private String transactionId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
