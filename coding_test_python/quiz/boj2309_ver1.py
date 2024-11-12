#region 일곱난쟁이, 완전탐색

# dwarfs = list()
# for _ in range(N) :
#   dwarfs.append(int(input()))

flag = False

dwarfs = [int(input()) for _ in range(N)]
# for i in range(9) : 
for i in range(8) : 
  # for j in range(i) :
  for j in range(i+1, 9) :
    # 만약 i번째 난쟁이 키와 j 번째 난쟁이 키를 전체 합에서 빼서 100된다면
    if sum(dwarfs) - dwarfs[i] - dwarfs[j] == 100:
      spy = [i, j]
    # i, j를 보관
    # 2중 for문을 종료
      flag = True
      break
  if flag:
    break

# 하나씩 출력
for idx in range(9):
# (i, j번째는 출력하지 않음)
  if idx not in spy:
    print(dwarfs[idx])



#endregion