package com.mostafa.service;

import com.mostafa.Model.TimeSheetModel;
import com.mostafa.Model.TimeSheetReqResModel;

import java.text.ParseException;
import java.util.Date;

public interface TimeSheetService {
    TimeSheetReqResModel getWeeklyTimeSheet(Long userId) throws ParseException;

    TimeSheetModel getDailyTimeSheet(Date date);

    TimeSheetModel saveOrUpdateTimesheet(TimeSheetModel sheetModel);
}
