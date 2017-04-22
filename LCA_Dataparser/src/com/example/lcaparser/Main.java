package com.example.lcaparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {
	String dir = "";
	for (String inFilePath : args)
	{
	    File inFile = new File(inFilePath);
	    String outFilePath = inFile.getAbsolutePath().replace(".csv", "") + ".sql";
	    File outFile = new File(outFilePath);
	    dir = inFile.getPath();

	    System.out.println("InputPath: " + inFilePath);
	    System.out.println("OutputPath: " + outFilePath);

	    System.out.println("InputFile: " + inFile.getAbsolutePath());
	    System.out.println("OutputFile: " + outFile.getAbsolutePath());

	    LCAService lcaService = new LCAService();
	    lcaService.parseCSVtoSQL(inFile, outFile);
	}

	List<String> tablecreaton = LCACase.createTABLE();
	File creationFile = new File(dir + "_TableCreation.sql");
	FileOutputStream fos = new FileOutputStream(creationFile);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

	for (String string : tablecreaton)
	{
	    bw.write(string);
	    bw.newLine();
	}

	bw.close();

	System.out.println("############### Finished ##################");

    }

}
