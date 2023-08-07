-- CREATE DATABASE transactioncontrol;

CREATE SEQUENCE account_id_sequence START 1;
CREATE SEQUENCE transaction_id_sequence START 1;

CREATE TABLE "account" (
    "account_id" BIGINT NOT NULL DEFAULT nextval('account_id_sequence') PRIMARY KEY,
    "document_number" VARCHAR NOT NULL,
    "account_type" VARCHAR
);

CREATE TABLE "operation_type" (
    "operation_id" BIGINT NOT NULL PRIMARY KEY,
    "description" VARCHAR NOT NULL
);

CREATE TABLE "transaction" (
    "transaction_id" BIGINT NOT NULL DEFAULT nextval('transaction_id_sequence') PRIMARY KEY,
    "account_id" BIGINT NOT NULL,
    "operation_id" BIGINT NOT NULL,
    "amount" DECIMAL NOT NULL,
    "event_date" TIMESTAMP NOT NULL,
    CONSTRAINT "FK_transaction_account" FOREIGN KEY ("account_id") REFERENCES "account" (account_id),
    CONSTRAINT "FK_transaction_operation" FOREIGN KEY ("operation_id") REFERENCES "operation_type" (operation_id)
);

