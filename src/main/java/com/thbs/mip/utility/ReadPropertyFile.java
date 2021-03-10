package com.thbs.mip.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertyFile {

	public static Properties property()
	{
		Properties prop = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Applicationconfig.properties");
            prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void main(String[] args)
	{
		Properties p=property();
		String myurl=p.getProperty("BaseURI");
		System.out.println(myurl);
		
	}

}
