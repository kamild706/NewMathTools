package pl.t32.newmathtools.algorithms;

import pl.t32.newmathtools.algorithms.exceptions.*;

public class NumberBaseConverter {
    private final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String number;
    private int base;

    public NumberBaseConverter(String number, int base) throws NumberBaseConverterBaseException {
        validateBase(base);
        this.base = base;
        this.number = number;
    }

    private void validateBase(int base) throws NumberBaseConverterBaseException {
        if (!isInRange(base, 2, this.alphabet.length())) {
            throw new NumberBaseConverterBaseException(
                    "Base is not in supported range from 2 to " + alphabet.length());
        }
    }

    private boolean isInRange(int value, int a, int b) {
        return value >= a && value <= b;
    }

    public String convertToBase(int newBase)
            throws NumberBaseConverterNumberException, NumberBaseConverterBaseException {
        validateBase(newBase);

        String result = toRequestedBase(toDecimalBase(), newBase);
        number = result;
        base = newBase;

        return result;
    }

    private long toDecimalBase() throws NumberBaseConverterNumberException {
        try {
            return Long.parseLong(number, base);
        } catch (NumberFormatException | NullPointerException e) {
            throw new NumberBaseConverterNumberException(
                    String.format("The number is not written in %d based system", this.base));
        }
    }

    private String toRequestedBase(long decimal_representation, int newBase) {
        if (decimal_representation == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (decimal_representation >= 1) {
            sb.append(this.alphabet.charAt((int) (decimal_representation % newBase)));
            decimal_representation /= newBase;
        }

        return sb.reverse().toString();
    }
}
