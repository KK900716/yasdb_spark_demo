package com.sics;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class Main {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:\\ljc\\winutils\\hadoop-3.0.2");

        var sparkConf = new SparkConf();
        sparkConf.setAppName("test0001");
        sparkConf.setMaster("local[2]");

        var sparkSession = SparkSession.builder()
        .config("spark.sql.warehouse.dir", "spark-warehouse")
        .config(sparkConf)
        .getOrCreate();

        var jdbcDF = sparkSession.read()
        .format("jdbc")
        .option("url", "jdbc:yasdb://192.168.32.61:1688/SYS")
        .option("driver", "com.yashandb.jdbc.Driver")
        .option("user", "SYS")
        .option("password", "Cod-2022")
        .option("dbtable", "SPARK_TEST.LTEST1")
        .load();

        jdbcDF.show();
    }
}
