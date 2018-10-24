spark = SparkSession.builder
from pyspark.sql import SQLContext
sqlContext = SQLContext(sc)
schoolsdf = sqlContext.read.csv("/home/julian_cuevas1/BigDataExam1/hive/escuelasPR.csv")

schoolsdf.show()
schoolsdf2 = schoolsdf.selectExpr("_c0 as region", "_c1 as district", "_c2 as city", "_c3 as id_school", "_c4 as school_name","_c5 as school_lvl", "_c6 as series_college")
escuelascoldf.show()

resultdf = schooldf2.filter("region='Arecibo'")
resultdf.show()

disctrictGroupBy = resultdf.groupby('district', 'city')
disctrict.count().show()

