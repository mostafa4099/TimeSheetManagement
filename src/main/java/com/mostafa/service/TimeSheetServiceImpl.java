package com.mostafa.service;

import com.mostafa.Model.TimeSheetModel;
import com.mostafa.Model.TimeSheetReqResModel;
import com.mostafa.entity.TimeSheet;
import com.mostafa.entity.User;
import com.mostafa.repo.TimeSheetRepo;
import com.mostafa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TimeSheetRepo timeSheetRepo;

    @Override
    public TimeSheetReqResModel getWeeklyTimeSheet(Long userId) throws ParseException {
        TimeSheetReqResModel timeSheetReqResModel = new TimeSheetReqResModel();
        List<TimeSheetModel> timeSheetModels = new ArrayList<>();
        User user = new User();
        TimeSheetModel model = new TimeSheetModel();
        if (null != userId) {
            user = userRepo.findById(userId).get();
            timeSheetReqResModel.setUserId(user.getId());
        }

        String ld = LocalDate.now().with(DayOfWeek.SUNDAY).toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date weekStart = simpleDateFormat.parse(ld);

        for (int i = 0; i < 5; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(weekStart);
            cal.add(Calendar.DATE, i);

            TimeSheet timeSheet = timeSheetRepo.findByDateAndUser(cal.getTime(), user);

            model.SetTimeSheetModel(timeSheet);
            model.setDate(cal.getTime());

            timeSheetModels.add(model);
        }

        timeSheetReqResModel.setTimeSheetModels(timeSheetModels);

        return timeSheetReqResModel;
    }

    @Override
    public TimeSheetModel getDailyTimeSheet(Date date) {
        TimeSheetModel timeSheetModel = new TimeSheetModel();
        TimeSheet timeSheet = timeSheetRepo.findByDate(date);
        timeSheetModel.SetTimeSheetModel(timeSheet);
        return timeSheetModel;
    }

    @Override
    public TimeSheetModel saveOrUpdateTimesheet(TimeSheetModel sheetModel) {
        TimeSheet timeSheet = new TimeSheet();
        User user = userRepo.findById(sheetModel.getUserId()).get();
        timeSheet = timeSheet.SetTimeSheet(sheetModel, user);

        timeSheet = timeSheetRepo.save(timeSheet);
        sheetModel.setId(timeSheet.getId());
        return sheetModel;
    }
}
