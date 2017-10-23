FROM library/openjdk
ADD /build/libs/RestWSWithSpringBoot-0.0.1-SNAPSHOT.jar /opt/dockerdemo/
CMD ["java", "-jar", "/opt/dockerdemo/RestWSWithSpringBoot-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081