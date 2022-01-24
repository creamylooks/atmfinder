### Running the application
 Clone the repository from github
 1. Run `./gradlew clean build` to build the application


#### Running as a Jar
2. After running the command in step one above, run `java -jar ./build/libs/atmfinder-0.0.1-SNAPSHOT.jar` from the root directory


#### Running through Docker
2. After running the command in step one above run `docker build -t atmfinder .` from the root directory
3. Run `docker run -p 8080:8080 -p 8081:8081 atmfinder`

### Access Running Application
4. Navigate to `http://localhost:8080/swagger-ui/index.html` in your browser to view swagger page
5. Navigate to `http://localhost:8081/actuator` to access actuator endpoints

#### Troubleshooting
1. Use `docker ps` to check if the docker process is running and look out for something like `8080->8000/tcp` to confirm if it's port-forwarding from the docker to your local machine
