package com.perennialsys.service;

import com.perennialsys.entity.Leave;
import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;
import com.perennialsys.repository.LeaveBalRepository;
import com.perennialsys.repository.LeaveRepository;
import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveRepository lveRepo;
    @Autowired
    private LeaveBalRepository lbRepo;


    public static long getDifferenceDays(LocalDate d1, LocalDate d2) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        return ChronoUnit.DAYS.between(d1, d2);


    }

    @Override
    public String createNewLeave(Leave leave) {

      /*  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object user = auth.getPrincipal();
        System.out.println(leave);*/
        LeaveBalance leaveBalance = new LeaveBalance();

        List<LeaveBalance> obj = lbRepo.findAll();
        if (obj != null) {

            Iterator<LeaveBalance> iter = obj.iterator();
            while (iter.hasNext()) {
                LeaveBalance yp = iter.next();
                int pl = yp.getPaidLeave();
                int el = yp.getEmergencyLeave();

                LocalDate d1 = leave.getLeaveFromDate();
                LocalDate d2 = leave.getLeaveToDate();
                long diff = getDifferenceDays(d1, d2);
                String lt = leave.getLeaveType();

                if (lt.equals("el")) {

                    long tosavedel = el - diff;
                    leaveBalance.setEmergencyLeave((int) tosavedel);
                }
                if (lt.equals("pl")) {
                    long tosavedpl = pl - diff;
                    leaveBalance.setPaidLeave((int)tosavedpl);

                }



            }

        }
        leave.setLeaveBalance(leaveBalance);

        //leaveBalance.setLeave(leave);
        Leave savedLve = lveRepo.save(leave);

        return "savedLve";


    }

  /*  public String update(LeaveBalance leaveBalance, int  id ){

        List<LeaveBalance> lbobj = lbRepo.findAll();
        obj.stream().map(b -> {
        if(b.getId()== id){
            lbobj.get();
        }
        });*/

//        return b;
    }

    /*@Override
    public static  String lveBalDeduct() {
        LeaveBalance lb = new LeaveBalance();
        if(saved){
            String status = savedLve.getStatus();
            try {

                if (status == "APPROVED") {
                    lveBalDeduct();

                }
            }
            catch(Exception e){

            }
        }


        return null;
    }*/

