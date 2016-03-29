# Stock Exchange System

This is project is a simple text-based  Stock Exchange System that runs in the console or terminal.

## Notes

For the instructions of how to compile and run this project I am going to asume you have [Java Runtime Environment](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html). if you don’t please go ahead and install it, since this project is a java program and it will not run without it.

## How to compile and run from terminal 

1. Download and save the program in your **Desktop** as it will be easier to access and i will follow this method.
2. Unzip the File.
3. Open the Terminal or Console 
4. Navigate to the project directory `cd Desktop/P1_4035_802137210_151`

5. To Compile`javac -sourcepath src/ src/menuClases/Main.java`
6. If you get a warning like this: <img src="http://i.imgur.com/02Gc0n0.png" title=“Error” /> you will have to compile again `javac -sourcepath src/ src/menuClases/Main.java -Xlint:unchecked`

7. Run the program `java -classpath src/ menuClases/Main`

8. The program should be running now.

## User Stories

- [x] User can add a Company to the database.
- [x] User can remove a Company to the database.
- [x] User can view all the data related to the Selected Company.
- [x] User can add a Shares to a Company in the database.
- [x] User can add a Shareholder to the database.
- [x] User can remove a Shareholder to the database.
- [x] User can show a Shareholder's portfolio.
- [x] User can split the stock for a Company and all Shares bought by Shareholders of the Company will reflect this change.
- [x] User can update the Stock value of a Company in the database.
- [x] User can show all Shareholders of a Company in the database.
- [x] User can buy or sell Shares of a particular Shareholder related to a specific Company.


## License

    Copyright 2016 Fernando Rodriguez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
