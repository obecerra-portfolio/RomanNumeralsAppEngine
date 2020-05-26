import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Numerals {
	
	I(1), IV(4), V(5), IX(9), X(10), 
    XL(40), L(50), XC(90), C(100), 
    CD(400), D(500), CM(900), M(1000);
 
    private int convert;
 
    Numerals(int val) {
        convert = val;
    }
 
    public int getNumericValue() {
        return convert;
    }
    
    public static List<Numerals> getListOfRomanNumerals() {
        return Arrays.stream(values())
          .sorted(Comparator.comparing((Numerals e) -> e.convert).reversed())
          .collect(Collectors.toList());
    }

}
