CREATE database productserviceapr;

CREATE user productserviecesuser identified by 'password';

Grant all on productserviceapr to productserviecesuser;

Grant all privileges on productserviceapr to productserviecesuser;

GRANT ALL PRIVILEGES ON productserviceapr.* TO 'productserviceapruser'@'%';

SHOW GRANTS FOR 'productserviceapruser';
