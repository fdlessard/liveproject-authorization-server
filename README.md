# liveproject-authorization-server

/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/keytool -genkeypair -alias lpas -keyalg RSA -keypass password -keystore keystore.jks -storepass password

keytool -list -rfc --keystore keystore.jks | openssl x509 -inform pem -pubkey



curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read"

