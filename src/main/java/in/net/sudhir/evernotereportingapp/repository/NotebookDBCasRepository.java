package in.net.sudhir.evernotereportingapp.repository;

import in.net.sudhir.evernotereportingapp.model.NotebookDBCas;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/***
 Package Name: in.net.sudhir.evernotereportingapp.repository
 User Name: SUDHIR
 Created Date: 18-09-2022 at 16:11
 Description:
 */
public interface NotebookDBCasRepository extends CassandraRepository<NotebookDBCas, UUID> {
}
