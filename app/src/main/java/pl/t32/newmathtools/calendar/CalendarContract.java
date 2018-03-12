package pl.t32.newmathtools.calendar;


import pl.t32.newmathtools.algorithms.BenjaminAlgorithmResult;

public interface CalendarContract {

    interface View {
        void showDate(String text);
        void showAlgorithmSteps(BenjaminAlgorithmResult result);
        void showNonExistingDateError();
        void showDateOutOfRangeError();
        void showImproperValuesPassedError();
    }

    interface Presenter {
        void computeWeekDay(String day, String month, String year, boolean showAlgorithmSteps);
    }
}
