package pl.t32.newmathtools;


import android.widget.EditText;

public class MyUtils {

    public static String getText(EditText editText) {
        return editText.getText().toString();
    }

    public static int getInt(EditText editText) {
        try {
            return Integer.parseInt(getText(editText));
        } catch (NumberFormatException | NullPointerException e) {
            throw new NumberFormatException();
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
