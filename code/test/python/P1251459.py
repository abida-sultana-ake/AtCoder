if __name__ == '__main__':
    a = input().split()
    if a[0][-1]==a[1][0] and a[1][-1]==a[2][0]:
        print('YES')
    else:
        print('NO')