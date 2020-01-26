import math

paint_colors = {
   'red': 35,
   'blue': 25,
   'green': 23
}

wall_height = int(input('Enter wall height (feet):\n'))
wall_width = int(input('Enter wall width (feet):\n'))
wall_area = wall_height * wall_width
print('Wall area:', wall_area, 'square feet')
   
gallons_needed = wall_area / 350.0
print('Paint needed: {:.2f} gallons'.format(gallons_needed))

cans = math.ceil(gallons_needed)
print('Cans needed: {} can(s)'.format(cans))

color = input('\nChoose a color to paint the wall:')
print('\nCost of purchasing {} paint: ${}'.format(color, paint_colors[color] * cans))
