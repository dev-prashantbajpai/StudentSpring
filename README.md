specified key was specified key was too long max key length is 1000 bytes spring jpatoo long max key length is 1000 bytes spring jpa
# you migh need to execute below command for the errors at your mysql
-- ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
SET GLOBAL default_storage_engine = 'InnoDB';
SET @@global.innodb_large_prefix = 1;

