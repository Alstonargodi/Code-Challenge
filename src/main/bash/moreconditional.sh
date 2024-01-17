read X
read Y
read Z


if [[ $X == $Y && $X == $Z ]]
then echo "EQUILATERAL"
elif [[ $X == $Y || $X == $Z || $Y == $Z ]] #cek tiga kondisi
then echo "ISOSCELES"
else echo "SCALENE"
fi