read x
read y

if(($x > $y));then
    echo "X is greater than Y "
elif(($x == $y)); then
    echo "X is equal to Y"
else(($x < $y))
    echo "X is less than Y"
fi
