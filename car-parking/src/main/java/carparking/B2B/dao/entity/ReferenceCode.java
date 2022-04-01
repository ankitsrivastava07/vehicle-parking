package carparking.B2B.dao.entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reference_code")
@Data
public class ReferenceCode {

    private String _id;
    private String slugName;
    private String name;
    private String displayName;
    private String description;
}
