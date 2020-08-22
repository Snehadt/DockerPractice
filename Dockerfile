#FROM alpine
#ENTRYPOINT date


FROM openjdk:8u265-jre-slim-buster
WORKDIR /usr/dir/sneha
ADD target/selenium-docker-complier-tests.jar selenium-docker-complier-tests.jar
ADD target/selenium-docker-compiler.jar selenium-docker-compiler.jar
ADD target/libs libs
ADD duckDuckGo.xml duckDuckGo.xml
ADD flightBook.xml flightBook.xml

ENTRYPOINT java -cp selenium-docker-complier-tests.jar:selenium-docker-compiler.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testNg.TestNG $MODULE