package in.net.sudhir.evernotereportingapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.UUID;

/***
 Package Name: in.net.sudhir.evernotereportingapp.model
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:11
 Description:
 */
@Table("note")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDBCas {

    @PrimaryKeyColumn(name = "id" , type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "note_guid", nullable = false, unique = true)
    private String noteGuid;

    @Column(name = "note_name", nullable = false, unique = false)
    private String noteName;

    @Column(name = "notebook_guid", nullable = false, unique = false)
    private String notebookGUID;

    public NoteDBCas(String noteGuid, String noteName, String notebookGUID) {
        this.noteGuid = noteGuid;
        this.noteName = noteName;
        this.notebookGUID = notebookGUID;
    }
}
