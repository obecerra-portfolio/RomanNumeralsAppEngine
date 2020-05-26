import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {
	
	private Map<String, Integer> validTestMap;
	private Map<String, Integer> invalidTestMap;
	private List<String> invalidCharacterList;
	
	@Before 
	public void initialize() 
	{
		validTestMap = new HashMap<String, Integer> ();
		validTestMap.put("MMXVIII", 2018);
		validTestMap.put("I", 1);
		validTestMap.put("II", 2);
		validTestMap.put("MM", 2000);
		validTestMap.put("MMXI", 2011);
		validTestMap.put("CCVI", 206);
		validTestMap.put("VIII", 8);
		
		invalidTestMap = new HashMap<String, Integer> ();
		// Rule 1 : Only 1 I may precede a V or X
		invalidTestMap.put("IIV", -1);
		invalidTestMap.put("IIX", -1);
		// Rule 2 : Up to 3 I's may be strung together after V or X
		invalidTestMap.put("VIIII", -1);
		invalidTestMap.put("XIIII", -1);
		
		invalidCharacterList = new ArrayList<String> ();
		invalidCharacterList.add(" XI");
		invalidCharacterList.add("X I");
		invalidCharacterList.add("XI ");
		invalidCharacterList.add("X@I");
		invalidCharacterList.add("!XI");
		invalidCharacterList.add("XI*");
	}

	@Test
	public void testValidRomanNumeral()
	{
		System.out.println("------- TEST VALID CASES -------");
		
		validTestMap.forEach((k,v) -> {Assert.assertEquals(RomanNumerals.getInstance().convertRomanNumeral(k), (int)v);
			System.out.println(k + "->" + v + " PASS");});
	}
	
	@Test
	public void testInvalidRomanNumerals()
	{
		System.out.println("------- TEST INVALID CASES -------");
		
		invalidTestMap.forEach((k,v) -> {Assert.assertEquals(RomanNumerals.getInstance().convertRomanNumeral(k), (int)v);
			System.out.println(k + "->" + v + " PASS NEG TEST");});
		
		// Rule 3 : Cannot put I in front of L to be 49 (test that it is not equal to pass)
		String caseOfFortyNine = "LI";
		System.out.println("Converted " + caseOfFortyNine + " " + 
				RomanNumerals.getInstance().convertRomanNumeral(caseOfFortyNine) + "!=" + 49 + " PASS");
		
		Assert.assertNotEquals(RomanNumerals.getInstance().convertRomanNumeral(caseOfFortyNine),49);
		
	}
	
	@Test
	public void testInvalidCharacters()
	{
		System.out.println("------- TEST INVALID CHARACTERS -------");
		
		invalidCharacterList.forEach((e) -> {Assert.assertEquals(RomanNumerals.getInstance().convertRomanNumeral(e), -1);
			System.out.println(e + "->" + " PASS NEG TEST");});
	}
  
}
