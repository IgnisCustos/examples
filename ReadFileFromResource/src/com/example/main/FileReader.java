package com.example.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader
{

    /**
     * Read given filename from the resources folder
     * @param fileName
     * @throws IOException
     */
    public String readFileAsString(String fileName) throws IOException
    {
	FileInputStream inputStream = null;
	String fileAsString = "";

	try
	{
	    // Getting ClassLoader obj
	    ClassLoader classLoader = this.getClass().getClassLoader();
	    // Getting resource(File) from class loader
	    File configFile = new File(classLoader.getResource(fileName).getFile());

	    inputStream = new FileInputStream(configFile);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
		fileAsString = fileAsString +" "+line;
	    }

	    reader.close();

	}
	catch (FileNotFoundException e)
	{

	    e.printStackTrace();
	}
	catch (IOException e)
	{

	    e.printStackTrace();
	}
	finally
	{
	    
	    inputStream.close();
	}
	return fileAsString;
    }

}
