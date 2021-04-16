package org.sample.wordpress.utilities;



import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
//import java.nio.file.Files;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class FileReaderUtil {


	 private static final Logger logger = LogManager.getLogger(FileReaderUtil.class);
	 
	public static File readResourceFile(String resourcePath) {
		
		URL resourceURL = FileReaderUtil.class.getResource(resourcePath);

		File file = null;
		//String fileContent = null;
		try {
			file = new File(resourceURL.toURI());
			
		}
		catch (URISyntaxException uriexception) {
			
			logger.error(uriexception);
		}
		finally {

		}
		return file;
	}

}
