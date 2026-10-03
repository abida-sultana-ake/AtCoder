s=input().upper()
print(['NO','YES'][s.find('I')<len(s[:s.find('I')+1])+s[s.find('I'):].find('C')<s.rfind('T')])