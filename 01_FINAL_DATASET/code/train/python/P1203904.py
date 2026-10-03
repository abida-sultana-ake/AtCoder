if __name__ == "__main__":
    X = int(input())
    s = 0
    i = 0
    while True:
        s += i
        if s >= X:
            print(i)
            break
        i += 1