import re

def fun(s):
    regex_pattern = r"^[a-zA-Z0-9_-]+@[a-za-z0-9]+\.[a-zA-Z]{1,3}$"

    # return True if s is a valid email, else return False
    valid = re.match(regex_pattern,s)
    return valid

def filter_mail(emails):
    return list(filter(fun, emails))

if __name__ == '__main__':
    n = int(input())
    emails = []
    for _ in range(n):
        emails.append(input())

filtered_emails = filter_mail(emails)
filtered_emails.sort()
print(filtered_emails)