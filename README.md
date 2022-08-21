# spring-boot-todo-hei
Just a simple assignement to understand how everything works in basic Spring boot fashion.

Students will be told what to do in class. 

# Store userDetails in Database using JdbcUserDetailsManager

- JdbcUserDetailsManager provides a database model, which is saved in the following location:
	``` org/springframework/security/core/userdetails/jdbc/users.ddl
- There is a data type varchar in the script_ Ignorecase, you just have to change into varchar and excute the script using psql or pgAmdin
- Finally , go to the security configuration of this project and set yours like mine x)
	``` src\main\java\com\example\springsecuritydemo\security
