package com.example.lcaparser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.example.annotation.LCA;
import com.example.annotation.LCARegex;

/**
 * Three Values are chained thogether NAME of VARIABLE annotated with LAC.class (position,type)
 * 
 * NAME of REGEX-Variable annotated wit LCARegex.class
 * 
 * NAME of SETTER for VARIABLE annotated wit LCASetter.class
 * 
 * @author Ignis
 *
 */
public class LCACase extends LCAFields
{

    final static Logger LOG = Logger.getLogger(LCACase.class);
    private Map<String, String> declarationRegexMap;

    public LCACase()
    {
    }

    public LCACase(String forInit)
    {
	this.declarationRegexMap = setDeclarationRegexMap();
	LOG.debug("");
	LOG.debug("------------------- declarationMap (Entrys: " + declarationRegexMap.size() + ") ---------------------");
	for (Map.Entry<String, String> entry : declarationRegexMap.entrySet())
	{
	    LOG.debug("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}
	LOG.debug("----------------------------------------");

    }

    /**
     * get all main-fields that should be declared in CSVFile too
     * 
     * @return
     */
    private Map<String, String> setDeclarationRegexMap()
    {
	Map<String, String> declarationMap = new HashMap<String, String>();
	try
	{
	    Field[] fields = LCAFields.class.getDeclaredFields();
	    for (Field field : fields)
	    {
		if (Modifier.isPrivate(field.getModifiers()) && field.isAnnotationPresent(LCARegex.class))
		{
		    field.setAccessible(true);
		    String value = (String) field.get(this);
		    declarationMap.put(field.getName(), value);
		}
	    }
	}
	catch (SecurityException | IllegalArgumentException | IllegalAccessException e)
	{
	    e.printStackTrace();
	}
	return declarationMap;
    }

    public Map<String, String> getDeclarationRegexMap()
    {
	return declarationRegexMap;
    }

    public void setDeclarationMap(Map<String, String> declarationRegexMap)
    {
	this.declarationRegexMap = declarationRegexMap;
    }

    @Override
    public String toString()
    {
	return buildINSERT();
    }

    /**
     * Returns a full sql query for creating needed INSERT INTO in String Build based on reflection
     * 
     * @return
     */
    private String buildINSERT()
    {
	Map<Integer, Field> databaseFields = new LinkedHashMap<>();
	List<String> createTableQuery = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	sb.append("INSERT INTO lca VALUES(");
	createTableQuery.add("INSERT INTO lca VALUES(");

	Field[] fields = LCAFields.class.getDeclaredFields();
	for (Field field : fields)
	{
	    if (Modifier.isPrivate(field.getModifiers()) && field.isAnnotationPresent(LCA.class))
	    {
		field.setAccessible(true);
		databaseFields.put(field.getAnnotation(LCA.class).pos(), field);
	    }
	}

	for (int i = 1; i <= databaseFields.size(); i++)
	{
	    try
	    {
		Field field = databaseFields.get(i);
		switch (field.getAnnotation(LCA.class).type())
		{
		    case "VARCHAR(100)":
			sb.append(inputValidationStr((String) field.get(this)));
			break;
		    case "DATE":
			sb.append(inputValidationDate((String) field.get(this)));
			break;
		    case "NUMERIC":
			sb.append(inputValidationNumeric((String) field.get(this)));
			break;
		    default:
			throw new IllegalArgumentException("Your DataType isn't supported yet");

		}
		sb.append((i < databaseFields.size() ? "," : ""));
	    }
	    catch (IllegalArgumentException | IllegalAccessException e)
	    {
		e.printStackTrace();
	    }

	}
	sb.append(");");
	return sb.toString();
    }

    /**
     * Returns a full sql statement for creating needed table in String-List for better formatting Build based on reflection
     * 
     * @return
     */
    public static List<String> createTABLE()
    {
	List<String> createTableQuery = new ArrayList<>();
	createTableQuery.add("DROP TABLE IF EXISTS lca;");
	createTableQuery.add("CREATE TABLE lca(");

	Map<Integer, Field> databaseFields = new LinkedHashMap<>();

	Field[] fields = LCAFields.class.getDeclaredFields();
	for (Field field : fields)
	{
	    if (Modifier.isPrivate(field.getModifiers()) && field.isAnnotationPresent(LCA.class))
	    {
		databaseFields.put(field.getAnnotation(LCA.class).pos(), field);
	    }
	}

	for (int i = 1; i <= databaseFields.size(); i++)
	{
	    Field field = databaseFields.get(i);
	    createTableQuery.add(field.getName() + " " + field.getAnnotation(LCA.class).type() + (i < databaseFields.size() ? "," : ""));
	}
	createTableQuery.add(");");

	return createTableQuery;
    }

    private String inputValidationStr(String inserValue)
    {
	if (inserValue != null)
	{
	    inserValue = "'" + inserValue.replace("'", "''") + "'";
	}
	else
	{
	    inserValue = "null";
	}
	return inserValue;
    }

    private String inputValidationDate(String dateStr)
    {
	SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateParser(dateStr);

	if (date == null)
	    return "null";
	dateStr = sdfOutput.format(date);
	return "'" + dateStr + "'";

    }

    private String inputValidationNumeric(String floatStr)
    {
	if (floatStr != null)
	{
	    try
	    {
		Double.parseDouble(floatStr);
	    }
	    catch (NumberFormatException e)
	    {
		floatStr = "null";
	    }

	}
	else
	{
	    floatStr = "null";
	}
	return floatStr;
    }

    /**
     * try to parse a given string that is properly a date into a Date
     * 
     * @param candidate
     * @return
     */
    private Date dateParser(String candidate)
    {
	if (candidate == null)
	    return null;
	List<SimpleDateFormat> knownPatterns = new ArrayList<SimpleDateFormat>();
	knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));
	knownPatterns.add(new SimpleDateFormat("dd/MM/yyyy"));
	knownPatterns.add(new SimpleDateFormat("dd.MM.yyyy"));

	for (SimpleDateFormat pattern : knownPatterns)
	{
	    try
	    {
		return new Date(pattern.parse(candidate).getTime());
	    }
	    catch (ParseException pe)
	    {
		// dateParser(candidate);
	    }
	}
	return null;
    }
}
