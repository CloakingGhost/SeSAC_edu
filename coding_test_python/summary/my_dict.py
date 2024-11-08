my_dict = {'name' : 'ken', 'age':20, 'license' :True}

# get 메소드
# print(my_dict['address']) # error
print(my_dict.get('address',0))

# keys, values, items()
print(my_dict.keys())
print(my_dict.values()) 
print(my_dict.items()) 