spark = SparkSession.builder
from pyspark.sql import SQLContext
sqlContext = SQLContext(sc)

schoolsdf = sqlContext.read.csv("home/julian_cuevas1/BigDataExam1/hive/escuelasPR.csv")
schoolsdf.show()

schoolsdf2 = schoolsdf.selectExpr("_c0 as region", "_c1 as district", "_c2 as city", "_c3 as id_school", "_c4 as school_name","_c5 as school_lvl", "_c6 as series_college")
schoolsdf2.show()

studentsdf = sqlContext.read.csv("home/julian_cuevas1/BigDataExam1/hive/escuelasPR.csv")
studentsdf.show()

studentsdf2 = studentsdf.selectExpr("_c0 as region", "_c1 as  district", "_c2 as id_school", "_c3 as school_name", "_c4 as stud_lvl", "_c5 as gender", "_c6 as id_student")
studentsdf2.show()

condition = schoolsdf2.id_school == studentsdf2.id_school

joindf = studentsdf2.join(schooldsdf2, condition)
joindf.show()

resultdf = joindf.filter("gender='M' and school_lvl = 'Superior'").filter("city = 'Ponce' or city = 'San Juan'")
resultdf.show()
resultdf.count()
