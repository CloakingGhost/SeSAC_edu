# region 투 포인터
import sys

input = sys.stdin.readline


N, M = map(int, input().split())
nums = list(map(int, input().split()))

# 세팅
# 두 포인터를 각각의 변수에 할당
i = j = 0
# 정답변수, 임시값
tmp = ans = 0

# 계속반복(while)
# while True :
while j == N :
  # tmp < M
  if tmp < M:
    # 오른쪽 포인터가 N에 가있으면
    # if j == N : break
      # 탐색 종료
      
    tmp += nums[j]
    # 오른쪽 포인터가 가리키는 값을 tmp에 더하고
    j += 1
    # 오른쪽 포인터 이동
    
  # tmp > M
  elif tmp > M :
    # 왼쪽 포인터가 가리키는 값을 tmp에서 빼고
    tmp -= nums[i]
    # 왼쪽 포인터를 이동
    i += 1
    
  # tmp == M
  # elif tmp == M:
  else :
    # 정답 하나 세어주고
    ans += 1
    # 왼쪽 포인터가 가리키는 값을 tmp에서 빼고
    tmp -= nums[i]
    # 왼쪽 포인터를 이동
    # 오른쪽 포인터 이동 시키면 out of index 가능성 있음
    i += 1
print(ans) 
    
# endregion


#region
""" 
투 포인터 조건에 따라 3가지 동작함
왼쪽 포인터 이동
오른쪽 포인터 이동
종료

포인터 사이의 정보를 모두 수집할 때
두 포인터 위치는 0으로 동일

두개의 포인터가 찝고 있는 데이터를 비교할 때
두 포인터의 위치는 양끝
예시 : 회문, 퀵 정렬(피벗을 기준으로 포인터의 데이터 정렬)

"""


#endregion