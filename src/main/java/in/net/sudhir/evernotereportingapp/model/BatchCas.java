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
import java.util.Date;
import java.util.UUID;

/***
 Package Name: in.net.sudhir.evernotereportingapp.model
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:19
 Description:
 */
@Table("batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchCas {

    @PrimaryKeyColumn(name = "id" , type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id = UUID.randomUUID();

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

    public BatchCas(String batchName, Date startDate, Date endDate, Long recordsExpected, Long recordsProcessed, Long recordsFailed, String status) {
        this.batchName = batchName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recordsExpected = recordsExpected;
        this.recordsProcessed = recordsProcessed;
        this.recordsFailed = recordsFailed;
        this.status = status;
    }
}
