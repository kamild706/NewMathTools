package pl.t32.newmathtools.nbc;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.t32.newmathtools.R;

import static pl.t32.newmathtools.MyUtils.getValue;

public class NumberBaseConverterFragment extends Fragment
        implements NumberBaseConverterContract.View {

    NumberBaseConverterContract.Presenter presenter;

    @BindView(R.id.nbc_number) EditText number;
    @BindView(R.id.nbc_base) EditText base;
    @BindView(R.id.nbc_new_base) EditText newBase;

    @BindView(R.id.textView) TextView textView;
    @BindString(R.string.error_message_number_wrong_base) String messageNumberWrongBase;
    @BindString(R.string.error_message_base_range) String messageBaseRange;

    @OnClick(R.id.button) void handleClick() {
        presenter.convertToBase(getValue(number), getValue(base), getValue(newBase));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_base_converter, container, false);
        ButterKnife.bind(this, view);
        presenter = new NumberBaseConverterPresenter(this);
        return view;
    }

    @Override
    public void showComputationResult(String result) {
        textView.setText(result);
    }

    @Override
    public void showNumberNotInGivenBaseError() {
        Snackbar.make(
                textView, messageNumberWrongBase, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showBaseOutOfRangeError() {
        Snackbar.make(textView, messageBaseRange, Snackbar.LENGTH_LONG).show();
    }
}
