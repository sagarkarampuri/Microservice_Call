package com.ms.cd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.cd.dto.CallDTO;
import com.ms.cd.entity.CallDetail;
import com.ms.cd.exception.CallException;
import com.ms.cd.repository.CallRepository;

@Service
public class CallServiceImpl implements CallService {

	@Autowired
	private CallRepository callRepository;

	@Override
	public CallDTO getCallById(int id) throws CallException {
		CallDetail call = callRepository.findById(id)
				.orElseThrow(() -> new CallException("call details not found with call id : " + id));
		return CallDTO.createDTO(call);
	}

	@Override
	public List<CallDTO> getCallDetailsByPhoneNo(long calledBy) throws CallException {
		List<CallDetail> callDetails = callRepository.findCallDetailByCalledBy(calledBy);
		if (callDetails.isEmpty()) {
			throw new CallException("call records not found with phone number : " + calledBy);
		}
		List<CallDTO> callDTOs = new ArrayList<>();
		for (CallDetail callDetail : callDetails) {
			callDTOs.add(CallDTO.createDTO(callDetail));
		}
		return callDTOs;
	}

}
