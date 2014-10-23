package com.waitwha.net;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class InMemoryKeyStore extends KeyStore {
	
	public InMemoryKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException  {
		this.keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
		this.password = new char[] { '\0' };
		this.keyStore.load(null, this.password);
		log.fine("Loaded in-memory keystore successfully.");
	}

}
