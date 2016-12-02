package employee;

import java.util.List;

public class Service {

    String[] databaseString = new String[]{"apple","ball","cat","doll","elephant",
            "fight","georgeous","height","ice","jug",
             "aplogize","bank","call","done","ego",
             "finger","giant","hollow","internet","jumbo",
             "kilo","lion","for","length","primary","stage",
             "scene","zoo","jumble","auto","text",
            "root","box","items","hip-hop","himalaya","nepal",
            "kathmandu","kirtipur","everest","buddha","epic","hotel"};

	
    public List<String> getSuggestions(String fieldName, String searchString) {
        List<String> list = null;
        
        for (String string : databaseString) {
			if (string.contains(searchString)){
				list.add(string);
			}
		}
 
       return list;
 
    } 
}
