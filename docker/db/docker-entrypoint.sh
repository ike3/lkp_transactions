#!/bin/bash

for f in /docker-entrypoint-initdb.d/*; do
    case "$f" in
        *.sh)     echo "[IMPORT] $0: running $f"; . "$f" ;;
        *.sql)    echo "[IMPORT] $0: running $f"; echo "exit" | su oracle -c "NLS_LANG=.$CHARACTER_SET /u01/app/oracle/product/12.1.0/xe/bin/sqlplus -S / as sysdba @$f"; echo ;;
        *)        echo "[IMPORT] $0: ignoring $f" ;;
    esac
    echo
done