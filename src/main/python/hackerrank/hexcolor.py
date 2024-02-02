# Enter your code here. Read input from STDIN. Print output to STDOUT
import re

color = int(input())
regex_pattern = r'(#[\dA-Fa-f]{3}|#[\dA-Fa-f]{6})[,\);]'

for i in range(color):
    match = re.findall(regex_pattern,input())
    if match:
        print(*match,sep="\n")