Create schema odd_demo;

Create table STUDENTS(stuid INT Primary key,
					name varchar(300) Not Null,
                    phone varchar(255),
                    dateofBirth Date,
                    enrollmentDate Timestamp Default current_timestamp
			);
            
            
            
            
Alter Table students modify column name varchar(); 


Insert into students(stuid,name,phone,dateofBirth) values (1,'omkar','1112',current_date());

Insert into students(stuid,name,phone,dateofBirth,enrollmentDate) values (2,'omkar','1112',current_date(),null);
Insert into students(stuid,name,phone,dateofBirth,enrollmentDate) values (3,'omkar','1112',current_date(),default);



select * from students;

SELECT * FROM STUDENTS;

SELECT 'hELLO WORLD'+'OMKAR ' FROM DUAL;


SELECT @@sql_mode;

commit;