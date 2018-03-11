package pl.t32.newmathtools.nbc;


import pl.t32.newmathtools.algorithms.NumberBaseConverter;
import pl.t32.newmathtools.algorithms.exceptions.NumberBaseConverterBaseException;
import pl.t32.newmathtools.algorithms.exceptions.NumberBaseConverterNumberException;

public class NumberBaseConverterPresenter implements NumberBaseConverterContract.Presenter {

    private NumberBaseConverterContract.View view;

    NumberBaseConverterPresenter(NumberBaseConverterContract.View view) {
        this.view = view;
    }

    @Override
    public void convertToBase(String number, String currentBase, String newBase) {
        try {
            NumberBaseConverter nbc = new NumberBaseConverter(number, Integer.parseInt(currentBase));
            String result = nbc.convertToBase(Integer.parseInt(newBase));
            view.showComputationResult(result);
        }
        catch (NumberFormatException | NumberBaseConverterBaseException e) {
            view.showBaseOutOfRangeError();
        }
        catch (NumberBaseConverterNumberException e) {
            view.showNumberNotInGivenBaseError();
        }
    }
}
