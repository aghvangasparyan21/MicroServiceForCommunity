# Microservice for Community Controllers
This repository contains the implementation of three controllers for the Microservice for Community project. Each controller handles specific functionalities related to communities, residents, and parking.

## CommunityController
This controller handles operations related to communities.

## API Endpoints
## Create Community
Method: POST
Path: /community
Request Body: Community object
Description: Creates a new community and saves it using the CommunityService.
Returns: The created Community object.

## ResidentController
This controller handles operations related to residents.

## API Endpoints
## Create Resident

Method: POST
Path: /community/resident
Request Body: Resident object
Description: Creates a new resident and saves it using the ResidentService.
Returns: The created Resident object.
Join Resident to Community

Method: POST
Path: /community/resident/join/{residentId}/{communityId}
Path Variables:
residentId: Long - ID of the resident
communityId: Long - ID of the community
Description: Associates a resident with a community by joining them. Uses the ResidentService to perform the operation.

## ParkingController
This controller handles operations related to parking.

## API Endpoints
## Create Parking

Method: POST
Path: /community/resident/parking
Request Body: CreateParkingRequest object
Description: Creates parking for a community and saves it using the ParkingService.
Returns: The created Parking object.
Book Parking

Method: POST
Path: /community/resident/parking/book/{residentId}/{parkingId}
Path Variables:
residentId: Long - ID of the resident
parkingId: Long - ID of the parking
Description: Books a parking spot for a resident. Uses the ParkingService to perform the operation.

## Dependencies
The controllers utilize various services to handle the business logic and data operations. These services are injected into the controllers using the @Autowired annotation.
For detailed implementations of the services, refer to the respective service classes.
Please note that this documentation provides an overview of the functionality provided by the controllers. For detailed information about the request and response structures, please refer to the corresponding Java classes in the source code.

This concludes the documentation for the Microservice for Community controllers.
