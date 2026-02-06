package manu.interview.util;

import manu.interview.model.WorkOutLog;

import java.util.Optional;

public class Utilupate {
    public static void upateRequestedDetails(WorkOutLog getOne, WorkOutLog workOutLog) {
        getOne.setwID(workOutLog.getwID());
        getOne.setMemberID(workOutLog.getMemberID());
        getOne.setExerciseName(workOutLog.getExerciseName());
        getOne.setReps(workOutLog.getReps());
        getOne.setWeights(workOutLog.getWeights());
        getOne.setSessionTenor(workOutLog.getSessionTenor());
    }
}
