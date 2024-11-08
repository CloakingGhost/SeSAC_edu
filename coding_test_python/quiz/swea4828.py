# print 함수의 특징(한 줄에 하나, 여러 개 한줄~~)
# sep 옵션, end 옵션
# f-string

T = int(input())

for tc in range(1, T+1):
  N = int(input())
  문자열_배열 = input().split()
  요소_적용_함수 = int
  변환기 = map(요소_적용_함수, 문자열_배열)

  nums = list(변환기) # 문자열[]

# 초기값을 두 개 설정
  max_num = -float("INF")
  min_num = float("INF")
  max_num = nums[0]
  min_num = nums[0]

# 반복문을 이용해서 nums 순회하며
  for num in nums:

  # if 두번 써야함, if - elif 안 됨
  # max_num과 방금 뽑은 숫자를 비교 => 갱신
    if max_num < num:
      max_num = num
    if min_num > num:
      min_num = num
  # min_num과 방금 뽑은 숫자를 비교 => 갱신
  answer = max_num - min_num

  print(f'#{tc} {answer}')