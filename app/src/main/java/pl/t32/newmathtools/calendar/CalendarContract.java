package pl.t32.newmathtools.calendar;

public class CalendarContract {

    interface View {
        void showComputationResult(String result);
        void showNonExistingDateError();
        void showDateOutOfRangeError();
    }

    interface Presenter {
        void computeWeekDay(int day, int month, int year);
        void computeExplanationOfWeekDay(int day, int month, int year);
    }
}
