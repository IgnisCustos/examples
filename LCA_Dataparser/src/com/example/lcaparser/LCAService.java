package com.example.lcaparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LCAService
{
    private Map<String, String> declarationRegexMap;
    private Map<Integer, String> declarationLineup;

    public LCAService()
    {
	this.declarationRegexMap = new LCACase("").getDeclarationmap();
    }

    /**
     * Parse a given inFile into LCACase Object and write it to outFile
     * 
     * @param inFile
     * @param outFile
     * @throws IOException
     */
    public void parseCSVtoSQL(File inFile, File outFile) throws IOException
    {
	FileOutputStream fos = new FileOutputStream(outFile);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

	try (BufferedReader br = new BufferedReader(new FileReader(inFile)))
	{
	    String line;
	    int lineNumber = 0;

	    while ((line = br.readLine()) != null)
	    {

		lineNumber++;
		if (lineNumber == 1)
		{
		    declarationLineup = getDeclarationLine(line);
		    System.out.println("");
		    System.out.println("----------------- declarationLineup (Entrys: " + declarationLineup.size() + ") -----------------------");
		    for (Entry<Integer, String> entry : declarationLineup.entrySet())
		    {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    }
		    System.out.println("----------------------------------------");
		}
		else
		{
		    parseCSVLine(bw, line);
		}
	    }
	    System.out.println("");
	    System.out.println("Parsef file: " + inFile.getName());
	    System.out.println("Total parsed lines :'" + lineNumber + "'");

	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    bw.close();
	}
    }

    /**
     * Extract from first CSV Line the position of declared fields and gives it as key,value map back
     * 
     * @param csvLine
     * @return
     */
    private Map<Integer, String> getDeclarationLine(String csvLine)
    {
	Map<Integer, String> declarationLine = new HashMap<Integer, String>();

	String[] values = csvLine.split(";", -1);

	for (int i = 0; i < values.length; i++)
	{
	    String match = matchesUp(values[i]);
	    if (match != null)
		declarationLine.put(i, matchesUp(values[i]).replaceAll("regex", ""));
	}
	return declarationLine;
    }

    /**
     * check with defined regularExpression against given columnName normally the inputline cames from first csv line
     * 
     * @param line
     * @return
     */
    private String matchesUp(String line)
    {
	for (Map.Entry<String, String> entry : declarationRegexMap.entrySet())
	{
	    // String to be scanned to find the pattern.
	    String pattern = entry.getValue();

	    // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);

	    // Now create matcher object.
	    Matcher m = r.matcher(line);
	    if (m.find())
	    {
		return entry.getKey();
	    }

	}

	return null;
    }

    /**
     * BusinessLogic get all values from line and fill it with reflection into provided setter methods from LCACase
     * 
     * @param bw
     * @param csvLine
     * @throws IOException
     */
    private void parseCSVLine(BufferedWriter bw, String csvLine) throws IOException
    {

	String[] values;
	LCACase lca = new LCACase();
	try
	{
	    values = csvLine.split(";", -1);
	    for (int i = 0; i < values.length; i++)
	    {
		String declaredField = declarationLineup.get(i);
		if (declaredField != null)
		{
		    Method method = lca.getClass().getMethod("set" + declaredField, String.class);
		    if (method.isAnnotationPresent(LCASetter.class))
		    {
			method.invoke(lca, values[i]);
		    }
		    else
		    {
			throw new IllegalAccessError("The Method you're trying to reach isn't proberly correct annotated");
		    }
		}
	    }
	}
	catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
	{
	    e.printStackTrace();
	}
	bw.write(lca.toString());
	bw.newLine();
    }

}
