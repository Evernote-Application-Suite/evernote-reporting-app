package in.net.sudhir.evernotereportingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Column;
import java.util.UUID;

/***
    Package Name: in.net.sudhir.evernotereportingapp.model.model
    User Name: SUDHIR
    Created Date: 18-09-2022 at 16:10
    Description:
*/
@Table("notebook")
@NoArgsConstructor
@Getter
@Setter
public class NotebookDBCas {

    @PrimaryKeyColumn(name = "id" , type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "notebook_guid", nullable = false, unique = true)
    private String notebookGuid;

    @Column(name = "notebook_name", nullable = false, unique = true)
    private String notebookName;

    public NotebookDBCas(String notebookGuid, String notebookName) {
        this.notebookGuid = notebookGuid;
        this.notebookName = notebookName;
    }
}
