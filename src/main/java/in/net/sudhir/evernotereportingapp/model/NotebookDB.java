package in.net.sudhir.evernotereportingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 Package Name: in.net.sudhir.evernotebatchapp.model
 User Name: SUDHIR
 Created Date: 03-09-2022 at 07:51
 Description:
 */
@Entity(name = "Notebook")
@Getter
@Setter
public class NotebookDB {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "notebook_guid", nullable = false, unique = true)
    private String notebookGuid;

    @Column(name = "notebook_name", nullable = false, unique = true)
    private String notebookName;

    public NotebookDB(String notebookGuid, String notebookName) {
        this.notebookGuid = notebookGuid;
        this.notebookName = notebookName;
    }

    public NotebookDB() {

    }
}
