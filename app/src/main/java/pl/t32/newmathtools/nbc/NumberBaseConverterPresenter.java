package pl.t32.newmathtools.nbc;


import pl.t32.newmathtools.algorithms.NumberBaseConverter;
import pl.t32.newmathtools.algorithms.exceptions.BaseRangeException;
import pl.t32.newmathtools.algorithms.exceptions.NumberNotInBaseException;

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
        catch (NumberFormatException | BaseRangeException e) {
            view.showBaseOutOfRangeError();
        }
        catch (NumberNotInBaseException e) {
            view.showNumberNotInGivenBaseError();
        }
    }
}
