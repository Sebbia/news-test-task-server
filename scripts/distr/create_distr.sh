#!/bin/bash

ARCHIVE_NAME=server.tar.gz

set -e
set -o xtrace

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`
ROOT="${SCRIPTPATH}/../../"
DISTR="distr"
DISTRPATH="${ROOT}/${DISTR}"

echo "Creating server distribution package..."

rm -rf ${DISTRPATH}

mkdir -p ${DISTRPATH}
mkdir -p ${DISTRPATH}/jar
mkdir -p ${DISTRPATH}/scripts

cp ${ROOT}/build/libs/server.jar ${DISTRPATH}/jar/
cp ${ROOT}/scripts/*.sh ${DISTRPATH}/scripts/

tar -zcf ${DISTRPATH}/${ARCHIVE_NAME} ${DISTRPATH}
