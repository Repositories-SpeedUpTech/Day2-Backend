## TABLE OF CONTENTS
1. [PROJECT DESCRIPTION :herb:](#descripción-del-proyecto)
2. [TO CONSIDER :calling:](#a-tener-en-cuenta)
3. [PREREQUISITES :violin:](#prerrequisitos)
4. [EXECUTION :metro:](#ejecución)
5. [AUTHOR :man:](#autor)

***
# PROJECT DESCRIPTION: 
_It is a Framework written in Java and designed to simplify testing on REST-based services._

In this project we will take advantage of the advantages of this Framework for test automation and it will be used to test the various Endpoints of the following API: "https://angular-conduit-node.herokuapp.com/api/" :alien:

The **Endpoints** that will be tested are the following:

- :boom: Get: "https://angular-conduit-node.herokuapp.com/api/users", It serves to bring the information of the user that has been registered.
 
- :boom: Post: "https://angular-conduit-node.herokuapp.com/api/users", It is used to record user information.

- :boom: Post: "https://angular-conduit-node.herokuapp.com/api/users/login", It is used to log in the user.


***
# TO CONSIDER: 

In order to apply good practices, it was decided to use:

- :capital_abcd: ScreenPlay Pattern  

- :recycle: Object-oriented programming

***
# PREREQUISITES: 

In order to execute the project the following specifications are required:

|Herramienta| Versión| 
|:--------------|:-------------:|
|:heavy_check_mark: Java           |1.8            |
|:heavy_check_mark: Maven           |3.6.0            |
|:heavy_check_mark: RestAssured           |last Version            |


***
# EXECUTION:

It must be taken into account that to execute the tests that are in the features individually, it is necessary to run the corresponding Java classes. In our case we have the following relation for its execution:
#
|Clase Java (Runner)| Features| 
|:--------------|:-------------:|
|:soon: AddUserRunner.java |register.feature |
|:soon: LoginUserRunner.java |login.feature |
|:soon: GetUserRunner.java |getuser.feature |


#
On the other hand, if we want to execute all the features in parallel, we execute the following Java class:
#
|Java Class (Runner)| Features| 
|:--------------|:-------------:|
|:bangbang: AllUsersRunners.java| All features |
#
Finally, to reproduce the reports from the browser, the following steps must be followed:

:one: We go to the Target folder and unfold it

:two:  We deploy the "site" folder

:three: Right click on the "index.html" file, select the "Open in" option, then "Browser" and select the preferred browser.

***

### AUTHOR:

Ismael Alexander Carvajal González
