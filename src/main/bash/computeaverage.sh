read n
sum = 0
for ((i=1; i<=$n; i++))
do
read input
((sum+=input))
done
avr=$(echo "scale=4; $sum / $n" | bc)

printf  "%.3f" $avr
