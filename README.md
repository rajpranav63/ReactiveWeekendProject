# ReactiveWeekendProject

###  Problem statement :
 
Store reddit from subreddit you're following and the posts you have done using java Rest API. Store those posts in mongoDB.
#### Then your database of tweets should be able to handle the following <br />
```
1)Find reddit post containing keyword given by user in the input
2)Delete reddit posts from x userName given by user in the input
3)Find all reddit posts of x userName given by user in the input
4)Sort all reddit posts based on timestamp of creation
5)Publish a reddit post from your account via code api
6)Post done from reddit should be stored in your database automatically if reddit hit you API when you post
```
Used **springdata framework** to integrate mongoDB, use gradle to build project. Used **jackson library** to store posts data received from reddit and convert to java bean.
Use **reactive mongoDB** and **reactive java** for the Project.

##### Reddit API used : - <br/>

###### For Feching reddit Posts  <br />
```https://oauth.reddit.com/best```

###### For Posting on reddit <br />

``` https://oauth.reddit.com/api/submit```
