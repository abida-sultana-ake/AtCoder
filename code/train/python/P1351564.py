N = input()
string = input()
arrange = string
while True:
    after_arrange = arrange.replace('()','')
    if after_arrange == arrange:
        break
    arrange = after_arrange
left = after_arrange.count(')')
right = after_arrange.count('(')
print('('*left+string+')'*right)
