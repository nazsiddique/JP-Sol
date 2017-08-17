
package model;

import java.time.LocalDate;

/**
 *
 */
public class MuslimWeeklyService extends WeeklyService {


    /**
     * Resolve weekend and return next working day
     *
     * @param date need to work on
     * @return date object
     */
    @Override
    protected LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate res;
        switch (date.getDayOfWeek()) {
            case FRIDAY:
                res = date.plusDays(2);
                break;
            case SATURDAY:
                res = date.plusDays(1);
                break;
            default:
                res = date;
                break;
        }

        return res;
    }
}
