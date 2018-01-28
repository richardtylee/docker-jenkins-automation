FROM jenkins/jenkins:lts

# Set user root to allow us to install the rest of what's needed
USER root

RUN apt-get update \
      && apt-get install -y sudo
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

# Set user back to jenkins
USER jenkins
