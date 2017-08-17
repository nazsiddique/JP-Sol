
package model;

import java.time.LocalDate;

/**
 *
 */
public abstract class WeeklyService {
    /**
     * Resolve weekend and return next working day
     * @return date object
     */
    protected abstract LocalDate getNextWorkingDay(LocalDate date);

}
