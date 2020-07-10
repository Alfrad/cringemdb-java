<h1 align="center">
    <img height="50"  alt="Unofficial Java API" src="https://cringemdb.com/img/logo.svg" />
    <h2 align="center" >Cringemdb-Java - Unofficial API crawler based.</h2>
</h1>

**Pull requests are welcome!**

A Java crawler application to extract basic informations from [Cringemdb.](https://cringemdb.com/) Using [retrofit 2](https://square.github.io/retrofit/) and [webmagic 2](http://webmagic.io/en/)

## Usage
<a href="https://search.maven.org/search?q=cringemdb-java">Available on Maven Central</a>

Add the following dependency to your Gradle project:

```groovy
implementation 'io.github.alfrad:cringemdb-java:1.0.1'
```

or your Maven project:

```xml
<dependency>
    <groupId>io.github.alfrad</groupId>
    <artifactId>cringemdb-java</artifactId>
    <version>1.0.1</version>
</dependency>
```

You can use the application like:

```java
try {
    String nameAndYearOfMovie = ??? // Pattern: Name of Movie (year)
    CringemdbVO resumeFromCringemdb = 
        Cringemdb.getInstance()
            .getCringemdbService()
            .getResumeFromCringemdb(nameAndYearOfMovie);
} catch (CringemdbNotFoundException e) {
	//means the movie not found in cringemdb.com
} catch (IOException e) {
	//retrofit exception
}
```

## License

Created by [Alfrad](https://www.instagram.com/kelissonj/).
See full [list of contributors](https://github.com/Alfrad/cringemdb-java/graphs/contributors).
