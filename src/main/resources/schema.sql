create table Groups ( group_id int  PRIMARY KEY, name varchar(50) );

create table Students ( student_id int  PRIMARY KEY, 
						first_name varchar(50), last_name varchar(50),
						group_id int,
						FOREIGN KEY (group_id) 
					    REFERENCES Groups(group_id));
					    
create table Subjects (subject_id int PRIMARY KEY, title varchar(50));	

create table Marks (mark_id int PRIMARY KEY,
					date_time date,
					marks int,
					student_id int,
					subject_id int,
					
					FOREIGN KEY (student_id) REFERENCES Students(student_id),
					FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id));

create table subject_teacher(subject_teacher_id int  PRIMARY KEY,
							teacher_id int,
							group_id int,
							subject_id int,
							
							FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id),
							FOREIGN KEY (group_id) REFERENCES Groups(group_id)
							);
							
							






