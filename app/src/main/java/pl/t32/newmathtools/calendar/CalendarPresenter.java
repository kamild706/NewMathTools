package pl.t32.newmathtools.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pl.t32.newmathtools.MyUtils;
import pl.t32.newmathtools.algorithms.BenjaminAlgorithm;
import pl.t32.newmathtools.algorithms.BenjaminAlgorithmResults;

public class CalendarPresenter implements CalendarContract.Presenter {

    private CalendarContract.View calendarView;

    CalendarPresenter(CalendarContract.View view) {
        calendarView = view;
    }

    @Override
    public void computeWeekDay(String day, String month, String year, boolean showAlgorithmSteps) {
        try {
            int d = Integer.parseInt(day);
            int m = Integer.parseInt(month);
            int y = Integer.parseInt(year);
            computeWeekDay(d, m, y);
        } catch (NumberFormatException | NullPointerException e) {
            calendarView.showImproperValuesPassedError();
        }
    }

    private void computeWeekDay(int day, int month, int year) {
        BenjaminAlgorithm ba = new BenjaminAlgorithm(day, month, year);
        BenjaminAlgorithmResults results = null;

        try {
            results = ba.calculateSteps();
        } catch (BenjaminAlgorithm.InvalidDateException e) {
            calendarView.showNonExistingDateError();
        } catch (BenjaminAlgorithm.DateOutOfRangeException e) {
            calendarView.showDateOutOfRangeError();
        }

        if (results != null) {
            /*int dayOfWeek = results.getSumOfAll() % 7;
            calendarView.showComputationResult("" + dayOfWeek);*/

            try {
                SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date = inFormat.parse(day + "-" + month + "-" + year);
                SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
                String goal = outFormat.format(date);
                calendarView.showComputationResult(MyUtils.capitalize(goal));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
