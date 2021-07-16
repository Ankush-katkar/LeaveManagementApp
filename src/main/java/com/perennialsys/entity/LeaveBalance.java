package com.perennialsys.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Tracks the user's leave balance
 * Entity class
 * Table name leave_bal
 *
 * @author Ankush Katkar
 */

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

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public LeaveBalance() {
        // Default
    }

    public LeaveBalance(int emergencyLeave, int paidLeave, User user) {
        this.emergencyLeave = emergencyLeave;
        this.paidLeave = paidLeave;
        this.user = user;
    }
}
