package com.ms.cd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.cd.entity.CallDetail;

@Repository
public interface CallRepository extends JpaRepository<CallDetail, Integer> {

	List<CallDetail> findCallDetailByCalledBy(long calledBy);
}
