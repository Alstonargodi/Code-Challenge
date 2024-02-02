if __name__ == '__main__':
    n = int(input())
    integer_list = map(int, input().split())
    int_list = tuple(integer_list)
    print(hash(int_list))