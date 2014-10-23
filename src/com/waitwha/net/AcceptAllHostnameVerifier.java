package com.waitwha.net;

import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import com.waitwha.logging.LogManager;

/**
 * <b>Security Awareness Course</b><br />
 * Copyright &copy;2010 NCDC, NESDIS, NOAA, US DoC.<p />
 *
 * TODO: Comment this class/interface.
 *
 * @author mduncan
 * @version $Id$
 * @package	gov.noaa.ncdc.isso.net
 */
public class AcceptAllHostnameVerifier 
	implements HostnameVerifier {

	private static final Logger log = 
		LogManager.getLogger(AcceptAllHostnameVerifier.class);
	
	/**
	 * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String, javax.net.ssl.SSLSession)
	 */
	@Override
	public boolean verify(String hostname, SSLSession session) {
		log.fine(this.getClass().getName() +".verify(): Verified (without check) hostname "+ hostname +" for peer host "+ session.getPeerHost());
		return true;
	}

}
