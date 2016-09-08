#!/bin/bash

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`
${SCRIPTPATH}/stop.sh
${SCRIPTPATH}/start.sh
