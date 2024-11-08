#region 베스트 셀러

# 책 제목들 => 가장 많이 팔린 책의 제목
# 하루동안 팔린 책 수
# 책을 하나씩 알려줌
# 가장 많이 팔린 책 출력

# 자연수 1 ~ 1000

N = int(input())

best_seller = dict()
for _ in range(N) :
  title = input()
  if title not in best_seller :
    best_seller[title] = 1
  else :
    best_seller[title] += 1
max = 0
answer = ''

for k, v in best_seller.items():
  if v > max :
    max = v
    answer = k
  elif v == max :
    answer = k if k < answer else answer

print(answer)






from collections import Counter

N = int(input())
titles = [input() for _ in range(N)]
best_seller = Counter(titles)

max_count = max(best_seller.values())
answer = min(title for title, count in best_seller.items() if count == max_count)

print(answer)


#endregion




