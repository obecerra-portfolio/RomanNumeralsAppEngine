import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet(
    name = "Converter",
    urlPatterns = {"/converter"}
)
public class Converter extends HttpServlet {
	
	private Gson gson;
	
	

  /**
	 * Get Method to convert Roman numeral
	 */
	private static final long serialVersionUID = -6653385112012420662L;
	
	public Converter()
	{
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

@Override
  	public void doGet(HttpServletRequest request, HttpServletResponse response) 
  			throws IOException 
	{

    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	
    	List <ResponseView> responseList = new ArrayList <ResponseView> ();
    	String [] romanNumerals = new String [10];
    	
    	if(!request.getParameter("romanNumerals").isEmpty())
    		romanNumerals = request.getParameter("romanNumerals").split(",");
    	
    	for(String numeral : romanNumerals)
    	{
    		ResponseView responseView = new ResponseView();
    		responseView.setConverted(RomanNumerals.getInstance().
    				convertRomanNumeral(numeral));
    		responseView.setRomanNumeral(numeral);
    		responseList.add(responseView);
    	}
    
    	
    	response.getWriter().print(gson.toJson(responseList));
    	response.getWriter().flush();
	}
}