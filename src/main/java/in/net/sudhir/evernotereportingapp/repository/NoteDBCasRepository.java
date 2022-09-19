package in.net.sudhir.evernotereportingapp.repository;

import in.net.sudhir.evernotereportingapp.model.NoteDBCas;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/***
 Package Name: in.net.sudhir.evernotereportingapp.repository
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:14
 Description:
 */
public interface NoteDBCasRepository extends CassandraRepository<NoteDBCas, UUID> {
}
