## README.MD
This file contains a short description of this frame.
This frame can create easily automation scripts for testing Web-Based Software.
The frame is composed of Selenium Web Driver with TestNG.
The frame was created using Eclipse IDE, but you can use what you want.

## Installation requirements:
To use this framework you need to install:
- JDK9 : https://www.oracle.com/java/technologies/javase/javase9-archive-downloads.html
- TestNG Eclipse Plugin (if you are using Eclipse) : https://testng.org/doc/eclipse.html
- chromedriver.exe : https://chromedriver.chromium.org/downloads
- geckodriver.exe : https://github.com/mozilla/geckodriver/releases
- Chrome browser
- Firefox browser

## Frame structure:
In src/main/java
- configuration.Configuration : This class contains all configurations that we use in the frame. You can add your own configuration in this class.
- configuration.MainMethods : This class contains all Domain Specific Language (Selenium) methods. You can add your own methods to this class.
- configuration.OtherMethods : This class contains all Java methods. You can add your own methods to this class.
- configuration.WaitTypes : This class contains all wait methods. YOu can add your own methods to this class.
- pom.* : Those classes contains locators, elements, and specific methods related to the test classes. You can add more classes related to your tests.

In src/test/java
- base.BaseTestClass : This class contains configuration methods used in test classes before and after annotations. You can add your own methods to this class.
- dataDrivenTesting.ImportDataFromExcel : This class contains three methods responsible for reading data from Excel files (data-driven testing).
- dataDrivenTesting.ReadingFromExcelFile : This class contains examples of how to read data from an Excel file cell.
- listeners.IInvokedMethodListenerClass : This class contains all IInvokedMethodListener listeners.
- listeners.ISuiteListenerClass : This class contains all ISuiteListener listeners.
- listeners.ITestListenerClass : This class contains all ITestListener listeners.
- tests.* : Those classes contain tests. You can add your own testing classes.

In the main project folder
- There are 6 examples of test suites.
- pom.xml : This is the Maven class. You can add/remove dependencies here.
- uploads folder : This folder contains uploaded files. You can add your upload files.
- screenshots folder: This folder contains all captured screenshots from executed tests.
- ExcelData folder : This folder contains Excel files that are used for tests (data-driven testing). You can add your Excel files here.
- drivers folder : This folder contains chromedriver.exe and geckodriver.exe. If you need to update the drivers you should put the new versions inside this folder. You can add more drivers for other browsers inside this folder.
- downloads folder : This folder contains all downloaded data from tests. You can use this folder to download automatically files using automation tests.

All other files and folders are system.