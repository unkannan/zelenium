Automation Scripts Execution Steps:
To execute test scripts please follow below steps:

1)	Install Java & maven and set their respective paths in system variables.
2)	Clone project (git clone https://github.com/unkannan/zelenium/tree/HomeBranch/ZyLabLibAutomation )
3)	Or Extract the zip file
4)	Open COMMAND PROMPT (cmd) 
5)	Navigate to the folder ‘ZyLabLibAutomation’
6)	Clean and compile project using
mvn clean compile
7)	To execute automation scripts, execute any of the following commands from command prompt:
i.	To execute all automation scripts (by default it will run on firefox) mvn test
ii.	To execute on particular browser, execute below command with parameter as 'firefox' or 'chrome'
mvn test -Dbrowser=<browser-name>
for e.g.: mvn test -Dbrowser=firefox
         or mvn test -Dbrowser=chrome
8)	Logs available in Log folder
9)	Test reports are available in below location
\target\test-output\emailable-report
\target\test-output\index.html
