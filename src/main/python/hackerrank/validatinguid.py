regrex_pattern = r'^(?!.*(.).*\1)(?=(?:[^A-Z]*[A-Z]){2,})(?=(?:[^\d]*\d){3,})(?!.*[^A-Za-z0-9].*$)[A-Za-z0-9]{10}$'

for _ in range(int(input())):
    uid = input()
    pattern = re.match(regrex_pattern,uid)
    if pattern:
        print("Valid")
    else:
        print("Invalid")