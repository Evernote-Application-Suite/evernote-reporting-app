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
@Entity(name = "Tag")
@Getter
@Setter
public class TagDB {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "tag_guid", nullable = false, unique = true)
    private String tagGuid;

    @Column(name = "tag_name", nullable = false, unique = true)
    private String tagName;

    public TagDB(String tagGuid, String tagName) {
        this.tagGuid = tagGuid;
        this.tagName = tagName;
    }

    public TagDB() {

    }
}
