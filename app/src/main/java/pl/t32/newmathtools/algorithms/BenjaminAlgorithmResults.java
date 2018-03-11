package pl.t32.newmathtools.algorithms;

public class BenjaminAlgorithmResults {
    int dayMod7;
    int monthOffset;
    int yearMod7;
    int yearDiv4;
    int centuryOffset;

    public int getSumOfAll() {
        return dayMod7 + monthOffset + yearMod7 + yearDiv4 + centuryOffset;
    }
}