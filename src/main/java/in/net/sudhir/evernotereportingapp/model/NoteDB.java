package in.net.sudhir.evernotereportingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 Package Name: in.net.sudhir.evernotebatchapp.model
 User Name: SUDHIR
 Created Date: 03-09-2022 at 07:50
 Description:
 */
@Entity(name = "Note")
@Getter
@Setter
public class NoteDB {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "note_guid", nullable = false, unique = true)
    private String noteGuid;

    @Column(name = "note_name", nullable = false, unique = false)
    private String noteName;

    @Column(name = "notebook_guid", nullable = false, unique = false)
    private String notebookGUID;


}
