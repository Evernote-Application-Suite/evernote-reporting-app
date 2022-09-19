package in.net.sudhir.evernotereportingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 Package Name: in.net.sudhir.evernotebatchapp.repository
 User Name: SUDHIR
 Created Date: 05-09-2022 at 04:59
 Description:
 */
@Entity(name = "file")
@Getter
@Setter
public class FileDB {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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
}
