#!/bin/bash

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`
PIDPATH="${SCRIPTPATH}/../pid"

PID=`cat $PIDPATH`
if ps -p $PID > /dev/null
then
   echo "Server is running with pid $PID "
   exit 0
else
   echo 'Server is NOT running'
   exit 1
fi
