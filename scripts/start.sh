#!/bin/bash

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`
LOGSDIR="${SCRIPTPATH}/../logs"
PIDPATH="${SCRIPTPATH}/../pid"

mkdir -p ${LOGSDIR}

pushd ${SCRIPTPATH}/../
((java -DFILE_LOGGING_ENABLED="true" -DFILE_LOGGING_PATH="${LOGSDIR}" -jar server.jar &> /dev/null) & echo $! > $PIDPATH &)
popd
