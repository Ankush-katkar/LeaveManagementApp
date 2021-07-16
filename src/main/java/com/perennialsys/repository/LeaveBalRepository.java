package com.perennialsys.repository;

import com.perennialsys.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalRepository extends JpaRepository<LeaveBalance, Long> {

}
