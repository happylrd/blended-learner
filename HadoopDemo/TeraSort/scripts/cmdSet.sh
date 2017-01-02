#!/usr/bin/env bash

#mkdir
hdfs dfs -mkdir /user/happylrd/TeraSort

#put
hdfs dfs -put /home/happylrd/MyCode/HadoopProjects/TeraSort/data/input/ /user/happylrd/TeraSort

#query
hdfs dfs -ls -R | grep TeraSort

#run jar
hadoop jar /home/happylrd/MyCode/HadoopProjects/TeraSort/out/artifacts/terasort/terasort.jar io.happylrd.terasort.TeraSort /user/happylrd/TeraSort/input /user/happylrd/TeraSort/output

#remove
hdfs dfs -rm -r /user/happylrd/TeraSort

#get
hdfs dfs -get /user/happylrd/TeraSort/output /home/happylrd/MyCode/HadoopProjects/TeraSort/data/