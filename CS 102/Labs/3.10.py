favorite_color = input('Enter favorite color:\n')
pet_name = input('Enter pet\'s name:\n')
number = input('Enter a number:\n')

print('You entered:', favorite_color, pet_name, number)

password1 = favorite_color + '_' + pet_name
password2 = number + favorite_color + number
print('\nFirst password:', password1)
print('Second password:', password2)

print('\nNumber of characters in {}:'.format(password1), len(password1))
print('Number of characters in {}:'.format(password2), len(password2))
