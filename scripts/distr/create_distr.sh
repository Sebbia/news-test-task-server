#!/bin/bash

ARCHIVE_NAME=server.tar.gz

while [[ $# > 0 ]]
do
key="$1"

case $key in
    -t|--type)
    TYPE="$2"
    shift
    ;;
    *)
            # unknown option
    ;;
esac
shift
done

if [ -z "$TYPE" ]; then echo "You must specify distribution type using --type; distribution can be production or stage"; exit 1; fi

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

if [ "$TYPE" == "production" ]
then
	cp ${ROOT}/src/main/resources/application-production.properties ${DISTRPATH}/jar/application.properties
elif [ "$TYPE" == "stage" ]
then
	cp ${ROOT}/src/main/resources/application-stage.properties ${DISTRPATH}/jar/application.properties
else
	exit 1;
fi

cp ${ROOT}/build/libs/server.jar ${DISTRPATH}/jar/
cp ${ROOT}/scripts/*.sh ${DISTRPATH}/scripts/

tar --warning=no-file-changed -zcf ${ARCHIVE_NAME} ${DISTRPATH}
rm -rf ${DISTRPATH}/*
mv ${ARCHIVE_NAME} ${DISTRPATH}
cp ${ROOT}/scripts/distr/install.sh ${DISTRPATH}
