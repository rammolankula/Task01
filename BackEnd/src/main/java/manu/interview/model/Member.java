package manu.interview.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.processing.Generated;
import java.util.Date;



@Entity
@Table(name="tbl_member")
public class Member {
    public Member(Integer id, String name, Date joinedDate) {
        this.id = id;
        this.name = name;
        this.joinedDate = joinedDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date joinedDate;

    public void setWorkOutLog(WorkOutLog workOutLog) {
        this.workOutLog = workOutLog;
    }

    public WorkOutLog getWorkOutLog() {
        return workOutLog;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
   private WorkOutLog workOutLog;



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }
}
