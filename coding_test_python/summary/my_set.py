# 보조적으로 많이 사용 됨
my_set = set()

# 원소 삽입
my_set.add(5)
print(my_set)

# 원소 작제
# my_set.discard(5)
my_set.remove(5)
print(my_set)

# my_set.remove(3) # 없는 키는 에러남
# my_set.discard(3) # 없는 키라도 에러 안남

# 코딩 테스트는 통과가 목적이므로 discard를 많이 사용 함
