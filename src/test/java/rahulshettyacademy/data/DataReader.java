package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
// utility file to read data from json
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		// reading json to String
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json")
				,StandardCharsets.UTF_8);
				
		// convert String to HashMap-- Jackson DataBind
		// The ObjectMapper class has a method readValue to convert String to HashMap
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
			});
			
		// so the object data stores 2 hashmaps -- 1st hashmap containing 1st set of data and 2nd containing 2nd set of data
		return data;
	}
}
