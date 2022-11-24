package vTigerGenericLibrary;

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import vTigerGenericLibrary.IConstantsLibrary;

	public class  PropertyFileLibrary {
		

		/**
		 * This class contains generic methods related to property file
		 * @author Chaitra M
		 *
		 */
		/**
			 * This method will read the value from property file for the key given by user
			 * @param key
			 * @return
			 * @throws IOException
			 */
			public String readDataFromPropertyFile(String key) throws IOException
			{
				FileInputStream fis = new FileInputStream(IConstantsLibrary.propertyFilePath);
				Properties pObj = new Properties();
				pObj.load(fis);
				String value = pObj.getProperty(key);
				return value;
				
			}

		}


