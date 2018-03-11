package pl.t32.newmathtools.ap;


public interface ArithmeticProgressionContract {

    interface View {
        void showImproperValuesPassedError();
        void showComputationResult(String result);
    }

    interface Presenter {
        void computeSum(String a, String d, String n);
        void computeProduct(String a, String d, String n);
    }
}
