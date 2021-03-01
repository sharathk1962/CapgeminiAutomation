# CapgeminiAutomation

I have used pageobjects package to store all webelements which can be used in our script.

In resources folder have kept base class which does launch the Web browser- it is a genric method. And also Properties file which provide url and browser.

Report you can access from- E:\Eclipse - workplace\Automation\test-output\index.html
For the reporting purpose I have used inbuilt TestNG reports- however we can use extent reports for more stylish and proper data report.

Have created seperate folder for all the drivers and for all the logs.

TestNG.xml provide the information which are Tests has to be run

POM.xml - is project object module in which we trigger all our scripts- it downlaods all the required dependecies from Maven repository

