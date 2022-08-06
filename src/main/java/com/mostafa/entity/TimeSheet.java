package com.mostafa.entity;

import com.mostafa.Model.TimeSheetModel;
import com.mostafa.Model.UserModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;
    private double effectiveHours;

    public TimeSheet SetTimeSheet(TimeSheetModel model, User user) {
        this.id = model.getId();
        this.user = user;
        this.date = model.getDate();
        this.startTime = model.getStartTime();
        this.endTime = model.getEndTime();
        this.effectiveHours = model.getEffectiveHours();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
