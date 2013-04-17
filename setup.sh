#! /bin/sh

# ================================
# Set up the shell environment for Agile Java
# ================================


run_test() {
    # find runTest.sh
    test_shell=`find_test_shell`
    
    # run tests
    if [ $test_shell ]; then
        $test_shell
    else
        echo "**** runTest.sh not found! ****"
    fi
}

find_test_shell() {
    # find runTest.sh by searching from current working directory through its 
    # parent directories
    
    directory=`pwd`
    test_shell=""
    
    while [ $directory != $base_dir ]
    do
        if [ -f $directory/runTest.sh ]; then
            test_shell=$directory/runTest.sh
            break
        else
            directory=`dirname $directory`
        fi
    done
    
    echo $test_shell
}

run_ant() {
    # find build.xml
    build_file=`find_build_file`
    
    # run ant with the build.xml
    if [ $build_file ]; then
        ant -buildfile $build_file
    else
        echo "**** build.xml not found! ****"
    fi
}

find_build_file() {
    directory=`pwd`
    build_file=""
    
    while [ $directory != $base_dir ]
    do
        if [ -f $directory/build.xml ]; then
            build_file=$directory/build.xml
            break
        else
            directory=`dirname $directory`
        fi
    done
    
    echo $build_file
}


base_dir="/home/roger/Projects/Agile-Java"

# shorten the prompt length
export PS1="\W$ "

cd $base_dir

alias ge="gedit"
alias runtest="run_test"
alias runant="run_ant"
