package pl.t32.newmathtools.algorithms;

public class BenjaminAlgorithmResult {
    int day;
    int month;
    int year;
    int dayMod7;
    int monthOffset;
    int yearMod7;
    int yearDiv4;
    int centuryOffset;
    String monthName;

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getYearMod100() {
        return year % 100;
    }

    public int getDayMod7() {
        return dayMod7;
    }

    public int getMonthOffset() {
        return monthOffset;
    }

    public int getYearMod7() {
        return yearMod7;
    }

    public int getYearDiv4() {
        return yearDiv4;
    }

    public int getCenturyOffset() {
        return centuryOffset;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int sumOfComponents() {
        return dayMod7 + monthOffset + yearMod7 + yearDiv4 + centuryOffset;
    }

    public int sumOfComponentsMod7() {
        return sumOfComponents() % 7;
    }
}