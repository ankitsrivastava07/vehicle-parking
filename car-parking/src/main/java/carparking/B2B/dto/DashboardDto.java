package carparking.B2B.dto;
import lombok.Data;

@Data
public class DashboardDto {
    private Long totalUsers;
    private Long activeUsers;
    private Long inactiveUsers;
}
