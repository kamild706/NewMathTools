package pl.t32.newmathtools.calendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pl.t32.newmathtools.algorithms.BenjaminAlgorithm;
import pl.t32.newmathtools.algorithms.BenjaminAlgorithmResult;
import pl.t32.newmathtools.algorithms.exceptions.DateOutOfRangeException;
import pl.t32.newmathtools.algorithms.exceptions.InvalidDateException;

public class CalendarPresenter implements CalendarContract.Presenter {

    private CalendarContract.View calendarView;

    CalendarPresenter(CalendarContract.View view) {
        calendarView = view;
    }

    @Override
    public void computeWeekDay(String day, String month, String year, boolean showAlgorithmSteps) {
        int d, m, y;

        try {
            d = Integer.parseInt(day);
            m = Integer.parseInt(month);
            y = Integer.parseInt(year);
        }
        catch (NumberFormatException | NullPointerException e) {
            calendarView.showImproperValuesPassedError();
            return;
        }

        String dateString = String.format("%d-%02d-%02d", y, m, d);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Date date;
        try {
            date = dateFormat.parse(dateString);
            String formattedDate = formatter.format(date);
            calendarView.showDate(formattedDate);
        }
        catch (ParseException e) {
            calendarView.showImproperValuesPassedError();
            return;
        }

        if (showAlgorithmSteps) {
            BenjaminAlgorithm ba = new BenjaminAlgorithm(d, m, y);
            try {
                BenjaminAlgorithmResult results = ba.calculateSteps();
                formatter = new SimpleDateFormat("LLLL");
                String monthName = formatter.format(date);
                results.setMonthName(monthName);
                calendarView.showAlgorithmSteps(results);
            }
            catch (InvalidDateException e) {
                calendarView.showNonExistingDateError();
            }
            catch (DateOutOfRangeException e) {
                calendarView.showDateOutOfRangeError();
            }
        }
    }
}
