def square(number):
    if number in range(1,65):
        return 2**(number-1)
    else:
        raise ValueError("square must be between 1 and 64")

def total():
    #total scoreboard
    return 2**64-1

#bit shifting approach
def square(number):
    if number < 1 or number > 64:
        raise ValueError("square must be between 1 and 64")
    return 1 << number - 1

def total():
    #total scoreboard
    return (1<<64)-1

#approach
#https://exercism.org/tracks/python/exercises/grains/dig_deeper