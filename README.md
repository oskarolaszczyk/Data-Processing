


<!-- ABOUT THE PROJECT -->
## Hacker News - data processing

![Hacker News](https://upload.wikimedia.org/wikipedia/commons/a/ac/Hacker_News.png) 

Dataset is described in this [section](https://github.com/Problem-Workshop/Data-Processing/tree/master/data_processing/src/main/resources/Data)

Using this data we will try to answer next questions:
* When is the best time to post stories?
* Are similar stories similarly scored and commented?



### Built With
* [Java](https://java.com/pl/)
* [Maven](https://maven.apache.org)
* [Python](https://www.python.org)
* [OpenCSV](http://opencsv.sourceforge.net)
* [Snowball](https://snowballstem.org)
* [Jackson](https://github.com/FasterXML/jackson)
* [OpenNLP](https://opennlp.apache.org)


<!-- GETTING STARTED -->
## Getting Started

### Installation

1. Clone the repo
   ```sh
   git lfs clone https://github.com/Problem-Workshop/Data-Processing.git
   ```
2. Maven clean and install
   ```sh
    _JAVA_OPTIONS="-Xmx10G" mvn clean install
   ```
3. Run "similar stories" main class
   ```sh
   _JAVA_OPTIONS="-Xmx10G" mvn exec:java@similar-stories
   ```
4. Run "best time to post" main class
    ```JS
    _JAVA_OPTIONS="-Xmx10G" mvn exec:java@best-time-to-post
    ```

### Plot results

1. Install requirements
   ```sh
   pip install -r requirements.txt
   ```
2. Plot "similar stories" results
   ```sh
   python similar_stories
   ```
3. Plot "best time to post" results
   ```sh
   python best_time_to_post
   ```

## Software organization into modules/packages/classes
* **knn** - package with all necessary classes for k nearest neighbors. There are metrics here and classes for computing text distance. 
* **timestamp_analysis** - package to analysis best time to post 
* **model** - package with all model files (for the moment we have only class for Story)
* **dao** - data access object, intended for reading and downloading files
* **utils** - package with utilities
* **exceptions** - package for all exceptions 

<!-- USAGE EXAMPLES -->
## Usage
![Image 1](data_processing/results/knn/score.jpg)
![Image 2](data_processing/results/knn/comments.jpg)
![Image 3](data_processing/results/best-time/Average.png)
![Image 4](data_processing/results/best-time/TopStoriesAverage.png)

_For more examples, please refer to the [Documentation](https://docs.google.com/document/d/1UFls-4eaG2nJ6IP4VzNljtvK4HCIsFnN51XXb1WRsVE/edit?usp=sharing)_


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Organization - [@Problem-Workshop](https://github.com/Problem-Workshop) <br/>

### Contributors
Oskar Olaszczyk - [@oskarolaszczyk](https://github.com/oskarolaszczyk) <br/>
Julia Szymańska - [@JuliaSzymanska](https://github.com/JuliaSzymanska) <br/>
Przemysław Zdrzalik - [@ZdrzalikPrzemyslaw](https://github.com/ZdrzalikPrzemyslaw) <br/>
Szymon Jacoń - [@bruderooo](https://github.com/bruderooo) <br/>
Michał Majchrowski - [@DevWithoutKnowledge](https://github.com/DevWithoutKnowledge) <br/>
Kamil Kiszko-Zgierski - [@KiszczixIsCoding](https://github.com/KiszczixIsCoding) <br/>
Hubert Gawłowski - [@hubertgaw](https://github.com/hubertgaw) <br/>
Martyna Piasecka - [@MartynaCys](https://github.com/MartynaCys) <br/>

Project Link: [https://github.com/Problem-Workshop/Data-Processing](https://github.com/Problem-Workshop/Data-Processing)





