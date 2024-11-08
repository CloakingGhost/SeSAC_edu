#region 회사에 있는 사람

n = int(input())
my_set = set()
for _ in range(n):
  name, status = input().split()
  if status == 'enter':
    my_set.add(name)
  else :
    my_set.remove(name)

answer = list(my_set)
answer.sort(reverse=True)
for n in answer:
  print(n)

#endregion