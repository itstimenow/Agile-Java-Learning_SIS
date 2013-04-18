#! /bin/bash

# clear the screen at first
clear

base_dir="/home/roger/Projects/Agile-Java/Lesson-03_Strings-and-Packages"


# clean up old class files
rm -r $base_dir/bin/*


# compile
mkdir -p $base_dir/bin/sis/studentinfo
javac -cp "$base_dir:/home/roger/lib/junit-4.11.jar" -d $base_dir/bin $base_dir/sis/studentinfo/*.java

mkdir -p $base_dir/bin/sis/report
javac -cp "$base_dir:/home/roger/lib/junit-4.11.jar" -d $base_dir/bin $base_dir/sis/report/*.java

javac -cp "$base_dir:/home/roger/lib/junit-4.11.jar" -d $base_dir/bin $base_dir/sis/*.java


# run tests
if [ $? -eq 0 ]; then
    java -cp "$base_dir/bin:/home/roger/lib/junit-4.11.jar" junit.textui.TestRunner sis.AllTests
fi
