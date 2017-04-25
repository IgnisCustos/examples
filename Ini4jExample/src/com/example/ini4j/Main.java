package com.example.ini4j;

import java.io.File;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class Main
{

    public static final String FILENAME = "user.ini";

    public static void main(String[] args) throws Exception
    {

	String filename = (args.length > 0) ? args[0] : FILENAME;
	Ini ini = new Ini(new File(filename));

	Section user = ini.get("user");
	System.out.println("Username: \t" + user.get("name"));
	System.out.println("Userpassword: \t" + user.get("password"));

	Section server = ini.get("server");
	System.out.println("Servername: \t" + server.get("name"));
	System.out.println("Serverpassword:\t" + server.get("password"));

	user.put("name", "newUser");
	ini.store();

    }

}
