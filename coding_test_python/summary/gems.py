#region
gems = [3, 3, 1, 2, 3, 2, 2, 3, 3, 1]

# 1. 리스트 안에 1이 존재하는지 여부
# 반복문을 이용해서 리스트를 순회하며
for gem in gems:
# 1 이라는 데이터가 발견되었으면?
  if gem == 1:
# 찾았음을 표시하고 종료
    print("I found it!")
    break
#endregion
#region
# for idx in range(0, 10):
for idx in range(len(gems)): # 데이터의 길이와 상관없이 가능함
  if gems[idx] == 1:
    print("I found it")
    break
#endregion
#region
# 2. 리스트에서 가장 큰 값을 찾기
lst = [56, 23, 43, 87, 12, 457, 86]


# 초기값(가장 큰 숫자 후보) 세팅
#   큰 값을 작을 때는 가장 작은수
# max 값을 저장할 변수 선언
answer = lst[0]
answer = -float("INF")
# 반복문을 이용해서 리스트를 선형 탐색
for num in lst:
# 리스트에서 꺼낸 값이 max 값보다 크다면 
  if num > answer:
# 큰 값으로 max 값을 바꿔간다, 숫자를 갱신
    answer = num
# 반복문이 끝나면 max 출력
print(answer)
#endregion

#region
# 3. 집계 알고리즘
# 등급별로 몇개인지 헤아리기
gems = [3, 3, 1, 2, 3, 2, 2, 3, 3, 1]


# 딕셔너리를 이용한 집계 (key : value)
# 딕셔너리에 1 : 0, 2 : 0, 3 : 0이라는 키값을 만든다.
grades = dict()
grades = {1:0, 2:0, 3:0}


# 반복문을 이용해서 리스트를 선형 탐색
#   key를 이용하여 딕셔너리에 접근
for gem in gems:
#   방금 뽑은 그 등급에 따라서 밸류값을 갱신하다.
  # grades[gem] = grades[gem] + 1
  grades[gem] += 1
print(grades)
#endregion

#region
# 리스트를 이용한 집계
# 빈 판 만들기
grades = [0] * 4

for gem in gems:
  grades[gem] += 1


#endregion