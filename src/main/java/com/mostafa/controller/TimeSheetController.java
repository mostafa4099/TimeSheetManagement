package com.mostafa.controller;

import com.mostafa.Model.TimeSheetModel;
import com.mostafa.Model.TimeSheetReqResModel;
import com.mostafa.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Date;

@RestController
public class TimeSheetController {

    @Autowired
    private TimeSheetService timeSheetService;

    @GetMapping({"/weeklyTimeSheet/{userId}"})
    @PreAuthorize("hasRole('Admin') || hasRole('User')")
    public TimeSheetReqResModel getWeeklyTimeSheet(@PathParam("userId") Long userId) throws ParseException {
        return timeSheetService.getWeeklyTimeSheet(userId);
    }

    @GetMapping({"/dailyTimeSheet/{date}"})
    @PreAuthorize("hasRole('Admin') || hasRole('User')")
    public TimeSheetModel getDailyTimeSheet(@PathParam("date") Date date) throws ParseException {
        return timeSheetService.getDailyTimeSheet(date);
    }

    @PostMapping({"/timeSheet"})
    @PreAuthorize("hasRole('Admin') || hasRole('User')")
    public TimeSheetModel saveOrUpdateTimesheet(TimeSheetModel sheetModel) {
        return timeSheetService.saveOrUpdateTimesheet(sheetModel);
    }
}
