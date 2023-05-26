package com.ms.cd.service;

import java.util.List;

import com.ms.cd.dto.CallDTO;
import com.ms.cd.exception.CallException;

public interface CallService {

	CallDTO getCallById(int id) throws CallException;

	List<CallDTO> getCallDetailsByPhoneNo(long calledBy) throws CallException;
}
