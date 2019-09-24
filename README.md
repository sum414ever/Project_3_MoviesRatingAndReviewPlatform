My JSONs

First add some movies to list

[POST] http://localhost:8080/admin/movie

{  
    "name": "Citizen Kane",  
    "category": "drama",  
    "director": "Orson Welles",  
    "description": "Story is told through the research of a newsreel reporter seeking to solve the mystery of the newspaper magnate's dying word: Rosebud.",  
    "rate": {  
        "avgRate": 9,  
        "countVotes": 3729
    } 
} 

{  
    "name": "The Godfather",  
    "category": "crime",  
    "director": "Francis Ford Coppola",  
    "description": "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son",  
    "rate": {  
        "avgRate": 10,  
        "countVotes": 5789
    } 
} 

{  
    "name": "Casablanca",  
    "category": "adventure",  
    "director": "Michael Curtiz",  
    "description": "A cynical American expatriate struggles to decide whether or not he should help his former lover and her fugitive husband escape French Morocco.",  
    "rate": {  
        "avgRate": 7,  
        "countVotes": 1515
    } 
} 


remove movie by id

[DELETE] http://localhost:8080/admin/movie/{id}

add review 
[POST] http://localhost:8080/review/movie

{  
   "movieId" : "",
    "reviewMessage" : "Some message",
    "liked" : "true"
} 

get info about particular movie including reviews
[GET] http://localhost:8080/movie/{id}

get movies list by highest rating  
[GET] http://localhost:8080/movie/stats/rating/highest

get movies list by lowest rating  
[GET] http://localhost:8080/movie/stats/rating/lowest