import collections
S = input()
cnt = collections.Counter(S)
print(cnt["A"], cnt["B"], cnt["C"], cnt["D"], cnt["E"], cnt["F"])
