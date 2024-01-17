read value

#calculate result dengan decimal 4
result=$(echo "scale=4; $value" | bc )

#print decimal 3
printf  "%.3f\n" $result