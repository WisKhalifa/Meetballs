README for Meetballs app. CS306 Mobile Apps Assignment 2. Wisam Halawi 903666.

This is an application designed to help you keep track of meetings that you have created.

To run the app if you are in:
IDE - Press the run button near the top right of the program and apply it to an emulator that you have downloaded with a minimum API of 24.
Mobile - Simply press the application icon.

The application will start on the view meetings page which displays each meeting already created inside the meetings.txt file. You can tap on any of the meetings to show more details about that meeting, alongside a show location button to display where it is on google maps.

To create a meeting, navigate to the Create a Meeting page via the bottom navigation bar. Input the required data by typing it in, and set the location by pressing the Set Location button and tapping where you want the meeting to be on the map. When you are done, press the Create Meeting button and navigate to the View Meetings page to show the meeting.

In the Settings page, you can change the text size and text color in the application by pressing the radio button of the color and/or size that you want. When you have selected which one you would like to change the text to, press the Apply Changes button.


Class breakdown.
---MainActivity---
This class is used to handle the switch case for the bottom navigation bar. It uses the fragment manager to change the view to the selected fragment.

---HomeFragment---
This fragment displays the recycler view layout by creating a recyclerview, getting every meeting inside the meetings.txt file through the displayMeetings() method insice the FileHandler, and then printing those through the adapter in RecyclerAdapter.

---RecyclerAdapter---
The recycler adapter is the logic behind the recycler view that I have added to the HomeFragment. This creates a viewholder that has two text views for the meeting title and meeting date attributes, and applies those attributes from a given meeting. It repeats for every meeting inside the meeting list passed into the adapter. It also has an onClick listener for each object displayed that can show the details of each meeting, which also incudes an onClick listener to show the location of that meeting.

---Meeting---
This is the meeting object class. It contains the variables, constructers, getters and setters to create a meeting object, which is applied in the HomeFragment and FileHandler.

---FileHandler---
The FileHandler class contains the methods and constructor used to add a meeting to the meetings.txt file, and convert the meetings from meetings.txt to the list of meetings. It also contains the findAttendees() method which takes each attendee contained a meeting and applies them to a seperate list of strings which is applied to the auto fill option in CreateFragment. displayMeeting() uses an InputStreamReader and a BufferedReader to read in the data from the file and apply them to a meeting list. createMeeting() uses OutputStreamWriter to write each string to the text file.

---CreateFragment---
This contains the layout to create a meeting object through the user input. This also has the addMeeting() method, which converts the textviews into strings and adds those to a meeting object, which in turn calls createMeeting() with those strings as the parameters. It takes the latitude and longitude from the MapsActivity class, as they are variables that are changed through the Set Location button. 

---MapsActivity---
This class intialises the mapview when called. It also sets the latitude and longitude values through the onClick listener when the user taps on the mapview. 

---SettingsFragment---
This class handles the text color and size changes across the application. It does this through the radio buttons and Apply Changes button inside the layout, which, when pressed, compares the selection to variables set and then changes textColor and textSize variables which are found in each class that contains a textview according to the selection that the user has made. By default the textColor is set to black and the textSize is set to 26dp. 