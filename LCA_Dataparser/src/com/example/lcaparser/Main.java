package com.example.lcaparser;

import java.io.File;
import java.io.IOException;

public class Main
{

    public static void main(String[] args) throws IOException
    {

	if (args.length == 1)
	{
	    File inFile = new File(args[0]);
	    String outFilePath = inFile.getAbsolutePath() + ".sql";
	    File outFile = new File(outFilePath);

	    System.out.println("InputPath: " + args[0]);
	    System.out.println("OutputPath: " + outFilePath);

	    System.out.println("InputFile: " + inFile.getAbsolutePath());
	    System.out.println("OutputFile: " + outFile.getAbsolutePath());

	    LCAService lcaService = new LCAService();
	    lcaService.parseCSVtoSQL(inFile, outFile);
	}
	else
	{
	    System.out.println("Wrong params! Params:" + args.length);
	    System.out.println("Param 1 = INPUTFILE");
	}
    }

}
