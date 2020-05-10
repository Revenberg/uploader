package info.revenberg.uploader.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.revenberg.uploader.objects.MyStepExecution;

public interface BatchRepository extends JpaRepository<MyStepExecution, Long> {
    
    @Query(value = "SELECT * FROM BATCH_STEP_EXECUTION", nativeQuery = true)
    List<MyStepExecution> findAll();

    @Query(value = "SELECT READ_COUNT FROM BATCH_STEP_EXECUTION where STEP_EXECUTION_ID = (SELECT max(STEP_EXECUTION_ID ) FROM BATCH_STEP_EXECUTION )", nativeQuery = true)
    Long getLastReadCount();

}
