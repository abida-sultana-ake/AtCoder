#python3

#cups for water, spoons for sugar
cup1, cup2, spoon1, spoon2, max_density, max_volume = (int(x) for x in input().split())

possible_water_volumes = set()

for cups1_nr in range(0, 30):
    for cups2_nr in range(0, 30):
        curr_water_volume = cups1_nr * cup1 + cups2_nr * cup2
        if curr_water_volume * 100 <= max_volume and curr_water_volume != 0:
            possible_water_volumes.add(curr_water_volume)

global_optimal_sugar = 0
global_optimal_water = cup1
global_dencity = 0            
for water_volume in possible_water_volumes:
    curr_optimal_sugar = min(water_volume * max_density, max_volume - water_volume * 100)
    for spoons1_nr in range(0, 1 + curr_optimal_sugar // spoon1):
        curr_sugar = spoon1 * spoons1_nr
        spoons2_nr = ((curr_optimal_sugar - curr_sugar) // spoon2)
        curr_sugar += spoon2 * spoons2_nr
        curr_density = curr_sugar / (water_volume * 100 + curr_sugar)
        if curr_sugar + water_volume * 100 > max_volume:
            continue
        elif curr_sugar > curr_optimal_sugar:
            continue
        elif curr_density > global_dencity:
            # print(curr_sugar, water_volume)
            global_optimal_sugar = curr_sugar
            global_optimal_water = water_volume
            global_dencity = curr_density
            
sugar_water_volume = global_optimal_water * 100 + global_optimal_sugar
print(sugar_water_volume, global_optimal_sugar)
        
        