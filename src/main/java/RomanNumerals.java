import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {
	
	private static RomanNumerals R = null;
	
	private RomanNumerals() {}
	
	public static RomanNumerals getInstance() 
    { 
        if (R == null) 
            R = new RomanNumerals(); 
  
        return R; 
    }
	
	public int convertRomanNumeral(String input) {
	    String romanNumeral = input.toUpperCase();
	    int result = 0;
	    int count = 0;
	    
	    if(!isValidRomanNumeral(input))
	    	return -1;
	         
	    List<Numerals> romanNumerals = Numerals.getListOfRomanNumerals();
	 
	    while ((romanNumeral.length() > 0) && (count < romanNumerals.size())) 
	    {
	        Numerals symbol = romanNumerals.get(count);
	        if (romanNumeral.startsWith(symbol.name())) 
	        {
	            result += symbol.getNumericValue();
	            romanNumeral = romanNumeral.substring(symbol.name().length());
	        } else 
	        {
	            count++;
	        }
	    }
	    
	    
	 
	    if (romanNumeral.length() > 0) 
	    {
	        return -1;
	    }
	 
	    return result;
	}
	
	private boolean isValidRomanNumeral(String rn)
	{
		String regex = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rn);
		if(matcher.find())
			return true;
		
		return false;
		
		
	}

}
