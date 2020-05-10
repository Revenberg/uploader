package info.revenberg.uploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  info.revenberg.uploader.dao.jpa.BatchRepository;

@Service
public class BatchService {
    // @Autowired
    private BatchRepository batchRepository;
    
    public BatchService() {    
    }

    public Long getLastReadCount() {
        return batchRepository.getLastReadCount();
    }

}
