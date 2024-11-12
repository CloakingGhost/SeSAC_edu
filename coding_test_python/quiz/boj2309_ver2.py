from itertools import combinations

#region




dwarfs = [int(input()) for _ in range(9)]
dwarfs.sort()
combi = combinations(dwarfs, 7)
# lst = list(combi)
# print(lst)

for cb in combi :
  if sum(cb) == 100:
    for dwarf in cb:
      print(dwarf)
    break 
#endregion
#region
""" 
1초에 1억번 연산
입력값과 시간복잡도를 계산하여
1억번이 넘으면 시간초과

시간제한이 0.5초라면
5000만번 이내로 들어와야 함.
"""


#endregion