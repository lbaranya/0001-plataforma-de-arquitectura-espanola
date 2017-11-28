#!/bin/sh
#DIB: backupAndClean.sh v1.0
DEPLOYDIR=/opt/magnoliaAuthor/webapps/magnoliaAuthor/WEB-INF/lib
FECHA=`date +"%Y%m%d%H%M%S"`
cp -R $DEPLOYDIR $DEPLOYDIR.$FECHA
chown -R tomcat8:tomcat8 $DEPLOYDIR.$FECHA
find $DEPLOYDIR -type f -name "caar-*" -delete
