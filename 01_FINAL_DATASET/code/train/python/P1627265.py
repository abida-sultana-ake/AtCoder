# coding: utf-8
# Here your code !
def removeAllTargetFromList(lis,target):
    return [i for i in lis if i != target]
a = input()
s = input()
print("".join(removeAllTargetFromList(s,a)))
