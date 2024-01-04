# Enter your code here. Read input from STDIN. Print output to STDOUT
#html parser
from html.parser import HTMLParser

s = ''''''

for _ in range(int(input())):
    s = s + input() + '\n'

class HtmlParsers(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print("Start :", tag)
        if attrs:
            for att in attrs:
                print(f'-> {att[0]} > {att[1]}')
    def handle_endtag(self, tag):
        print("End   :", tag)
    def handle_startendtag(self, tag, attrs):
        print("Empty :", tag)
        if attrs:
            for att in attrs:
                print(f'-> {att[0]} > {att[1]}')


parser = HtmlParsers()
parser.feed(s)