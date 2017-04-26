package com.example.lcaparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.log4j.Logger;

public class Starter
{
    private String dir = "";
    final static Logger LOG = Logger.getLogger(Starter.class);

    public static void main(String[] args) throws IOException
    {
	if (args.length >= 1)
	{
	    Starter main = new Starter();
	    main.init(args);
	}
	else
	{
	    LOG.info("Usage: FilePath [String fullFilePath...]");
	}

    }

    private void init(String[] args) throws IOException
    {
	for (String inFilePath : args)
	{
	    System.out.println("############### START ###############");
	    File inFile = new File(inFilePath);
	    String outFilePath = inFile.getAbsolutePath().replace(".csv", "") + ".sql";
	    File outFile = new File(outFilePath);

	    String dirPath = inFile.getAbsolutePath();
	    dir = dirPath.substring(0, dirPath.lastIndexOf(File.separator)) + "\\";

	    System.out.println("InputFile: " + inFile.getAbsolutePath());
	    System.out.println("OutputFile: " + outFile.getAbsolutePath());
	    System.out.println("Directory: " + dir);

	    LCAService lcaService = new LCAService();
	    lcaService.parseCSVtoSQL(inFile, outFile);
	}

	List<String> tablecreaton = LCACase.createTABLE();
	File creationFile = new File(dir + "LCA_TableCreation.sql");
	FileOutputStream fos = new FileOutputStream(creationFile);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

	for (String string : tablecreaton)
	{
	    bw.write(string);
	    bw.newLine();
	}

	bw.close();

	System.out.println("############### FINISH ###############");
    }
}