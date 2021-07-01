package com.perennialsys.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="leave")
public class Leave {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String leaveFromDate;
    private String leaveToDate;
    private  String reason;
    private String leaveType;
    private String leaveMessage;
    private  String status;
}
