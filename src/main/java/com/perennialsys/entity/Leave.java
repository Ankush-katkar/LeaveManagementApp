package com.perennialsys.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "leaveapply")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // private String username;
    @Column(name = "leave_from_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate leaveFromDate;
    @Column(name = "leave_to_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate leaveToDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "leave_type")
    private String leaveType;
    @Column(name = "leave_message")
    private String leaveMessage;
    @Column(name = "status")
    private String status;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    //first leavebal.col ref col // forign key col ref known
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private  User user;
/*

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private LeaveBalance leaveBalance;
*/

}
