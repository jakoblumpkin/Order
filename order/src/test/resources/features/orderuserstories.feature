Feature: Get orders from database
	As a User
	I want to get a specific order
	So that I can review it

Scenario Outline: Testing if user can receive orders
   Given Order Server is running
   When order receives a request with the orderNumber <orderNumber>
   Then that specific order should be returned


Examples:
| orderNumber |
| ORDER-123 |