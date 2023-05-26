package com.ms.cd.dto;

import java.time.LocalDate;

import com.ms.cd.entity.CallDetail;

public class CallDTO {

	private long calledTo;
	private LocalDate calledOn;
	private int duration;

	public static CallDTO createDTO(CallDetail call) {
		CallDTO callDTO = new CallDTO();
		callDTO.setCalledTo(call.getCalledTo());
		callDTO.setCalledOn(call.getCalledOn());
		callDTO.setDuration(call.getDuration());
		return callDTO;
	}

	public long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(long calledTo) {
		this.calledTo = calledTo;
	}

	public LocalDate getCalledOn() {
		return calledOn;
	}

	public void setCalledOn(LocalDate calledOn) {
		this.calledOn = calledOn;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
