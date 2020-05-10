package info.revenberg.uploader.objects;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

public class MyStepExecution extends StepExecution {

    public MyStepExecution(String stepName, JobExecution jobExecution) {
		super(stepName, jobExecution);		
	}	
	public MyStepExecution(String stepName, JobExecution jobExecution, Long id) {
		super(stepName, jobExecution, id);		
	}
}