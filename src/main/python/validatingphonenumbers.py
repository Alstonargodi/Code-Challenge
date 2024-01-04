regrex_pattern = '^[789]\d{9}$'

# print(int(bool(re.match(regrex_pattern,input()))))

#twonumbers
for _ in range(int(input())):
    number = input()
    pattern = re.compile(regrex_pattern)
    if re.search(pattern,number):
        print("YES")
    else:
        print("NO")