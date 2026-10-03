def main():
    a, b = input().split()

    if (a == 'H' and b == 'H') or (a == 'D' and b == 'D'): print('H')
    else: print('D')


if __name__ == "__main__":
    main()