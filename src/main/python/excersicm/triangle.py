def equilateral(sides):
    # sort sides array
    # sum sort array in index 2 
    sort = sorted(sides)
    check = sum(sort[:2]) > sort[2]
    print([:2])
    return check and len(set(sides)) == 1


def isosceles(sides):
    # if sides[0] != sides[1] and sides[1] == sides[2]:
    #     print(True)
    # else:
    #     print(False)
    # pass
    sort = sorted(sides)
    check = sum(sort[:2]) > sort[2]
    return check and len(set(sides)) <= 2


def scalene(sides):
    sort = sorted(sides)
    check = sum(sort[:2]) > sort[2]
    return check and len(set(sides)) == 3
