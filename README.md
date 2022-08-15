# Top-Charts
The app shows the top 100 music charts from the apple RSS generator.

General overview:

The app is written on Kotlin, and UI is done using JetPack compose 

There is the ability to provide environment variables:
* COUNTRY - Country from where to load a music chart
* LOAD_LIMIT - Number of items to load per request

Architecture(MVVM with Clean Architecture variation):

Every screen has a View Model.
There is a Repository, it consists of 2 data sources:
* local data source - Responsible for getting data locally using Realm
* remote data source - Responsible for getting data from server using Retrofit

App Features:

https://user-images.githubusercontent.com/10907085/184705082-0227a706-37c1-483f-a5ed-711fc1a7b380.mp4
- Basic app usage

https://user-images.githubusercontent.com/10907085/184703017-e0e4e677-14fa-41de-a5c5-930396823f59.mp4
- App launched first time by the user

https://user-images.githubusercontent.com/10907085/184703491-29d9ea7b-831d-4ac1-b74d-ae0bef695faa.mp4
- App display all music genres of the song

https://user-images.githubusercontent.com/10907085/184703386-711cceab-c39e-43e6-9da8-f6e03c8e99ed.mp4
- If the data load request failed, there is the ability to retry a request

https://user-images.githubusercontent.com/10907085/184703617-7df75e63-70e4-44fa-a8ed-0d9788a91cea.mp4
- Pull to refresh feature


https://user-images.githubusercontent.com/10907085/184703975-9829f6a6-2388-4614-8d35-b13dd1506847.mp4
- App works when there is no internet connectivity
