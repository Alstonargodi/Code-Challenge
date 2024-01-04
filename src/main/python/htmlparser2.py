# Enter your code here. Read input from STDIN. Print output to STDOUT

from html.parser import HTMLParser

class HTMLParsers(HTMLParser):
    def handle_comment(self,data):
        if '\n' in data:
            print(">>> Multi-line Comment")
            print(data)
        else:
            print(">>> Single-line Comment")
            print(data)

    def handle_data(self,data):
        if '\n' not in data:
            print(">>> Data")
            print(data)

html = ""
for i in range(int(input())):
    html += input().rstrip()
    html += '\n'

parser = HTMLParsers()
parser.feed(html)
parser.close()