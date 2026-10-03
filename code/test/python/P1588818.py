words = []

n = int(input())
tmp = []
ans = 0;

tmp = input()
tmp2 = tmp.split('.')
words = tmp2[0].split(' ')


ans += words.count("TAKAHASHIKUN")
ans += words.count("Takahashikun")
ans += words.count("takahashikun")

print(ans)