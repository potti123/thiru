Feature: Gmail login
Scenario:Validate title
Given launch gmail site
Then title is "Gmail" value
And close site

Scenario Outline: Validate userid
Given launch gmail site
When enter userid with "<x>" value
And click next button
Then validate userid field with "<y>" criteria
And close site

Examples:
|   x                         |     y     |
| thirupathimstr123@gmail.com |  valid    |
| thirupathimstr124@gmail.com | invalid   |
|                             |  blank    |

