package carparking.dao.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "parking")
@Data
public class ParkingEntity {
    @Id
    @Field(targetType = FieldType.STRING)
    private String id;
    private String name;
    private String area;
}
