package in.net.sudhir.evernotereportingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/***
 Package Name: in.net.sudhir.evernotebatchapp.model
 User Name: SUDHIR
 Created Date: 04-09-2022 at 06:54
 Description:
 */
@Entity(name = "batch")
@Getter
@Setter
public class Batch {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "batch_name", nullable = false, unique = false)
    private String batchName;

    @Column(name = "start_date", nullable = false, unique = false)
    private Date startDate;

    @Column(name = "end_date", nullable = true, unique = false)
    private Date endDate;

    @Column(name = "records_expected", nullable = false, unique = false)
    private Long recordsExpected;

    @Column(name = "records_processed", nullable = false, unique = false)
    private Long recordsProcessed;

    @Column(name = "records_failed", nullable = false, unique = false)
    private Long recordsFailed;

    @Column(name = "status", nullable = false, unique = false)
    private String status;

}
