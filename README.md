
Framework built with Following tech stack
Java
Selenium 3+
Cucumber
Maven

How to run the test ?
Clone the repostory locally (git clone https://github.com/vimala11/)

create a Junit Runner with following VM options (Framework supports running tests using latest firefox and chrome browsers)

Runner Class to be selected is : com.thiran.CucumberRunner
-Dbrowser=chrome -Dcucumber.options="--tags @test"

Driver Executables:
GeckoDriver and ChromeDriver executable places inside /src/test/resources/drivers folder

PageFactory model used to initialise locators.
