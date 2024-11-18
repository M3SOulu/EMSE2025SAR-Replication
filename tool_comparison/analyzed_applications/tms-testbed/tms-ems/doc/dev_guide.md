# Development guide

## CMS

Configuration creation: CMS sends request for category info to QMS. Manager selectively chooses categories, languages, etc. New configuration is send to QMS. 

Configuration assignment: CMS assigns configuration ID to particular examinee with some date. CMS sends these data to EMS. EMS persists the data into database.

## EMS

Assignment list: all assignments associated with a particular user

Start exam: EMS requests from QMS all test questions and choices, persists them to database. EMS erases all fields indicating which choice is correct. 

Taking exam: While user is taking an exam, it sends selected choices to database. When the time is about to expire, javascript asks for result and redirects user. HTTP for selecting a choice is disabled by then. 