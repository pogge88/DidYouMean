# DidYouMean

A simple Levenshtein Distance Tool

## Getting Started

This tiny library will make it possible to extend your search behaviour. It simply checks 
a word against a list of words and returns the word with the shortest distance.

### Installing

To use DidYouMean create an Instance by using the Builder.
```
DidYouMean subject = DidYouMean.Builder(Arrays.asList("Hammer","Chair","Wheel")).build();
```

Configured like that you are able to say:

```
String word = didYouMean.find("Hammr").get().getWord();
```

Its important to mention that the `find()` method returns a Java 8 Optional. 
This Optional is containing a `Result` and you can get the actual word and information about the distance.

If you want to use DidYouMean in Spring context you simply could create a `@Bean` like that:
Spring will make it inject it in Singleton Scope where ever you need it.

```
@Bean
public DidYouMean init(){
    return new DidYouMean.Builder(Arrays.asList("Hammer","Chair","Wheel")).build();
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Markus Poggenburg** - *Initial work* - [PurpleBooth](https://github.com/pogge88)

See also the list of [contributors](https://github.com/pogge88/DidYouMean/graphs/contributors) who participated in this project.

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

## TBA

* Better Spring integration
* different word sources
* support of sentences.
