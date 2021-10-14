# API docs with swagger [![Awesome](https://awesome.re/badge-flat.svg)](https://awesome.re)

## :clipboard: Introduction

[Swagger](https://es.wikipedia.org/wiki/Swagger_(software)) set of tools for designing, building, documenting, and using RESTful web services. Check his strength in [Swagger I/O](https://swagger.io/).

## :cloud: Getting Started

Follow along this notes. You can use some package management tool for windows. E.g. [Chocolatey](https://chocolatey.org/install)

### For a local deploy

You will need to have at least [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) installed or some openJDK distribution, and [Gradle](https://gradle.org/) on the PATH. 

*	[OpenJDK8 Zulu](https://azul.com) - Java Development Kits (OpenJDK build)

```
choco install zulu8 -y
```

*	[Gradle](https://gradle.org/) - Constructor and manager dependencies

```
choco install gradle --version 5.6.4 -y
```

### For a docker deploy

*	[Docker Desktop](https://www.docker.com/products/docker-desktop) - Application virtualizer for windows
```
choco install docker-desktop -y
```
_NOTE: Register in [Docker Hub](https://hub.docker.com/) to be able to use the docker registry_

> To know the API documentation technique.

## :computer: Commands to execute

### For a local execution

```
gradle build
gradle bootRun
```

And access in [local-swagger-ui](http://localhost:8080/swagger-ui/)

### For a docker execution

```
docker-compose up -d --build
```

And access in [docker-swagger-ui](http://localhost:9090/swagger-ui/)


## :octocat: Can you support me?

I will continue to do things and expose notes, but existing many ways to support what I do:
* Pull requests are welcome a :dizzy:
* Don't forget to give this Repository a :star2:
* <a href="https://www.buymeacoffee.com/pedringcoding" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/purple_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

