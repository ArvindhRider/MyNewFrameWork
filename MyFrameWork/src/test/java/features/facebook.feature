Feature: Login to facebook page

Scenario: Testing positive scenario to login to fb
Given Initialize browser with chrome 
And navigate to "https://www.facebook.com/" pages
When user enters "username" and "password" in the fields
Then he should be able to login fb
