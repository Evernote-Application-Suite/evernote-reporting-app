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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/***
 Package Name: in.net.sudhir.evernotereportingapp.model
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:19
 Description:
 */
@Table("file")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDBCas {

    @PrimaryKeyColumn(name = "id" , type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "file_name", nullable = false, unique = false)
    private String fileName;

    @Column(name = "file_size", nullable = false, unique = false)
    private Long fileSize;

    @Column(name = "is_uploaded", nullable = true, unique = false)
    private Boolean isUploaded;

    @Column(name = "note_url", nullable = true, unique = true)
    private String noteUrl;

    @Column(name = "directory_name", nullable = false, unique = false)
    private String directoryName;

    public FileDBCas(String fileName, Long fileSize, Boolean isUploaded, String noteUrl, String directoryName) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isUploaded = isUploaded;
        this.noteUrl = noteUrl;
        this.directoryName = directoryName;
    }
}
