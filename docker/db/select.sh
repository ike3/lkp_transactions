#/bin/bash
export ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe

export PATH=$PATH:$ORACLE_HOME/bin  
export LD_LIBRARY_PATH=$ORACLE_HOME/lib  
export TNS_ADMIN=$ORACLE_HOME/network/admin

printf "SET HEADING OFF\n select * from OPERATION_JOURNAL;" | sqlplus -s ZAKUPKI_DEV/ZAKUPKI_DEV@localhost:1521/XE
