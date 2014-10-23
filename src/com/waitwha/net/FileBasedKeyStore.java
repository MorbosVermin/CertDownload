package com.waitwha.net;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

import com.waitwha.logging.LogManager;

public class FileBasedKeyStore extends KeyStore {
	
	private String path;
	
	public FileBasedKeyStore(File file, char[] password)  {
		
		if(! file.exists())
			throw new RuntimeException("KeyStore file "+ file +" must actually exist.");
		
		this.path = file.toString();
		this.password = password;
		
		FileInputStream fis = null;
		try {
			this.keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
			fis = new FileInputStream(file);
			this.keyStore.load(fis, password);
			log.fine("Loaded KeyStore "+ file +" successfully.");
			
		}catch (Exception e) {
			//TODO -- this needs to be cleaned up.
			log.warning("Could not open/read from KeyStore "+ file +": "+ e.getMessage());
			throw new RuntimeException("Could not open/read from the KeyStore "+ file +": "+ e.getMessage());
		
		}finally{
			if(fis != null)  {
				try  {
					fis.close();
				}catch(Exception e) {}
			}
		}
	}
	
	public String getPath()  {
		return path;
	}
	
	public FileBasedKeyStore(String filename, char[] password)  {
		this(new File(filename), password);
	}
	
}