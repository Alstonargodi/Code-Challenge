if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()

    #get length students marks
    # key_value = student_marks.items()

    # total_sum = sum(value for key, value in key_value)
    # dict_length = len(total_sum)

    # average = total_sum / dict_length

    # print(average)

    list_students = student_marks.get(query_name,[])
    average = sum(list_students) / len(list_students)

    print("{:.2f}".format(average))