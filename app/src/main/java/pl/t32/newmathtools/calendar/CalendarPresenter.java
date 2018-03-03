package pl.t32.newmathtools.calendar;

public class CalendarPresenter implements CalendarContract.Presenter {

    private CalendarContract.View calendarView;

    CalendarPresenter(CalendarContract.View view) {
        calendarView = view;
    }

    @Override
    public void computeWeekDay(int day, int month, int year) {
        calendarView.showDateOutOfRangeError();
    }

    @Override
    public void computeExplanationOfWeekDay(int day, int month, int year) {
        calendarView.showNonExistingDateError();
    }
}
