
s = ''''''

for _ in range(int(input())):
    s = s + input() + '\n'

class HTMLPars(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print(tag)
        #checking tag
        if attrs:
            for att in attrs:
                print(f'-> {att[0]} > {att[1]}')

    def handle_startendtag(self, tag, attrs):
        print(tag)
        #checking tag
        if attrs:
            for att in attrs:
                print(f'-> {att[0]} > {att[1]}')

parser = HTMLPars()
parser.feed(s)