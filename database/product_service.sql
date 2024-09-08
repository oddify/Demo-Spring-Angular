create database product_service;
create user product_service_user;
grant all on product_service to product_service_user;
ALTER USER product_service_user IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON product_service TO 'product_service_user';
GRANT ALL PRIVILEGES ON product_service.* TO 'product_service_user'@'%';
SHOW GRANTS FOR 'product_service_user';
