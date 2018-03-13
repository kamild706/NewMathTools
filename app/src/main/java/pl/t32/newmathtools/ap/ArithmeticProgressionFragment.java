package pl.t32.newmathtools.ap;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.t32.newmathtools.R;

import static pl.t32.newmathtools.MyUtils.getValue;


public class ArithmeticProgressionFragment extends Fragment
        implements ArithmeticProgressionContract.View {

    private ArithmeticProgressionContract.Presenter presenter;

    @BindView(R.id.ap_initial_term) EditText initialTerm;
    @BindView(R.id.ap_common_diff) EditText commonDiff;
    @BindView(R.id.ap_terms_number) EditText termsNumber;

    @BindView(R.id.sumOrProductSwitch) Switch sumOrProduct;
    @BindView(R.id.textView) TextView textView;
    @BindString(R.string.error_message_numbers_only) String messageNumbersOnly;

    @OnClick(R.id.button) void onButtonClick() {
        if (sumOrProduct.isChecked()) {
            presenter.computeProduct(
                    getValue(initialTerm), getValue(commonDiff), getValue(termsNumber));
        } else {
            presenter.computeSum(
                    getValue(initialTerm), getValue(commonDiff), getValue(termsNumber));
        }
    }

    @OnClick(R.id.sumOrProductSwitch) void onSwitchCheckedChange() {
        sumOrProduct.setText(sumOrProduct.isChecked() ? R.string.compute_product : R.string.compute_sum);
        onButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_arithmetic_progression, container, false);
        ButterKnife.bind(this, view);
        presenter = new ArithmeticProgressionPresenter(this);

        return view;
    }

    @Override
    public void showImproperValuesPassedError() {
        Snackbar.make(textView, messageNumbersOnly, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showComputationResult(String result) {
        textView.setText(result);
    }
}
