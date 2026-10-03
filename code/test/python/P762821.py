right = input()
d = {
    0:"Do", 2:"Re", 4:"Mi", 5:"Fa", 
    7:"So", 9:"La", 11:"Si"}

def solve(r):
    keys = "WBWBWWBWBWBW"*3
    for i in range(len(r)):
        if keys[i:i+len(r)]==r:
            return i

print(d[solve(right)])