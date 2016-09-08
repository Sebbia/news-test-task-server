#!/bin/bash

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`
PIDPATH="${SCRIPTPATH}/../pid"

set -e
PID=`cat $PIDPATH`
set +e

for i in {1..60}
do
    if kill -s TERM ${PID} &> /dev/null
    then
        sleep 1
    else
        echo "Server was stopped gracefully"
        exit 0
    fi
done
kill -9 ${PID}
echo "Server didn't respond and was killed"
exit 0
