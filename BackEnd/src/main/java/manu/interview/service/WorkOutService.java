package manu.interview.service;

import manu.interview.model.WorkOutLog;

import java.util.List;
import java.util.Optional;

public interface WorkOutService {

    Integer saveWorklog(WorkOutLog workOutLog);
    List<WorkOutLog> getAllMembers();
    Optional<WorkOutLog> gerOneMember(Integer memberID);
    void updateWorKOutMembers(WorkOutLog workOutLog);



}
