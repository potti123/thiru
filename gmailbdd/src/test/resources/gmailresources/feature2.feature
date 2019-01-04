Feature: Gmail login
Scenario Outline: Validate password
Given launch gmail site
When enter userid with "thirupathimstr123" value
And click next button
And enter password with "<p>" value
And click password next button
Then validate password with "<pc>" criteria
And close site

Examples:
|    p      |     pc     |
|9492266105t| valid      |
|9492266105v| invalid    |
|           | blank      |