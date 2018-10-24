create table studentsPR (region_st STRING, district_st STRING, school_id_st INT, school_name_st STRING, school_lvl_st STRING, sex_st CHAR(1), st_id INT)
row format delimited
fields terminated by ',';


load data local inpath "/home/julian_cuevas1/BigDataExam1/hive/studentsPR.csv" into table studentsPR;

create table schoolsPR (region_sch STRING, district_sch STRING, city STRING, school_id INT, school_name STRING, school_lvl STRING, num_serie INT)
row format delimited
fields terminated by ',';

load data local inpath "/home/julian_cuevas1/BigDataExam1/hive/escuelasPR.csv" into table schoolsPR;

--- Exercise 1

select region_sch, city, count(*)
from schoolsPR, studentsPR
where schoolsPR.school_id = studentsPR.school_id_st
group by region_sch, city;

--- Exercise 2

select school_lvl, city, count(*)
from schoolsPR
group by city, school_lvl;

---Exercise 3

Create table standsch as
select *
from studentspr as S, schoolspr as E
Where  S.school_id_st = E.school_id;

select count(*)
from standsch
where sex_st = 'F' and city = 'Ponce' and school_lvl = 'Superior';

--- Exercise 4

select region_st, district_sch, city, count(*)
from standsch
where sex_st = 'M'
group by region_st, district_sch, city;
