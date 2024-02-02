regex_pattern = r"^(?!$)M{,3}(C[DM]|D?C{,3})(X[LC]|L?X{,3})(I[VX]|V?I{,3})$"	# Do not delete 'r'.

"^(?!$)M{,3}(7|8|9"
import re
print(str(bool(re.match(regex_pattern, input()))))