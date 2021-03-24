import java.util.ArrayList;
import java.util.Arrays;

public class Lab4Driver {

	/**
	 * The main methods executes all the code needed to test out Listing and
	 * Rentable objects
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Host host1 = new Host("8435", "Jef Karchin", "2009-02-23", "San Diego, California, United States",
				"Real estate broker,  Jef  Karchin real estate   I provide flat fee real estate services to For Sale By Owners.   I stay at the condo whenever it is not rented.  There is nothing like staying at the beach, right on the ocean.  I surf right in front of our condo and always enjoy watching the dolphins swimming by, occasionally joining them in the waves.",
				"within a few hours", 100, 100, false);
		Host host2 = new Host("1291", "Michael", "2010-05-21", "San Diego, California, United States",
				"We love living part of the year in San Diego. The outdoor lifestyle and laid back attitude makes for a great life here. We enjoy traveling and opening our vacation home to others so that they can enjoy a nice travel experienc in San Diego. This town has a lot to offer.",
				"within an hour", 100, 50, true);

		AirbnbListing airbnbList1 = new AirbnbListing(host1, "5570", "Ocean front condo on the sand",
				"Missionbeachretreat.   Great Ocean Front Condo, right on the boardwalk.  We have many reviews on  website V.<br /><br /><b>The space</b><br />This charming two bedroom beachfront condominium offers stunning ocean and sunset views from the living room, master bedroom, as well as the spacious outdoor balcony. This is the perfect setting for a romantic getaway or a family vacation. Strolls on the white sandy beach directly in front as well as limitless water sports are all just out your door.<br /><br />This middle  floor corner unit condo features a sun filled living room with  a  flat screen TV and comfortable seating for up to six guests. Guests will also enjoy the fully equipped kitchen and dining room with seating for 4. Guests staying in the finely appointed master bedroom will enjoy waking up every morning to sprawling and unobstructed white water views through the oversized bedroom windows. There is also a second guest bedroom with two twin beds and an inflatable queen size, aer",
				"Entire home",
				"\"[\"\"Iron\"\", \"\"Elevator\"\", \"\"Stove\"\", \"\"Microwave\"\", \"\"Dishes and silverware\"\", \"\"Beachfront\"\", \"\"Heating\"\", \"\"Kitchen\"\", \"\"Washer\"\", \"\"Refrigerator\"\", \"\"Smoke alarm\"\", \"\"Hair dryer\"\", \"\"Cable TV\"\", \"\"Dryer\"\", \"\"Dishwasher\"\", \"\"Patio or balcony\"\", \"\"BBQ grill\"\", \"\"TV\"\", \"\"Oven\"\", \"\"Coffee maker\"\", \"\"Long term stays allowed\"\", \"\"Essentials\"\", \"\"Dedicated workspace\"\", \"\"Wifi\"\", \"\"Waterfront\"\", \"\"Free parking on premises\"\", \"\"Cooking basics\"\"]\"",
				2050, 6, 5, "Entire condominium", 5, 1, 2, 3, 365);
		AirbnbListing airbnbList2 = new AirbnbListing(host2, "2996", "Great home, 10 min walk to Beach",
				"This 2 bedroom, 2 full bathroom home offers all the comforts you and your family need to enjoy a great San Diego experience.  Our property is equipped with a full kitchen, patio for BBQing and everything you need to enjoy the beach.<br /><br /><b>The space</b><br />This two bedroom (1 CA king bed, 1 queen bed), 2 full bathroom duplex is less than two blocks to beautiful Tourmaline Surf Beach. Our home also has a bonus room with comfortable Ikea day bed that converts to queen size. There is a queen size Aerobed with complete lines for additional guests. <br /><br />Our home comes fully furnished with a large flat screen television with complimentary Netflix, full cable TV, DVD player, wireless internet, outdoor gas BBQ with a shared outdoor patio, hammock, fresh linens & towels, fully equipped kitchen, beach chairs/towels and cooler for your use. Complimentary use of the laundry room, washer & dryer, all detergents provided.<br /><br />The patio is great for dining or just relaxing in o",
				"Entire home",
				"\"[\"\"Iron\"\", \"\"Hot water\"\", \"\"Heating\"\", \"\"Kitchen\"\", \"\"Washer\"\", \"\"First aid kit\"\", \"\"Pack \\u2019n Play/travel crib\"\", \"\"Smoke alarm\"\", \"\"Shampoo\"\", \"\"Hair dryer\"\", \"\"Cable TV\"\", \"\"Dryer\"\", \"\"TV\"\", \"\"Long term stays allowed\"\", \"\"Fire extinguisher\"\", \"\"Essentials\"\", \"\"Dedicated workspace\"\", \"\"Wifi\"\", \"\"Free parking on premises\"\", \"\"Hangers\"\", \"\"Carbon monoxide alarm\"\"]\"",
				261, 25, 256, "Entire bungalow", 8, 2, 2, 4, 365);

		HotelListing hl1 = new HotelListing("hotel15235", "Marriot",
				"Downtown San Diego is Right in downtown San Diego!", "Entire room",
				"\"Hot water\"\", \"\"Heating\"\", \"\"Kitchen\"\", \"\"Washer\"\", \"\"First aid kit\"\", \"\"Pack \\u2019n Play/travel crib\"\"",
				200, 125, 136, 30, 5, true, true, false);
		HotelListing hl2 = new HotelListing("hotel13677", "Mission Beach Contemporary Hotel",
				"Beautifully updated contemporary room", "Entire room",
				"\"\"Ethernet connection\"\", \"\"Dedicated workspace\"\", \"\"Wifi\"\"", 350, 2521, 617, 20, 2, true,
				false, true);

		Listing[] list = new Listing[4];
		list[0] = airbnbList1;
		list[1] = hl1;
		list[2] = airbnbList2;
		list[3] = hl2;

		System.out.println("The array of Listings before sorting:");
		printArray(list);

		System.out.println("The array of Listings after sorting:");
		Arrays.sort(list);
		printArray(list);

		ArrayList<Rentable> rentable = new ArrayList<Rentable>();

		rentable.add(new Equipment("Big Dog Drill", 10, 15));
		rentable.add(new Equipment("Ultra Muscle Saw", 30, 25));

		rentable.add(new RentalCar("Toyota", "Corolla", 2010, 100));
		rentable.add(new RentalCar("Ford", "F150", 2015, 200));

		rentable.add(airbnbList1);
		rentable.add(airbnbList2);
		rentable.add(hl1);
		rentable.add(hl2);

		printArrayCharges(rentable);
	}

	/**
	 * printArray is a basic method to print out an array of type Listing in a
	 * cleaner format than Arrays.toString()
	 * 
	 * @param lists
	 */
	private static void printArray(Listing[] lists) {
		for (int i = 0; i < lists.length; i++) {
			System.out.println(lists[i]);
		}
		System.out.println();

	}

	/**
	 * printArrayCharges a method that prints out details of a Rentable object the
	 * cost to rent out each object for a preset amount of time
	 * 
	 * @param rentable
	 */
	private static void printArrayCharges(ArrayList<Rentable> rentable) {
		for (int i = 0; i < rentable.size(); i++) {
			System.out.print(rentable.get(i));
			System.out.println("\tRental cost of four" + (rentable.get(i) instanceof Equipment ? " hours " : " days ")
					+ rentable.get(i).getRentalCharge(4));
		}
		System.out.println();
	}

}
