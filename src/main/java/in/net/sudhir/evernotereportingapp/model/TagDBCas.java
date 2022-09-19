package in.net.sudhir.evernotereportingapp.model;


import lombok.AllArgsConstructor;
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
 Package Name: in.net.sudhir.evernotereportingapp.model
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:10
 Description:
 */
@Table("tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagDBCas {

    @PrimaryKeyColumn(name = "id" , type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "tag_guid", nullable = false, unique = true)
    private String tagGuid;

    @Column(name = "tag_name", nullable = false, unique = true)
    private String tagName;

    public TagDBCas(String tagGuid, String tagName) {
        this.tagGuid = tagGuid;
        this.tagName = tagName;
    }
}
