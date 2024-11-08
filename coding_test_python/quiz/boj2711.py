#region
# my_lst = [3, 5, 1, 2, 5]

# my_lst2 = my_lst[::-1]

# # print(my_lst2)

# my_lst.sort()

# # print(my_lst)

# word = "python"

# email = "12313@333.com"

# # print(email.split("@"))

# nums = "1 234 56 5 22 1 7 89"
# print(nums.split())


#endregion

#region 오타맨 고창영 ver1
T = int(input())

for _ in range(T) :
  idx, word = input().split()
  idx = int(idx)
  print(word[:idx - 1] + word[idx:])


#endregion

#region 오타맨 고창영 ver2

for _ in range(T):
  idx, word = input().split()
  idx = int(idx) - 1

  word = list(word)
  word.pop(idx)
  
  answer = ''.join(word)

  print(answer)

#endregion