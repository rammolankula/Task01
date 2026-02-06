package manu.interview.repository;

import manu.interview.model.WorkOutLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOutRepository extends JpaRepository<WorkOutLog,Integer> {
}
