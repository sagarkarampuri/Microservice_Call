package com.ms.cd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cd.dto.CallDTO;
import com.ms.cd.exception.CallException;
import com.ms.cd.service.CallService;

@RestController
public class CallServiceController {

	@Autowired
	private CallService callService;

	@GetMapping("/calls/{id}")
	public ResponseEntity<CallDTO> getCallById(@PathVariable("id") int id) throws CallException {
		return new ResponseEntity<>(callService.getCallById(id), HttpStatus.OK);
	}

	@GetMapping("/calls/{calledBy}/record")
	public ResponseEntity<List<CallDTO>> getCallDetailsByPhoneNo(@PathVariable("calledBy") long calledBy)
			throws CallException {
		return new ResponseEntity<List<CallDTO>>(callService.getCallDetailsByPhoneNo(calledBy), HttpStatus.OK);
	}
}
