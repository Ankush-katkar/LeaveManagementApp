package com.perennialsys.repository;

import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalRepository extends JpaRepository<LeaveBalance, Integer> {

    LeaveBalance findByUserId(int userId);

}
