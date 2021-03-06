CREATE USER ZAKUPKI_DEV identified by ZAKUPKI_DEV DEFAULT TABLESPACE USERS;
GRANT RESOURCE, CONNECT TO ZAKUPKI_DEV;

CREATE TABLE "ZAKUPKI_DEV"."OPERATION_JOURNAL" 
(
    "OP_JOURNAL_ID" NUMBER(20,0) NOT NULL ENABLE, 
	"EVENT_NAME" VARCHAR2(2000 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "PK_OP_JOURNAL" PRIMARY KEY ("OP_JOURNAL_ID")
);

GRANT SELECT, INSERT, UPDATE, DELETE ON ZAKUPKI_DEV.OPERATION_JOURNAL TO ZAKUPKI_DEV;

CREATE SEQUENCE ZAKUPKI_DEV.SEQ_OPERATION_JOURNAL;

GRANT SELECT ON ZAKUPKI_DEV.SEQ_OPERATION_JOURNAL TO ZAKUPKI_DEV;