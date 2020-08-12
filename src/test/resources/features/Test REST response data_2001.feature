#Auto generated Octane revision tag
@TID2001REV0.3.0
Feature: Testing REST API 
	Users should have be able to submit requests to web service and receive response
    
	Scenario Outline: Submit request and receive response code 
		When user send a http request to the REST service "<url>" 
		And  the request has the method "<method>"
		Then the response status code is <status>  

	Examples:
	| url | method | status |
	| https://www.googleapis.com/books/v1/volumes/s1gVAAAAYAAJ | GET | 200 |
	| https://www.googleapis.com/books/v1/volumes/s1gVABXAYAAJ | GET | 404 |
