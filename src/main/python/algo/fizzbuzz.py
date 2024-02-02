
def fizzBuzz(n):
    for i in range(n):
        if i % 3 == 0:
            print("Fizz")
        if i % 5 == 0:
            print("Buzz")
        if i % 15 == 0:
            print("Fizz Buzz")
        else:
            print(i)


for i in range(100):
        fizzBuzz(i)