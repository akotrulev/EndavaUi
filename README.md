# Environment
- Java 21
- gradle 8.14.3
- allure report 2.34
- latest browser version

# IntelliJ
- Set IntelliJ IDEA as test runner
  - Go to settings -> build, execution, deployment -> gradle -> Run tests using and change it to "IntelliJ IDEA"

# Configuration
- Open system.properties file and set the url as well as browser type
# Running tests
1. Manually from IDE
    - set gradle test runner to IntelliJ (or IDE of choice) so it uses testng
2. FatJar
    - ./gradlew clean fatJar
    - java -jar EndavaUi-all-1.0-SNAPSHOT-tests.jar -testjar EndavaUi-all-1.0-SNAPSHOT-tests.jar -xmlpathinjar suite.xml -groups Smoke

