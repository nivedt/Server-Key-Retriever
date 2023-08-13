# Server-Key-Retriever

Server Key Retriever or Remote Key Manager is an innovative project designed to facilitate efficient communication between clients and a remote server. The project revolves around fetching a unique key from the server and empowering clients to perform essential CRUD operations on the associated data.

## How to install this project

1. Clone this project
2. Import this project into the SpringBoot
3. Run it as a SpringBoot Application from a Java file named ServerKeyRetrieverApplication.java
4. The above mentioned file can be obtained from server-key-retriever -> src -> main -> java -> com -> ttechlab -> generate_Fetch_Key -> ServerKeyRetrieverApplication.java

## How to tweak this for your own purpose
1. After running this project as a Java application
2. Collect the key got from the console
3. Now, run the respective client as an Application. For example, you want to perform a GET CRUD operation. Run the RestGetClient from service folder
4. You can get the RestGetClient from server-key-retriever -> src -> main -> java -> com -> ttechlab -> generate_Fetch_Key -> service -> RestGetClient
5. Same goes to the rest of the CRUD operations
