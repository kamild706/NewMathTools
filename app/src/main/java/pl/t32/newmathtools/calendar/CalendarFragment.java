package pl.t32.newmathtools.calendar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.t32.newmathtools.R;
import pl.t32.newmathtools.algorithms.BenjaminAlgorithmResult;

import static pl.t32.newmathtools.MyUtils.getValue;


public class CalendarFragment extends Fragment implements CalendarContract.View {

    private CalendarContract.Presenter calendarPresenter;

    @BindView(R.id.day) EditText day;
    @BindView(R.id.month) EditText month;
    @BindView(R.id.year) EditText year;

    @BindView(R.id.calendarSwitch) Switch verboseOutput;
    @BindView(R.id.dateView) TextView dateView;
    @BindView(R.id.stepsView) TextView stepsView;

    @BindArray(R.array.benjamin_algorithm_steps) String[] steps;
    @BindString(R.string.error_message_date_does_not_exist) String messageDateNotExist;
    @BindString(R.string.error_message_year_out_of_range) String messageYearOutOfRange;
    @BindString(R.string.error_message_numbers_only) String messageNumbersOnly;

    @OnClick(R.id.button) void onButtonClicked() {
        calendarPresenter.computeWeekDay(getValue(day), getValue(month), getValue(year),
                verboseOutput.isChecked());
    }

    @OnClick(R.id.calendarSwitch) void onSwitchCheckedChange() {
        if (!verboseOutput.isChecked())
            stepsView.setText("");

        onButtonClicked();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this, rootView);
        calendarPresenter = new CalendarPresenter(this);

        return rootView;
    }

    @Override
    public void showDate(String text) {
        dateView.setText(text);
    }

    @Override
    public void showAlgorithmSteps(BenjaminAlgorithmResult result) {
        String message = String.format(steps[0], result.getDay(), result.getDayMod7()) +
                String.format(steps[1], result.getMonthName(), result.getMonthOffset()) +
                String.format(steps[2], result.getYearMod100(), result.getYearMod7()) +
                String.format(steps[3], result.getYearMod100(), result.getYearDiv4()) +
                String.format(steps[4], result.getCenturyOffset()) +
                String.format(steps[5], result.getDayMod7(), result.getMonthOffset(),
                        result.getYearMod7(), result.getYearDiv4(), result.getCenturyOffset(),
                        result.sumOfComponents()) +
                String.format(steps[6], result.sumOfComponents(), result.sumOfComponentsMod7());
        stepsView.setText(message);
    }

    @Override
    public void showNonExistingDateError() {
        Snackbar.make(dateView, messageDateNotExist, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showDateOutOfRangeError() {
        Snackbar.make(dateView, messageYearOutOfRange, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showImproperValuesPassedError() {
        Snackbar.make(dateView, messageNumbersOnly, Snackbar.LENGTH_LONG).show();
    }
}
