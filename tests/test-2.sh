#!/bin/bash

# color codes
RESET="\033[0m"
RED="\033[0;31m"
GREEN="\033[0;32m"

# test directory
cd "02 - greedy algorithms/"

FILES=$(find . -type f -iname "*.java" | sort)
RESULT=0

for i in $FILES;
do
	i=${i##*/}

	# find testcases based on filename
	TESTS=$(find input/ -type f -iname "${i%.*}*.in" | sort)

	for j in $TESTS;
	do
		j=${j##*/}

		# Attempt to compile.
		javac $i 2> /dev/null
		compile_val=$?
		if [[ $compile_val != 0 ]]; then
			echo -e "[$RED FAIL $RESET] ${j%.*}"
			echo -e "failed to compile"
			RESULT=1
			continue
		fi

		# Run program. Capture return value to check whether it crashes.
		java ${i%.*} < input/${j%.*}.in > tmp.txt 2> /dev/null
		execution_val=$?
		if [[ $execution_val != 0 ]]; then
			echo -e "[$RED FAIL $RESET] ${j%.*}"
			echo -e "program crashed"
			RESULT=1
			continue
		fi

		# Run diff and capture its return value.
		diff tmp.txt output/${j%.*}.out > /dev/null
		diff_val=$?

		# Output results based on diff's return value.
		if [[ $diff_val != 0 ]]; then
			echo -e "[$RED FAIL $RESET] ${j%.*}"
			echo -e "output does not match"
			RESULT=1
		else
			echo -e "[$GREEN PASS $RESET] ${j%.*}"
		fi
	done

done

# Clean up the executable file.
rm -f *.class

# Clean up the output file generated by this script.
rm -f tmp.txt

# Return 0 if all tests passed, else return 1
exit $RESULT
