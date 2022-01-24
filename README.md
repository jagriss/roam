# Roam - application to track your travels

Roam is a web application for saving and sharing travels. It was built with Spring MVC, thymeleaf, Bootstrap, hibernate, and MySQL.

## Goals
Create a way for people to track and remember their travels. Users can keep a log just for themselves or to share with other users as a virtual scrapbook. 

## Technologies Used
Roam is built with the following technologies:

* Java
* Spring Boot
* Hibernate
* MySQL
* Bootstrap
* HTML
* Thymeleaf
* CSS
* Javascript

## Why these technologies?
I chose to use the Spring Boot, ThymeLeaf, MySQL set of technologies to solidify knowledge and skills learned in the LaunchCode bootcamp curriculum.

I am expanding my learned skills by using and exploring Bootstrap as I develop my frontend of Roam.


## How it was built

1. The first thing I did was mock up the visuals of the app using Bootstrap and basic HTML to get an understanding of what features and functionality would be required.
2. Intially I limited the amount of features for the application to produce a basic functionality for the project. I limited user posts to existing travels with name(s), location, notes, and dates. 
  - Create a travel
  - Review a travel
  - Delete a travel
3. I added User objects, authentication and authorization.
4. I restricted Delete actions to only users who owned the travel in question
5. User Profiles
6. I added a Wishlist object for users to update trips they wish to take in the future

## Features
* User Registration
  * Users can create a new account with a username and password
* User Login
  * Users can login with a valid username and password.
  * Valid login results in a session being created on the server and cookie being stored on the client.
* User Logout
  * Users can logout, invalidating their session and removing their session cookie from local storage.
* Travel Creation
  * Users can create new existing and wishlist travels consisting of a name, location, date, and notes.
* Travel Delete
  * Users can delete a travel that they created.
  * Users may not delete recipes created by other users.
* Travel View
  * Users can view a log of all their existing and wishlist travels. 
* User Profile
  * Users can view a list of all the existing and wishlist travels they have created.

## Next Steps
* Travel image upload
* Search feature
* Edit feature for wishlist and existing travel logs. 
* Create a sharing feature between users

## Credits
Map icon from Freepik www.flaticon.com
