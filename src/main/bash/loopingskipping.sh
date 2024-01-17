for value in $(seq 1 99)
do
    if(($value % 2 != 0)); #module habis dibagi 2
        then echo $value
    fi
done
