package in.net.sudhir.evernotereportingapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import in.net.sudhir.evernotereportingapp.model.*;
import in.net.sudhir.evernotereportingapp.repository.*;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RefreshScope
@EnableEncryptableProperties
@EnableJpaRepositories(basePackages = {"in.net.sudhir.evernotereportingapp"})
@EnableCassandraRepositories(basePackages = {"in.net.sudhir.evernotereportingapp"})
public class EvernoteReportingAppApplication {

	@Autowired
	NotebookDBCasRepository notebookDBCasRepository;

	@Autowired
	NoteDBCasRepository noteDBCasRepository;

	@Autowired
	TagDBCasRepository tagDBCasRepository;

	@Autowired
	BatchCasRepository batchCasRepository;

	@Autowired
	FileDBCasRepository fileDBCasRepository;

	@Autowired
	NotebookDBRepository notebookDBRepository;

	@Autowired
	NoteDBRepository noteDBRepository;

	@Autowired
	TagDBRepository tagDBRepository;

	@Autowired
	BatchRepository batchRepository;

	@Autowired
	FileDBRepository fileDBRepository;

	public static void main(String[] args) {
		SpringApplication.run(EvernoteReportingAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			List<NotebookDBCas> notebookDBCasList = notebookDBCasRepository.findAll();
			notebookDBCasList.forEach(notebook -> {notebookDBCasRepository.delete(notebook);});
			Iterable<NotebookDB> notebookDBList = notebookDBRepository.findAll();

			notebookDBList.forEach(notebook -> {
				notebookDBCasRepository.save(new NotebookDBCas(notebook.getNotebookGuid(), notebook.getNotebookName()));
			});

			List<NoteDBCas> noteDBCasList = noteDBCasRepository.findAll();
			noteDBCasList.forEach(note -> {noteDBCasRepository.delete(note);});
			Iterable<NoteDB> noteDBList = noteDBRepository.findAll();

			noteDBList.forEach(note -> {
				noteDBCasRepository.save(new NoteDBCas(note.getNoteGuid(), note.getNoteName(), note.getNotebookGUID()));
			});

			List<TagDBCas> tagDBCasList = tagDBCasRepository.findAll();
			tagDBCasList.forEach(tag -> {tagDBCasRepository.delete(tag);});
			Iterable<TagDB> tagDBList = tagDBRepository.findAll();

			tagDBList.forEach(tag -> {
				tagDBCasRepository.save(new TagDBCas(tag.getTagGuid(), tag.getTagName()));
			});

			List<BatchCas> batchCasList = batchCasRepository.findAll();
			batchCasList.forEach(batch -> {batchCasRepository.delete(batch);});
			Iterable<Batch> batchList = batchRepository.findAll();

			batchList.forEach(batch -> {
				batchCasRepository.save(new BatchCas(batch.getBatchName(), batch.getStartDate(), batch.getEndDate(), batch.getRecordsExpected(), batch.getRecordsProcessed(), batch.getRecordsFailed(), batch.getStatus()));
			});

			List<FileDBCas> fileDBCasList = fileDBCasRepository.findAll();
			fileDBCasList.forEach(file -> {fileDBCasRepository.delete(file);});
			Iterable<FileDB> fileDBList = fileDBRepository.findAll();

			fileDBList.forEach(file -> {
				fileDBCasRepository.save(new FileDBCas(file.getFileName(), file.getFileSize(), file.getIsUploaded(), file.getNoteUrl(), file.getDirectoryName()));
			});

			System.exit(0);
		};
	}

}
