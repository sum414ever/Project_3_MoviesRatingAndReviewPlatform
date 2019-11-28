Movies rating & review platform
===
Technical Documentation
---

This platform allows end-user to share an opinion(review) and vote for the particular movie. Also it is possible to get movies list by rating and category.

---
Requirements: 
---
>“Movie” structure with next parameters: Id, name, category, director, short description, rate value. 
>
>“Category” should be returned to an end-user in human-readable format (not like SCI_FI but “Science fiction”). But in DB >should be saved as SCI_FI.
>
>“Rate” structure should have rate value, count of votes. Rate value in range: 1 to 10.
>
>“Review” structure should have: ID of a movie, review message,  liked or not (true, false).

---
API requirements:
---
>/admin/movie POST -  add movie to list
>
>/admin/movie/{id} DELETE - remove movie by id
>
>/admin/movie/{id} POST - update info about movie
>
>/movie/{id} GET — get info about particular movie including reviews
>
>/review/movie/{id} PUT - add review to movie
>
>/movie/rate POST - add rate to a movie
>
>/movie/all GET - get a list of all movies. (Name, category, rating. Without reviews)
>
>/stats/rating GET - get movies list by rating (from highest / lowest optionally)
>
>/stats/category GET - get movies list by category
