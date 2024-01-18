#Print the characters from
#thirteenth position to the end.
while read word
do
  echo $word | cut -c 13- #sampai dengan indeks terakhir
done