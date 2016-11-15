package app;
import java.io.File;
import java.util.ArrayList;

import app.wrapperClasses.Item;
import app.wrapperClasses.Rating;
import app.wrapperClasses.User;
import edu.princeton.cs.introcs.In;

public class Load {
	
	ArrayList<User> users = new ArrayList<User>();	//arrayList holding users.
	ArrayList<Rating> ratings = new ArrayList<Rating>();	//arrayList holding ratings.
	ArrayList<Item> items = new ArrayList<Item>(); //arrayList holding items.
	
	public Load(){
		readUsersFile("moviedata_small/users5.dat");
		System.out.println(users);
		System.out.println("number of users: "+ users.size());
		readRatingsFile("moviedata_small/ratings5.dat");
		System.out.println(ratings);
		System.out.println("number of ratings: "+ ratings.size());
		readItemsFile("moviedata_small/items5.dat");
		System.out.println(items);
		System.out.println("number of items: "+ items.size());
	}
	
	//reads the users file and wraps each user in the User class and adds each instance to the users arraylist.
	public void readUsersFile(String fileName){
	
		  File usersFile = new File(fileName);
	      In inUsers = new In(usersFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inUsers.isEmpty()) {
	          // get user and rating from data source
	          String userDetails = inUsers.readLine();

	          // parse user details string
	          String[] userTokens = userDetails.split(delims);

	          // output user data to console.
	          if (userTokens.length == 7) {     	  
	        	  users.add(new User(Integer.parseInt(userTokens[0]),userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4].charAt(0),userTokens[5],Integer.parseInt(userTokens[6])));
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+userTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	//reads the ratings file and wraps each user in the Rating class and adds each instance to the ratings arraylist.
	public void readRatingsFile(String fileName){
		
		  File ratingsFile = new File(fileName);
	      In inRatings = new In(ratingsFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inRatings.isEmpty()) {
	          // get user and rating from data source
	          String ratingDetails = inRatings.readLine();

	          // parse user details string
	          String[] ratingTokens = ratingDetails.split(delims);

	          // output user data to console.
	          if (ratingTokens.length == 4) {     	  
	        	ratings.add(new Rating(Integer.parseInt(ratingTokens[0]),Integer.parseInt(ratingTokens[1]),Short.parseShort(ratingTokens[2]),Long.parseLong(ratingTokens[3])));  
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+ratingTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	//reads the items file and wraps each user in the Item class and adds each instance to the items arraylist.
	public void readItemsFile(String fileName){
		
		  File itemsFile = new File(fileName);
	      In inItems = new In(itemsFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inItems.isEmpty()) {
	          // get user and rating from data source
	          String itemDetails = inItems.readLine();

	          // parse user details string
	          String[] itemTokens = itemDetails.split(delims);

	          // output user data to console.
	          if (itemTokens.length == 23) {   
	        	  String[] titleAndDate = itemTokens[1].split(" ");	//make an array of stings of each word split by a 'space'.
	        	  String vidUnformattedDate = titleAndDate[titleAndDate.length-1];	//take the last word from title, which is the date in the following format: (date).
	        	  String vidTitle = itemTokens[1].substring(0, itemTokens[1].length()-vidUnformattedDate.length());	//take the date away from the title of the movie.
	        	  String formattedVidDate = vidUnformattedDate.substring(1, vidUnformattedDate.length()-1);	//remove the brackets which the date is inside of.
	        	  int vidReleaseDate = Integer.parseInt(formattedVidDate);	//parse the formattedVidDate String into an int.
	        	  
	        	  items.add(new Item(Integer.parseInt(itemTokens[0]), vidTitle, vidReleaseDate, itemTokens[2],itemTokens[3],Short.parseShort(itemTokens[4]),Short.parseShort(itemTokens[5]),Short.parseShort(itemTokens[6]),Short.parseShort(itemTokens[7]),Short.parseShort(itemTokens[8]),Short.parseShort(itemTokens[9]),Short.parseShort(itemTokens[10]),Short.parseShort(itemTokens[11]),Short.parseShort(itemTokens[12]),Short.parseShort(itemTokens[13]),Short.parseShort(itemTokens[14]),Short.parseShort(itemTokens[15]),Short.parseShort(itemTokens[16]),Short.parseShort(itemTokens[17]),Short.parseShort(itemTokens[18]),Short.parseShort(itemTokens[19]),Short.parseShort(itemTokens[20]),Short.parseShort(itemTokens[21]),Short.parseShort(itemTokens[22])));  
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+itemTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	
	
	

      
	
}
