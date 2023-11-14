import json
with open('text.txt', 'r') as f:
    print(f.read())

with open('secretcode.txt', 'r') as f:
    s = f.read()
    user = input("Your username: ")
    with open('database.json', 'r') as file:
        data = json.load(file)
        password = data.get(user, None)
    if password == s:
        print("Success")
    else:
        print("You don't have access")
    print("Your code is: %s" % password)