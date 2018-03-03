package pl.t32.newmathtools.calendar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import pl.t32.newmathtools.MyUtils;
import pl.t32.newmathtools.R;


public class CalendarFragment extends Fragment implements CalendarContract.View {

    private EditText day;
    private EditText month;
    private EditText year;

    private TextView textView;

    private CalendarContract.Presenter calendarPresenter = new CalendarPresenter(this);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        day = rootView.findViewById(R.id.day);
        month = rootView.findViewById(R.id.month);
        year = rootView.findViewById(R.id.year);
        textView = rootView.findViewById(R.id.textView);


        final Button button = rootView.findViewById(R.id.button);
        final Switch explanationSwitch = rootView.findViewById(R.id.calendar_switch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (explanationSwitch.isChecked()) {
                        calendarPresenter.computeExplanationOfWeekDay(MyUtils.getInt(day),
                                MyUtils.getInt(month), MyUtils.getInt(year));
                    } else {
                        calendarPresenter.computeWeekDay(MyUtils.getInt(day), MyUtils.getInt(month),
                                MyUtils.getInt(year));
                    }
                } catch (NumberFormatException e) {
                    Snackbar.make(textView, "Given value is fucked up", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        explanationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                button.performClick();
            }
        });

        return rootView;
    }

    @Override
    public void showComputationResult(String result) {
        textView.setText(result);
    }

    @Override
    public void showNonExistingDateError() {
        Snackbar.make(textView, R.string.date_does_not_exist, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showDateOutOfRangeError() {
        Snackbar.make(textView, R.string.year_out_of_range, Snackbar.LENGTH_LONG).show();
    }
}
