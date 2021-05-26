


<!-- ABOUT THE PROJECT -->
## Hacker News - data set description

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



Dataset source: [Hacker News Dataset](https://console.cloud.google.com/marketplace/product/y-combinator/hacker-news?project=sanguine-robot-310510&folder=&organizationId=)





