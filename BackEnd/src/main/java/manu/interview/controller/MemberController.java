package manu.interview.controller;

import manu.interview.model.Member;
import manu.interview.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    Logger logger= LoggerFactory.getLogger(MemberController.class);

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody  Member member){
        ResponseEntity<?> resp=null;
        try {
            Integer id = memberService.saveMember(member);
            logger.info("Requested id  " +id+ " saved ");
            resp=new ResponseEntity<>("Successfully Saved", HttpStatus.CREATED);
        }catch (Exception e){
            resp=new ResponseEntity<>("Unable to process the request", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return resp;
    }
    @PostMapping("/getAll")
    public ResponseEntity<?> getAllMemebers(){
        ResponseEntity<?> resp=null;
        try {
            java.util.List<Member> members = memberService.getAllMembers();
            logger.info("Requested List" +members);
            resp=new ResponseEntity<>("Successfully Fetched", HttpStatus.ACCEPTED);
        }catch (Exception e){
            resp=new ResponseEntity<>("Unable to process the request", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return resp;
    }
}
