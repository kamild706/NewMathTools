package pl.t32.newmathtools.ap;


import pl.t32.newmathtools.algorithms.ArithmeticProgression;

public class ArithmeticProgressionPresenter implements ArithmeticProgressionContract.Presenter {

    private ArithmeticProgressionContract.View view;

    ArithmeticProgressionPresenter(ArithmeticProgressionContract.View view) {
        this.view = view;
    }

    @Override
    public void computeSum(String a, String d, String n) {
        try {
            long A = Long.parseLong(a);
            long D = Long.parseLong(d);
            long N = Long.parseLong(n);

            String result = ArithmeticProgression.sum(A, D, N).toString();
            view.showComputationResult(result);
        } catch (NullPointerException | NumberFormatException e) {
            view.showImproperValuesPassedError();
        }
    }

    @Override
    public void computeProduct(String a, String d, String n) {
        try {
            long A = Long.parseLong(a);
            long D = Long.parseLong(d);
            long N = Long.parseLong(n);

            String result = ArithmeticProgression.product(A, D, N).toString();
            view.showComputationResult(result);
        } catch (NullPointerException | NumberFormatException e) {
            view.showImproperValuesPassedError();
        }
    }
}
