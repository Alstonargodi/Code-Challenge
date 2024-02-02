if __name__ == '__main__':
    students = {}
    for _ in range(int(input())):
        name = input()
        score = float(input())
        students[name] = score
    scores = list(students.values())
    scores.sort()
    lowest_score = [x for x in scores if x>scores[0]][0]
    name = [i for i in students if students[i] == lowest_score]
    name.sort()
    for i in name:
        print(i)
