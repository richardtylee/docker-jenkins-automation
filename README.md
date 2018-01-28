# Jenkins Automation

This is an example project that illustrates how a Jenkins Docker container can run test automation by running another container.

## jenkins

jenkins is our automation server.  We start with a jenkins based image.  We then add `sudo`, so run commands as the root user, specifically the Docker client.  The container should run with `docker` and the Docker socket mounted as volumes.

## testapp

testapp is a simple Maven project that we will use to run our tests.  We first use `archetype:generate` to generate a sample project.  We then added a Selenium test.

The Docker image starts with Maven. We then add Chrome and ChromeDriver to power the Selenium test.

## Usage

### Build

Build jenkins.

```
docker-compose build .
```

Build testapp and tag it as `latest`.

```
docker build -t testapp:latest testapp/. 
```

### Start Jenkins

```
docker-compose up
```

### Run testapp from Jenkins

1. Log into Jenkins
2. Click the “New Item” link.
3. Enter the item name (e.g. “run-testapp”), select “Freestyle project” and click OK.
4. On the configuration page, click “Add build step” then “Execute shell”.
5. In the command box enter: `sudo docker run -v /root/.m2:/root/.m2 testapp:latest`
6. Click “Save”.
7. Click “Build Now”.

With any luck, you should now have a green (or blue) ball. If you click on the ball and select “Console Output”, you should see something similar to the following:

## Resources
* [Running Docker in Jenkins (in Docker)](http://container-solutions.com/running-docker-in-jenkins-in-docker/)
* [How can I install selenium chrome driver in jenkins?](https://stackoverflow.com/a/45209039)