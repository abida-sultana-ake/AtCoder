def main():
    a, b, c = map(int, input().split())
    print(max(c // a, c // b))


if __name__ == '__main__':
    main()
