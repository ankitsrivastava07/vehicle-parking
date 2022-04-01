package carparking.B2B.dto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SubscriptionDto {
    private String buyer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Double amount;
}
