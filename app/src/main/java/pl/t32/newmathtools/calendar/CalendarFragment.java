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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.t32.newmathtools.MyUtils;
import pl.t32.newmathtools.R;


public class CalendarFragment extends Fragment implements CalendarContract.View {

    private CalendarContract.Presenter calendarPresenter;

    @BindView(R.id.day) EditText day;
    @BindView(R.id.month) EditText month;
    @BindView(R.id.year) EditText year;

    @BindView(R.id.calendar_switch) Switch explanationSwitch;
    @BindView(R.id.textView) TextView textView;

    @OnClick(R.id.button) void handleClick() {
        calendarPresenter.computeWeekDay(MyUtils.getValue(day), MyUtils.getValue(month),
                MyUtils.getValue(year), explanationSwitch.isChecked());
    }

    @OnClick(R.id.calendar_switch) void handleCheckedChange() {
        handleClick();
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
    public void showComputationResult(String result) {
        textView.setText(result);
    }

    @Override
    public void showNonExistingDateError() {
        Snackbar.make(textView, R.string.error_message_date_does_not_exist, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showDateOutOfRangeError() {
        Snackbar.make(textView, R.string.error_message_year_out_of_range, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showImproperValuesPassedError() {
        Snackbar.make(textView, R.string.error_message_inputs_must_contain_numbers, Snackbar.LENGTH_LONG).show();
    }
}
