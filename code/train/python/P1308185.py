n = int(input())
gpa = input()

print(1 / n * (gpa.count("A") * 4 + gpa.count("B") * 3 + gpa.count("C") * 2 + gpa.count("D") * 1))