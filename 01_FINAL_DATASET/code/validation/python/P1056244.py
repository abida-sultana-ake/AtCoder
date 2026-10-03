def main():
    sx,sy,tx,ty = map(int,input().split())

    root = ""

    # first
    for n in range(tx - sx):
        root += "R"
    for n in range(ty - sy):
        root += "U"

    # first back
    for n in range(tx - sx):
        root += "L"
    for n in range(ty - sy):
        root += "D"

    # first
    root += "D"
    for n in range(tx - sx + 1):
        root += "R"
    for n in range(ty - sy + 1):
        root += "U"
    root += "L"

    # first back
    root += "U"
    for n in range(tx - sx + 1):
        root += "L"
    for n in range(ty - sy + 1):
        root += "D"
    root += "R"

    print(root)

if __name__ == "__main__":
    main()
