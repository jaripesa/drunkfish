#!/bin/sh

mvn clean package
echo scp -p target/df.war medios.fi:/usr/local/tomcat/webapps
scp -p target/df.war medios.fi:/usr/local/tomcat/webapps
