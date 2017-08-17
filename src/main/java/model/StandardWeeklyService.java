package model;

import java.time.LocalDate;

public class StandardWeeklyService extends WeeklyService{

    /**
     * Resolve weekend and return next working day
     *
     * @param date date need to process
     * @return date object
     */
    @Override
    protected LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate res ;
         switch (date.getDayOfWeek()) {
             case SATURDAY:
                 res = date.plusDays(2);
                 break;
             case SUNDAY:
                 res = date.plusDays(1);
                 break;
             default:
                 res = date;
                 break;
         }

         return res;
    }
}
