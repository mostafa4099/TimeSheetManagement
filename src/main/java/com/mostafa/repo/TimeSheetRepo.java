package com.mostafa.repo;

import com.mostafa.entity.TimeSheet;
import com.mostafa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TimeSheetRepo extends JpaRepository<TimeSheet, Long> {
    TimeSheet findByDateAndUser(Date time, User user);

    TimeSheet findByDate(Date date);
}
