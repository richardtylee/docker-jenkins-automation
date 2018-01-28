# Jenkins Automation

This is an example project that illustrates how a Jenkins Docker container can run test automation by running another container.

## jenkins

jenkins is our automation server.  We start with a jenkins based image.  We then add `sudo`, so run commands as the root user, specifically the Docker client.  The container should run with `docker` and the Docker socket mounted as volumes.

## testapp

testapp is a simple Maven project.  We first use `archetype:generate` to generate a sample project.  We then added a Selenium test.

The Docker image starts with Maven. We then add Chrome and Chromedriver to power the Selenium test.

## Usage

WIP

