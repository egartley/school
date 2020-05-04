class Artist:
    def __init__(self, name="None", birth_year=0, death_year=0):
        self.name = name
        self.birth_year = birth_year
        self.death_year = death_year
    
    def print_info(self):
        if self.death_year == -1:
            print("Artist: {}, born {}".format(self.name, self.birth_year))
        else:
            print("Artist: {} ({}-{})".format(self.name, self.birth_year, self.death_year))
      
class Artwork:
    def __init__(self, title="None", year_created=0, artist=Artist()):
        self.title = title
        self.year_created = year_created
        self.artist = artist
    
    def print_info(self):
        self.artist.print_info()
        print("Title: {}, {}".format(self.title, self.year_created))

if __name__ == "__main__":
    user_artist_name = input()
    user_birth_year = int(input())
    user_death_year = int(input())
    user_title = input()
    user_year_created = int(input())

    user_artist = Artist(user_artist_name, user_birth_year, user_death_year)

    new_artwork = Artwork(user_title, user_year_created, user_artist)
  
    new_artwork.print_info()
