package com.waitwha.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.net.ssl.X509TrustManager;

import com.waitwha.logging.LogManager;

/**
 * <b>Security Awareness Course</b><br />
 * Copyright &copy;2010 NCDC, NESDIS, NOAA, US DoC.<p />
 *
 * A TrustManager implementation which will keep track of certificates 
 * downloaded and accept all connections.
 *
 * @author mduncan
 * @version $Id$
 * @package	gov.noaa.ncdc.isso.common.net.ssl
 */
public class AcceptAllX509TrustManager 
	implements X509TrustManager {
	
	private static final Logger log = 
		LogManager.getLogger(AcceptAllX509TrustManager.class);

	private ArrayList<X509Certificate> issuers;
	
	public AcceptAllX509TrustManager()  {
		super();
		this.issuers = new ArrayList<X509Certificate>();
	}
	
	/**
	 * @return the issuers
	 */
	public ArrayList<X509Certificate> getIssuers() {
		return issuers;
	}
	
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
		for(X509Certificate cert : chain)  {
			log.fine("Downloaded/Saved "+ authType +" certificate: "+ cert.getSubjectDN());
			this.issuers.add(cert);
		}
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
		for(X509Certificate cert : chain)  {
			log.fine("Downloaded/Saved "+ authType +" certificate: "+ cert.getSubjectDN());
			this.issuers.add(cert);
		}
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		X509Certificate[] ret = new X509Certificate[this.issuers.size()];
		issuers.toArray(ret);
		return ret;
	}
	
}
