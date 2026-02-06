package manu.interview.serviceImpl;

import manu.interview.model.WorkOutLog;
import manu.interview.repository.WorkOutRepository;
import manu.interview.service.WorkOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkOutServiceImpl implements WorkOutService {

    @Autowired
    WorkOutRepository workOutRepository;

    @Override
    public Integer saveWorklog(WorkOutLog workOutLog) {
        workOutLog=workOutRepository.save(workOutLog);
        return workOutLog.getwID();
    }

    @Override
    public List<WorkOutLog> getAllMembers() {
        return workOutRepository.findAll();
    }

    @Override
    public Optional<WorkOutLog> gerOneMember(Integer memberID) {
        return workOutRepository.findById(memberID);
    }

    @Override
    public void updateWorKOutMembers(WorkOutLog workOutLog) {
        workOutRepository.save(workOutLog);
    }
}
