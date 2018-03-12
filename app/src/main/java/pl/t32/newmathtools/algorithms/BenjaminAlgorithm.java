package pl.t32.newmathtools.algorithms;


import pl.t32.newmathtools.algorithms.exceptions.DateOutOfRangeException;
import pl.t32.newmathtools.algorithms.exceptions.InvalidDateException;

public class BenjaminAlgorithm {

    private int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] monthOffset = new int[]{6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    private int[] centuryOffset = new int[]{0, 5, 3, 1};

    private int day;
    private int month;
    private int year;

    public BenjaminAlgorithm(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public BenjaminAlgorithmResult calculateSteps()
            throws InvalidDateException, DateOutOfRangeException {
        if (year < 1560)
            throw new DateOutOfRangeException();
        if (!isDateValid())
            throw new InvalidDateException();

        if (isYearLeap()) {
            monthOffset[0] = 5;
            monthOffset[1] = 1;
        }

        BenjaminAlgorithmResult results = new BenjaminAlgorithmResult();
        results.day = day;
        results.month = month;
        results.year = year;
        results.dayMod7 = day % 7;
        results.monthOffset = monthOffset[month - 1];
        results.yearMod7 = year % 100 % 7;
        results.yearDiv4 = (int) Math.floor(year % 100 / 4);
        results.centuryOffset = centuryOffset[year / 100 % 4];

        return results;
    }

    @SuppressWarnings({"RedundantIfStatement"})
    private boolean isDateValid() {
        if (day < 1 || day > 31 || year < 1560) return false;
        if (month < 1 || month > 12) return false;
        if (month == 2 && isYearLeap() && day > 29) return false;
        if (month == 2 && !isYearLeap() && day > 28) return false;
        if (month != 2 && day > daysInMonth[month - 1]) return false;

        return true;
    }

    private boolean isYearLeap() {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
