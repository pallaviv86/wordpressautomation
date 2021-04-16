package org.sample.wordpress.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	
	public String randomstring()
	{
		String gstring=RandomStringUtils.randomAlphabetic(3);
		return gstring;
	}

}
