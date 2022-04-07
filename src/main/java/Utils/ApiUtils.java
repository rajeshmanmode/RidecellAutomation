package Utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

public Map<String,String> getAPIResponse() {


Response response = RestAssured.get("https://api.github.com/orgs/django/repos");

Map<String,String> m = new HashMap();

   String responsejson = response.getBody().prettyPrint();
   JSONArray array = new JSONArray(responsejson);  
   for(int i=0; i < array.length(); i++)  
   {  
   JSONObject object = array.getJSONObject(i);  
   
   if(object.get("description") == JSONObject.NULL) {
   m.put(object.getString("name"),"");
   }
   else {
    m.put(object.getString("name"),object.getString("description"));
   }

}
return m;

}}

