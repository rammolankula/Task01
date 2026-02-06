package manu.interview.controller;

import manu.interview.model.WorkOutLog;
import manu.interview.service.WorkOutService;
import manu.interview.util.Utilupate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workoutlog")
public class WorkOutLogController {

    Logger logger= LoggerFactory.getLogger(WorkOutLogController.class);

    @Autowired
    WorkOutService workOutService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody WorkOutLog workOutLog){
        ResponseEntity<?> resp=null;
        try {
            java.lang.Integer ID = workOutService.saveWorklog(workOutLog);
            resp=new ResponseEntity<>("Requested "+ID+" details saved", HttpStatus.CREATED);
        }catch (Exception e){
            resp= new ResponseEntity<>("Unable to process",HttpStatus.SERVICE_UNAVAILABLE);
        }
     return  resp;
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> getListOfMembers(){
        ResponseEntity<?> resp=null;
        try {
            List<WorkOutLog> list= workOutService.getAllMembers();
            resp=new ResponseEntity<>(list+" Details Fetched", HttpStatus.CREATED);
        }catch (Exception e){
            resp= new ResponseEntity<>("Unable to process",HttpStatus.SERVICE_UNAVAILABLE);
        }
        return  resp;
    }

    @PostMapping("/fetchOne/{id}")
    public ResponseEntity<?> getAllMemebers(@PathVariable Integer id){
        ResponseEntity<?> resp=null;
        try {
            Optional<WorkOutLog> getOne=workOutService.gerOneMember(id);
            if(getOne.isPresent()){
                resp=new ResponseEntity<>(getOne, HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            resp=new ResponseEntity<>("Unable to process the request", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return resp;
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<?> getAllMemebers(@PathVariable Integer id,WorkOutLog workOutLog){
        ResponseEntity<?> resp=null;
        try {
            Optional<WorkOutLog> getOne=workOutService.gerOneMember(id);
            if(getOne.isPresent()){
                WorkOutLog actualValue=getOne.get();
                Utilupate.upateRequestedDetails(actualValue,workOutLog);
                workOutService.updateWorKOutMembers(actualValue);
                resp=new ResponseEntity<>(actualValue,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            resp=new ResponseEntity<>("Unable to process the request", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return resp;
    }





}
