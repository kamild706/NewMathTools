package pl.t32.newmathtools.calendar;

public interface CalendarContract {

    interface View {
        void showComputationResult(String result);
        void showNonExistingDateError();
        void showDateOutOfRangeError();
        void showImproperValuesPassedError();
    }

    interface Presenter {
        void computeWeekDay(String day, String month, String year, boolean showAlgorithmSteps);
    }
}
