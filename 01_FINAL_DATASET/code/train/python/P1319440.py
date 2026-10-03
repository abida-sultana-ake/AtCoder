s = input()

start = s.find('A')
end = s.rfind('Z')

print(end+1-start)
