A. Require the softwares:
	1. Selenium version: 3.141.59
	2. Chrome browser version: 77.0.3865.75
	3. Chrome driver version: 77.0.3865.40
	4. OS: window 10
	5. Java version: '1.8.0_181'
	6. IDE: eclipse
	7. TestNG

B. Prepare environment:
	1. Open eclipse IDE
	2. Install TestNG in eclipse (if TestNG doesn't already exist) before importing "TestDemoProj" project.
		Link to guide for installing testNG: https://www.seleniumeasy.com/testng-tutorials/how-to-install-testng-step-by-step
	3. Download TestDemoProj from Github link: https://github.com/thuytnp/GoBearDemo
	4. Import the project into eclipse and wait to build libs successfully
	5. Create folder name "recordVideo" in D disk drive to save record video file: D:\recordVideo
		Note: You could change the path of record video file by changing value of RECORD_VIDEO_FILE_PATH variable at 39 line in DemoHappyCaseTest.java 

C. How to run the project:
	1. Option 1: Right click on testng.xml file  -> select Run As -> select TestNG Suite
	2. Option 2: Open DemoHappyCaseTest.java file in eclipse, right click  -> select Run As -> select TestNG Test
	3. After running successfully, Chrome browser will automate the test case.

D. How to watch the result: there are many ways listed such as below
	1. Open TestDemoPrj.log file in TestDemoPrj project to watch the log for step by step.
	2. Open index.html file in folder TestDemoPrj/test-output to watch result report or watch test result in console of eclipse.
	3. Open file in D:\recordVideo folder to watch the video.
	4. Go to the screenshots folder in TestDemoPrj to watch the screenshot images.

