#!/bin/bash

ARCHIVE_NAME=server.tar.gz
INSTALL_DIR=/usr/local/template/
DISTR_DIR=${INSTALL_DIR}/distr

set -e
set -o xtrace

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`

echo "This program will now install server..."

echo "Checking if postgres is running..."
if su - postgres -c '/usr/local/pgsql/bin/pg_ctl status -D /usr/local/pgsql/data' | grep 'server is running'; then
        #database server is running
        echo "Postgres is running"
else
        #database server is not running
        echo "Postgres server is NOT running, aborting..."
        exit 1
fi

echo "Extracting files"
mkdir -p ${INSTALL_DIR}
cp ${SCRIPTPATH}/${ARCHIVE_NAME} ${INSTALL_DIR}
pushd ${INSTALL_DIR}
tar xfz ${ARCHIVE_NAME}

echo "Restarting the server"
set +e
./scripts/stop.sh

rm server.jar
rm -rf scripts
set -e
cp ./distr/jar/server.jar .
cp -r ./distr/scripts .

./scripts/start.sh

echo "Removing unused files"
rm -rf distr
rm ${ARCHIVE_NAME}

popd
