# StoryIdeaGenerator
Generates random persona and different writing options. Useful when you need a challenge.

In this project, you will find two different tools : a "persona" creator and a "writing options" creator.

The Persona class represents a story character. The name persona is to avoid the confusion with the character key word.

The WritingOptions class represents a couple of style list and theme list.

This tool allows you to use different files that contains options (eyes color, hair style, etc) to generate a random persona or writing options.

## How to use it ?
First, get an IDE (Eclipse)

1. Download Eclipse (The last version)
2. Install Eclipse
3. Launch Eclipse

Next, clone / download this project

Go to Eclipse and follow the procedure :

File -> Open project from File system -> Directory -> [go to the project] -> Select the project with the checkbox -> Finish

Then, you should have access to the project.

To launch it, you can :
1. click the run button
2. ctrl + f11
3. use the menu : Run -> Run

To change it : open the project from the Eclipse window -> open the src folder -> open the launcher package (folder) -> double click on Launcher.java

## RESOURCES
This project uses different resources files.

These files are stored in the resources folder of the StoryIdeaGenerator project.

You can update them as much as you want (adding/removing lines).

## Architecture

### PERSONA
A persona contains :
 - an age
 - a job
 - a name
 - a position toward the main character (can be main character)
 - a list of traits
 - a physical description

### PHYSICAL
A physical description contains :
 - a hairStyle
 - a hairColor
 - a eyesColor
 - a faceShape
 - a morphology
 - a weight
 - a height
 - a gender

### Writing options
A writing options contains :
 - a list of styles
 - a list of themes
