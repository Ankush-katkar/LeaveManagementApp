package com.perennialsys.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "leave_bal")
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "emergency_leave")
    private int emergencyLeave;
    @Column(name = "paid_leave")
    private int paidLeave;
 /*  @OneToOne(mappedBy = "leaveBalance", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Leave leave;
*/

}
