


<!-- ABOUT THE PROJECT -->
## Hacker News - data processing

![Hacker News](https://upload.wikimedia.org/wikipedia/commons/a/ac/Hacker_News.png) 

Data from the hacker-news website are used in the present study.
We extracted around 15 years from this data dump, which includes only the stories  posted on the site hacker-news dating since the ninth of october 2006 all the way to the fourth of april 2021. This includes around four million unique stories posted.

Similar to other forums of this type, like Reddit, users can comment on the posted stories and they can upvote the articles if they find them accurate and worth reading.

This is represented in our dataset by the following fields:
* Descendants 
* Score 

The values are both Integers which represent the engagement of the users with the article.
Descendants tells us of the amount of users who commented on the article and Score informs us of the cumulative score the article managed to achieve. <br/>

The other information about the stories that we can extract from our dataset is:
* Title - String - The title of the story.
* URL - String - The URL of the hyperlink that leads to the story’s page.
* Text - String - The story’s text.
* By - String - Username of the user posting the story to the page.
* Time - Integer - Unix time of the posting.
* Timestamp - TIMESTAMP - Timestamp of the unix time.

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
   mvn clean install
   ```
3. Run "similar stories" main class
   ```sh
   mvn exec:java@similar-stories
   ```
4. Run "best time to post" main class
    ```JS
    mvn exec:java@best-time-to-post
    ```

### Plot results

1. Install requirements
   ```sh
   pip install -r requirements.txt
   ```
2. Plot "similar stories" results
   ```sh
   python main.py
   ```
3. Plot "best time to post" results
   ```sh
   python
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


_For more examples, please refer to the [Documentation](https://example.com)_


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





