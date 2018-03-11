package pl.t32.newmathtools.nbc;


public interface NumberBaseConverterContract {

    interface View {
        void showComputationResult(String result);
        void showNumberNotInGivenBaseError();
        void showBaseOutOfRangeError();
    }

    interface Presenter {
        void convertToBase(String number, String currentBase, String newBase);
    }
}
