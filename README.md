
# IceMuseum App

Sample application of Rijksmuseum with using latest android technologies which use Rijksmuseum API to get collections and show the detail of each one.

# TechStack:
1. Clean Architecture
2. Kotlin
3. MVVM
4. Single Activity Architecture
5. Jetpack Compose
6. Jetpack Compose navigation (one activity, zero fragments)
7. Hilt (DI)
8. Kotlin Coroutines
9. Use cases
10. Unit Tests
11. Kotlin Flow
12. Retrofit


# Welcome to Rijksmuseum! Please read
> Note : First of all, please join this Telegram channel https://t.me/IceMobileCICD; if you have a Telegram account or if you don't have one, please install it through https://telegram.org/ (it could take 1 minute at most) and join the channel. Because CI/CD flow will notify on this channel :)

The application contains two screens:
1) Collection List Screen :
   This is the main and first screen of the application which shows list of collections which received from Collections API. Also, this screen contains a search bar that makes you capable of searching collections through Collections API.
   List is endless, so you can load as mush as API can provide.

2) Collection Detail Screen :
   This is Collection(art) detail screen which is responsible for showing the detail of each clicked collection from the Collection List Screen like title, long title, principal/creator and description

> Note : According to The problem with collection detail API that always sends HTTP 500 status code, I created a hard-code fake data of three collections that extracted from Collections API and showed them by going to the Collection Detail screen by random.
##
- The application is provided by two variants (just to show experience with flavors) :
1) English version
2) Dutch version

   Which create a BuildConfig field with different values to pass to the Collections API to change the language of the results (they named culture).
##
- The application also has CI/CD flow:
    1) dev: this flow will launch whenever you push something to any branch (except master), which run written tests and build debug .apk files for all flavors to make sure everything is okay after push :)

    2) prod: this flow will launch whenever you push something to the master branch, which runs written tests make sure everything is okay and build release .apk and .aab files for all flavors ater push, also notify each step to the specified Telegram channel, so you don't need to observe all the steps by yourself. Just turn on your Telegram application notification to be notified about what is happening :)

  There are many approaches available to create scenarios to test, build and deploy. but I implemented with push into branches just to make it easier for interviewer.

- For securing the signing key and its passwords and alias, I used Github Secrets to specify the valid values. I read them during the CI/CD flow to sign the final application by adding them to the existing gradle.properties(which doesn't contain signing info).
  Also as the Rijksmuseum apikey is needed to work with the app in all branches and all the developers working on the project, So I specified it in local.properties file to make sure it will not push on any branch, but it is accessible to all the developers working on the project. As the local.properties file is added to gitignore, we can't use it during CI/CD flow, so I always generate a new one when Github action starts every time and add the value by reading it from Github Secrets.

  By these instructions, the whole process is secured, and all the accessibilities are handled.

# For Leonardo and Jan or to whom may read

This project is developed by the latest technologies in the Android platform; as you mentioned in the document to don't hesitate to show off. But in my opinion, after using these new technologies and according to my previous experiences with working on cutting edge technologies, I don't suggest using all the new things in a production application.
For example, I think Compose hasn't grown enough to use in production applications, especially with navigation-compose and navigation-compose-hilt.
I implemented all of them as well as possible to solve this project requirement. Also, this is not the base project that mostly I use for the production applications.
By the way, I just wanted to show you how can I implement a project using Clean Architecture and well-separated packages and use-cases. The technologies are replaceable :)
Last but not least I implemented some Unit tests that not covered all the buisiness logic.
I just did it to show you this is possible for me to write clean code which is testable. So as I had few time according to my current job, I couldn't implement more test cases.