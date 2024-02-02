# Enter your code here. Read input from STDIN. Print output to STDOUT
import re
# import email.uitls

# regex_pattern = r'([\w\.-]+)@[\w\.-]+)',r'\hotmail@.com'
regex_pattern = r"^[a-zA-Z]+[ ]+[<]+[a-zA-Z]+[\.\_\-\w]*\@[a-zA-Z]+\.[a-zA-Z]{1,3}[>]$"

# print(email.utils.parseaddr('DOSHI <DOSHI@hackerrank.com>'))

for i in range(int(input())):
    email = input()
    p = str(re.match(regex_pattern,email))
    if p != "None":
        print(email)
