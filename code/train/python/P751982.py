n = int(input())
mod = ["1"]
mod.append("0" * (n - 1) + "7")
print(int(''.join(mod)))
