package kr.co.testCode.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import java.util.Optional;


import kr.co.testCode.jpa.testtableService;
import kr.co.testCode.jpa.testtableVo;

@RestController
@RequestMapping("memberTest")
public class TestJpaRestController {

	@Autowired testtableService testtableService;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<testtableVo>> getAllmembers() {
        List<testtableVo> member = testtableService.findAll();
        return new ResponseEntity<List<testtableVo>>(member, HttpStatus.OK);
    }
	
	// 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<testtableVo> getMember(@PathVariable("mbrNo") Integer mbrNo) {
        Optional<testtableVo> member = testtableService.findById(mbrNo);
        return new ResponseEntity<testtableVo>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Integer mbrNo) {
        testtableService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 name, phone로 수정함)
    @PutMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<testtableVo> updateMember(@PathVariable("mbrNo") Integer mbrNo, testtableVo member) {
        testtableService.updateById(mbrNo, member);
        return new ResponseEntity<testtableVo>(member, HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<testtableVo> save(testtableVo member) {
        return new ResponseEntity<testtableVo>(testtableService.save(member), HttpStatus.OK);
    }
    
    // 회원 입력
    @GetMapping("/saveMember")
    public ResponseEntity<testtableVo> save(HttpServletRequest req, testtableVo member){
        return new ResponseEntity<testtableVo>(testtableService.save(member), HttpStatus.OK);
    }

}
