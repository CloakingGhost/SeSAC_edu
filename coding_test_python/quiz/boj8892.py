#region 팰린드롬

# 모든 경우의 수를 확인
import sys
# sys.stdin.readline : \n 문자가 추가 됨, 공백으로 보임
input = sys.stdin.readline

# 순열
# 순서가 중요한 경우 사용
from itertools import permutations 

T = int(input())
for _ in range(T):
  k = int(input())
  
  #region
  # 리스트 comprehension
  # for문은 횟수에 해당
  # 왼쪽은 입력될 값
  # 조건문 첨가 될 수 있음
  #endregion
  words = [input().rstrip() for _ in range(k)] 
  
  # words = []
  # for _ in range(k):
  #   word = input().rstrip() # 오른쪽 공백제거
  #   words.append(words)
  
  
  # 순열 모듈을 활용해서 단어 두 개를 뽑은 후
  # for w1, w2 in permutations(words):
        # 둘을 이어 붙이고
    # words = w1 + w2
    # # 회문 여부 검사
    # if word == word[::-1]:
    # # 회문이라면?
    #   # 출력 후 brack
    #   print(words)
    #   break
  for i in range(k):
    for j in range(k):
      if i == j:
        continue
    # 둘을 이어 붙이고
      words = w1 + w2
    # 회문 여부 검사
    if word == word[::-1]:
    # 회문이라면?
      # 출력 후 brack
      print(words)
      # break
      exit(0)
  # 찾지 못했다면?
  else :
    # 0 출력
    print(0)
    
    
# for-else
# break로 종료 else 안됨
# 정상 종료 시 else




#endregion