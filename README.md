# MicroserviceRegistrationFlow
This registration flow consist of different microservices to complete
the flow. This flow contains several microservices to complete
the registeration flow.

# Sequence Diagram
![Sequence Diagram](images/sequenceDiagram.jpg "Sequece Diagram to show different microservices flows communication")


As you see in the above sequence diagram the third party App (it may anything
like webapp, mobile app or third party API). It will the request from it
and forward it to the reqisteration service, it will first send the event
to the Event publisher and save it into the database for future use.
Also, It will send the data to the main database to store the user data.

# Flow Diagram
The overall flow of these microservices' architecture is;

![Component Diagram](images/componentDiagram.jpg "Component diagram")

# Clone and Run the project
you can clone and run the project by cloning this project as;

    git clone https://github.com/Feezan-Khattak/MicroserviceRegistrationFlow.git

open you favorite editor and install the maven packages as

    mvn install


