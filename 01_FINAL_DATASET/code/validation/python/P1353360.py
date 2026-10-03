def dainari(a,b):
    if a < b:
        return b
    else:
        return a


if __name__ == '__main__':
    a,b = map(int, input().split())
    print(dainari(a,b))
