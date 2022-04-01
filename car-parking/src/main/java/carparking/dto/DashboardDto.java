package carparking.dto;
import lombok.Data;

@Data
public class DashboardDto {

    private Long totalUsers;
    private Long totalActiveUsers;
    private Long underTrialUsers;
    private Long totalInactiveUsers;
}
