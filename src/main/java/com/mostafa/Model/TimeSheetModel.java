package com.mostafa.Model;

import com.mostafa.entity.TimeSheet;

import java.sql.Timestamp;
import java.util.Date;

public class TimeSheetModel {
    private Long id;
    private Long userId;
    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;
    private double effectiveHours;

    public TimeSheetModel SetTimeSheetModel(TimeSheet timeSheet) {
        this.id = timeSheet.getId();
        this.userId = timeSheet.getUser().getId();
        this.date = timeSheet.getDate();
        this.startTime = timeSheet.getStartTime();
        this.endTime = timeSheet.getEndTime();
        this.effectiveHours = timeSheet.getEffectiveHours();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public double getEffectiveHours() {
        return effectiveHours;
    }

    public void setEffectiveHours(double effectiveHours) {
        this.effectiveHours = effectiveHours;
    }
}
