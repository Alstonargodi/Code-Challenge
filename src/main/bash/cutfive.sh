#Given a tab delimited file with several columns (tsv format) print
#the first three fields.

while read word;
do
    echo "$word" | cut -f 1-3 #cut memotong dalam index specifik
done