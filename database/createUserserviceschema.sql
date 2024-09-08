CREATE database userserviceapr;

CREATE user userserviecesuser identified by 'password';

Grant all on userserviceapr to userserviecesuser;

Grant all privileges on userserviceapr to userserviecesuser;

GRANT ALL PRIVILEGES ON userserviceapr.* TO 'userserviceapruser'@'%';

SHOW GRANTS FOR 'userserviceapruser';
