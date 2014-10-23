CertDownload
========

A simple Java-based utility to download TLS/SSL certificates from servers. 

Usage
----

	C:\> java -jar certdl.jar  www.google.com:443
	Connecting to www.google.com:443; please wait...
	Connection to www.google.com:443 completed successfully.
	Retrieved 3 certificate(s) from server.

	C:\> dir *.cer
	
	Directory: C:\
	
	Mode                LastWriteTime     Length Name
	----                -------------     ------ ----
	-a---        10/22/2014  11:55 PM        897 CN=GeoTrust Global CA, O=GeoTrust Inc., C=US.cer
	-a---        10/22/2014  11:55 PM       1012 CN=Google Internet Authority G2, O=Google Inc, C=US.cer
	-a---        10/22/2014  11:55 PM       1146 CN=www.google.com, O=Google Inc, L=Mountain View, ST=California, C=US.cer

