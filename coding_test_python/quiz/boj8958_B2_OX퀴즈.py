import sys
input = sys.stdin.readline

N = int(input())

for _ in range(N):
  quizzes = input().strip()
  sum = 0
  point = 1
  for quiz in quizzes:
    if quiz == 'X':
      point = 1
    elif quiz == 'O':
      sum += point
      point += 1
  print(sum)