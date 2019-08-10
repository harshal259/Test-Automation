## Welcome to Cucumber-Selenium Test Automation Framework

This is an open source Test Automation Framework based off Java-Selenium-Cucumber.

It can be run on any IDE, however, we have used IDEA-IntelliJ Community Edition (2019).


## Below are the Key Features:

  - **Maven Project**: This helps to organize the project & provides an easy way to maintain builds. Also takes care of project dependencies automatically
  
  - **Integrated Scripts**: Has custom shell scripts to automate day to day tasks


## Pre-Requisites ##

  - Java/JDK (v1.7 or greater)
  - An IDE (IntelliJ/Eclipse) with cucumber & gherkin plugin installed
  - GIT Bash for Windows / Git for Linux/Mac
  - Notepad++ (Recommended)
  - WGET Binary (Recommended - [Required for getDrivers script])
    (go this URL & get the latest 64-bit .exe file & place it under you git/mingw64 folder)
    WGET URL: https://eternallybored.org/misc/wget/


## IntelliJ Settings ##

  1. run the below command to determine the java version on your machine:
  
      `java --version` 
  
  2. Import the Clone Project in IntelliJ.
  
  3. You need to update IDE settings at 2 locations with this java version
  
    3.1 Use Ctrl + Alt + S to open project settings
        Navigate to Build, Execution, Deployment > Compiler > Java Compiler & update the Target Bycode version to your java version obtained above.
        
    3.2 Right click your project and hit F4.
        Set the language level to be the same as your Java Version.

  
## Use below steps to use/contribute to this project:
  
  **Step 1: Checkout the project**
  
  Use the below command to checkout the project

  `git clone "https://github.com/harshal259/Test-Automation.git"`

  
  **Step 2: Add your changes & create a snapshot**
  
  Make changes to the files you wish & then use below commands to have them ready to push to GITHUB

  `git add .`

  `git checkout -b TestBranch`

  `git commit -am "<Your Commit Message>"`

  `git push --set-upstream origin TestBranch`

  
  **Step 3: Create a Pull Request & Merge changes**

  Follow the URL & Create a Pull Request for merging your changes into the main Repo
  
  Once Merged, every other user working on the project can Pull in your changes and start working on their part.  
  
  
  
  ## TO DO ##

  - Implement Spring Library to leverage its Dependency Injection feature
  - Add Report Logging and extent report generation
  - Link to a CI server
  - Add a Database & provisions to run queries



### Support or Contact
Contact me:

Harshal Purohit: harshal259@gmail.com
