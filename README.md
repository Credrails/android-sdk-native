# Credrails Android Native SDK

The Credrails Android Native SDK allows you to interact with Credrails' APIs from your android native applications built with Java or Kotlin. This document provides a quickstart guide for adding the SDK to your android application, interacting with provided APIs and features provided by the SDK.

## Quickstart

Follow the steps below to get started using the SDK.

### 1. Integrate the SDK into your app using Maven

* In Android Studio (or your preferred IDE) open `your_app > Gradle Scripts > build.gradle (Project)` make sure the following repository is listed in the buildscript { repositories {} }:

        jcenter()

* Add the line `maven { url 'https://jitpack.io'}` to the `allprojects` section as shown below:

        allprojects {
            repositories {
                jcenter()
                maven { url 'https://jitpack.io' }
            }
        }

* Open your app's `build.gradle` at `your_app > Gradle Scripts > build.gradle (Module: app)` and add the following implementation statement to the `dependencies{}` section to depend on the Credrails SDK:

        implementation 'com.github.Credrails:android-sdk-native:0.1.0'

* Build your project.

### 2. Authorization

\
For simplicity we will be storing the API Key required to interact with the Credrails API in resource files, for production applications we encourage more secure strategies like using the [Android KeyStore API.](https://developer.android.com/training/articles/keystore.html)

* Open your `/app/res/values/strings.xml file`
* Add the following:

        <string name="credrails_api_key>[API_KEY]</string>

### 3. Create Session

\
All statement submissions must have an associated session Id. Use the code snippet below to request for a new session Id.

        val params = SessionParameters.Builder()
            .setUserReference("user-reference")
            .setEmail("johndoe@gmail.com")
            .setName("John Doe")
            .build();

        val sessionId = SessionsManager.createSession(params);

        // sample session Id: 7b2967c1-7d77-4c8c-808f-d74d1e155a4d

The call to `SessionsManager.createSession` returns a session Id. This Id is required for statement submission in subsequest steps.

### 4. List Institutions

\
Use the code snippet for listing available institutions below

    // get all institutions
    val institutions = SubmissionsManager.getInstitutions();

    // get institutions for country
    val institutions = SubmissionsManager.getInstitutions("countryCode");

The call to `getInstitutions` returns an array of institutions with the following parameters:

    code: string
    name: string
    country: string
    logo_url: string

    // A sample response is shown in JSON below

    [
        {
            "code": "ng.gtbank",
            "name": "Guaranty Trust Bank",
            "country": "ng",
            "logo_url" "https://api.credrails.com/banks/logos/gtb_ng"
        },
        {
            "code": "ke.equity",
            "name": "Equity Bank",
            "country": "ke",
            "logo_url" "https://api.credrails.com/banks/logos/equity_ke"
        }
    ]

#### 5. Submit Statement

\
Use the code snippet below to request for a customer statement

    val params = SubmissionsParameter.Builder()
        .setInstitution(1)
        .setUsername("username")
        .setPassword("password")
        .Build();

    val validationResult = SubmissionsManager.validate(params);

On successful validation a statement is generated and sent to a webhook or email address associated with the supplied API Key.
