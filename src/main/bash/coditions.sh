read x

read value

#[Yy] jika kapital atau tidak
if [[ "$value" =~ [Yy] ]]
    then echo "YES"
elif [[ "$value" =~ [Nn] ]]
    then echo "NO"

fi
