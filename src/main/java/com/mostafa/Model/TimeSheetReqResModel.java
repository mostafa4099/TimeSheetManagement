package com.mostafa.Model;

import java.util.ArrayList;
import java.util.List;

public class TimeSheetReqResModel {
    private Long userId;

    private List<TimeSheetModel> timeSheetModels = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TimeSheetModel> getTimeSheetModels() {
        return timeSheetModels;
    }

    public void setTimeSheetModels(List<TimeSheetModel> timeSheetModels) {
        this.timeSheetModels = timeSheetModels;
    }
}
