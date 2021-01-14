
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->


<!-- [![Contributors][contributors-shield]][contributors-url] 
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url] -->
[![MIT License][license-shield]][license-url]
<!-- [![LinkedIn][linkedin-shield]][linkedin-url] -->



<!-- PROJECT LOGO -->
<br />
<!-- <p align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a> -->

  <h3 align="center">Template-Based Code Generation</h3>
<!-- 
  <p align="center">
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"> 
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>
</p> 
-->

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <!-- <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li> -->
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<!-- [![Product Name Screen Shot][product-screenshot]](https://example.com) -->

This project shows us an example how we can create template-based code generation with the tool named Telosys-CLI ( this is another Java Project). In order for providing the tool easily, one can check the folder named /lib out.

### Built With

You need to build jar file from the source code or if you have the jar package file, you can easily look at the section called Usage.
* [Telosys-CLI](http://www.telosys.org/download/telosys-cli/)
* [Java](https://www.java.com/en/)


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.

### Prerequisites

At least Java 8 JRE and JDK should be installed. 

### Installation
Download the jar file from the website. 

## Usage

Please type the following command for the jar package: 

   ```java -jar telosys-cli-3.2.2-001.jar;```

And you can follow the sample scenario. To set up a home directory for the project, please type as below
``` h /Users/username/Desktop/Projects/OpenSource/Compiler_Design/telosys_firsttest```

To initialize a project template, please type as below: 

```init```

You will see the following screen on the console 

```Project initialization 
Project folder : '/Users/username/Desktop/Projects/OpenSource/Compiler_Design/telosys_firsttest' 

. folder 'TelosysTools' created
. folder 'TelosysTools/downloads' created
. folder 'TelosysTools/lib' created
. folder 'TelosysTools/templates' created
. file 'databases.dbcfg' created. 
. file 'telosys-tools.cfg' created. 
```
Create an entity and named as *role* as below: 
```nm role```
```ne role``` --> Role entity creation for the project.

Under the folder called role_model/Role.entity, there is an entity file and you can organize it as below: 

```// Entity Role

Role {
  myfield : string ; // field example 
  id : int {@AutoIncremented, @Id};
  creationDate: date; 
  relationship: string; 
}
``` 
List all bundles that you can download from the github page. 

```lgh ```

The Screen is like in the following console output. 

```
Bundles found in GitHub store 'telosys-templates-v3' : 
 . advanced-templates-samples-T300
 . angular4-rest-frontend
 . basic-templates-samples-T300
 . csharp-web-mvc
 . database-doc-T300
 . java-domain-T300
 . java7-commons-T300
 . java7-persistence-commons-T300
 . java7-persistence-commons-jpa-T300
 . java7-persistence-jdbc-T300
 . java7-persistence-jpa-T300
 . java7-persistence-mongodb-T300
 . java7-persistence-redis-T300
 . java7-persistence-spring-data-jpa
 . java7-web-mvc-spring-T300
 . java7-web-rest-jaxrs1-T300
 . java8-commons-T312
 . java8-web-rest-jooby-T312
 . javascript-web-rest-nodejs-express
 . php7-web-mvc
 . python-persistence-sqlalchemy
 . python-web-mvc-bottle
 . python-web-rest-bottle
 . qualif-and-debug-T300
 . web-rest-postman
 . web-rest-soapui-T312
```
Download all package with the following command: 

```ib java```

An then please select a bundle. 
```ib java8-commons-T312```

Final step is to generate: 
```gen * * -r```

In the /src folder, you can find the generated files. 

<!--
## Roadmap

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of proposed features (and known issues). -->



<!--
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
-->


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.


<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Telosys-Tool](http://www.telosys.org/download/telosys-cli/)
* [Telosys-Blog](https://dzone.com/articles/telosys-a-code-generation-tool-by-laurent-guerin)





<!-- MARKDOWN LINKS & IMAGES -->
<!--
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues -->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/zointblackbriar/Java_Examples/tree/master/Template-based-code-generation/LICENSE.txt
<!-- [linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555 -->
<!-- [linkedin-url]: https://linkedin.com/in/othneildrew -->
<!-- [product-screenshot]: images/screenshot.png -->

