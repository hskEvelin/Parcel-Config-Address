#!/bin/bash

#change load balance config
sftp -oPort=2223 vagrant@127.0.0.1 <<< $'put haproxy.cfg /etc/haproxy/'
ssh -p 2223 vagrant@127.0.0.1 'sudo /etc/init.d/haproxy reload'


. versions
#upload new image to repository
if [ -z ${parcelconfigaddress} ]; 
then
	echo "parcelconfigaddress is unset";
	echo "parcelconfigaddress="$1>>versions
else
	sed -i 's/^parcelconfigaddress=.*/parcelconfigaddress='$1'/g' versions
fi

sftp -oPort=2200 vagrant@127.0.0.1 <<< $'put parcelconfig-address repository/images/'
sftp -oPort=2200 vagrant@127.0.0.1 <<< $'put versions repository/images/'