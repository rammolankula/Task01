package manu.interview.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="WorkOut_Logs")
public class WorkOutLog {
    public WorkOutLog(Integer wID, Integer memberID, Date sessionTenor, String exerciseName, Integer sets, Integer reps, String weights) {
        this.wID = wID;
        MemberID = memberID;
        this.sessionTenor = sessionTenor;
        this.exerciseName = exerciseName;
        Sets = sets;
        Reps = reps;
        this.weights = weights;
    }

    public void setwID(Integer wID) {
        this.wID = wID;
    }

    public void setMemberID(Integer memberID) {
        MemberID = memberID;
    }

    public void setSessionTenor(Date sessionTenor) {
        this.sessionTenor = sessionTenor;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setSets(Integer sets) {
        Sets = sets;
    }

    public void setReps(Integer reps) {
        Reps = reps;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public Integer getwID() {
        return wID;
    }

    public Integer getMemberID() {
        return MemberID;
    }

    public Date getSessionTenor() {
        return sessionTenor;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public Integer getSets() {
        return Sets;
    }

    public Integer getReps() {
        return Reps;
    }

    public String getWeights() {
        return weights;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer wID;
    @Column(name="member_id")
    private Integer MemberID;
    @Column(name="session_tenour")
    private Date sessionTenor;
    @Column(name="exercise_Name")
    private String exerciseName;
    @Column(name="Sets")
    private Integer Sets;
    @Column(name="reps")
    private Integer Reps;
    @Column(name="Weights")
    private String weights;



}
