
# API documentation
1. microservices and each services with layered architecture



**short form**
- A - admin
- M - moderator
- U - user

## api gateway
**ServerURL**: `http://localhost:8080`
### unauthenticated user request 
- GET `/tools` : returns all tools
- GET `/company` : return all companies

### user request
- POST `/signup` : user signup
- POST `/signin` : user signin 
###

- GET `/tools` : get recommended tools
- GET `/tools/:toolId` : get tool by id
- POST `/tools/:toolId/comment/:userId` : post comment on tools
- GET `/tools/:toolId/comment/:userId` : get comments on tool
- POST `/tools/:toolId/comment/:commentId/upvote/:userId` : upvote comment
- POST `/tools/:toolId/comment/:commentId/downvote/:userId` : downvote comment
- GET `/tools/:toolId/like/:userId` : get likes on tool
- POST `/tools/:toolId/like/:userId` : post like on tool
###
- GET `/tools/search/:userId` : search tools by on different category in our website
- POST `/tools/prompt/:userId` : give prompt to user to search tools

### 
- POST `/company/:companyId/:userId` : follow the company 
- GET `/company/:companyId/:userId` : get company profile
- GET `/notifications/:userId` : get user by id
- POST `/notifications/reply/:userId` : replay to the server

**direct chat boot discussion** - may be websocket works


### admin request
- GET `/users` : get all users
- POST `/users/deactivate/:userId` : deactivate user
- POST `/users/activate/:userId` : activate user
- POST `/users/promote/:userId` : promote user as moderator
- POST `/users/demote/:userId` : demote user as moderator
###
- GET `/tools` : get all tools
- POST `/tools/create` : create tool
- POST `/tools/delete/:toolId` : delete tool
- POST `/tools/update/:toolId` : update tool
- POST `/tools/activate/:toolId` : activate tool
- POST `/tools/deactivate/:toolId` : deactivate tool
- POST `/tools/promote/:toolId` : promote tool as featured
- POST `/tools/demote/:toolId` : demote tool as featured
###
- POST `/tools/:toolId/comments/:commentId` : delete comment

### stats 
**public stats**: 
- GET `/stats/` : get public stats

**admin stats**:
- GET `/stats/admin` : get total users

## auth-service
- first implemented with jwt then oauth2 integration
- login
```
url: /login
request: 
{
    "username/email": "string",
    "password": "string"
}
response: 
{
    "token": "string",
} 
```
- signup
```
url: /signup,
request:
{
    "username": "string",
    "email": "string",
    "password": "string"
},
response:
{
    "token": "string",
}
```
- validate
```
url: /validate
request:
{
    "token": "string"
}
response:
{
    "isAuthenticated": "boolean",
    "isAdmin": "boolean",
    "isModerator": "boolean",
    "isUser": "boolean"

}
```

## moderation-service

**spring web, spring data jpa, crud operations of ai tools**

**first I have to done web scrapping servicve then i can fixed the service**


- create tool  (A/M)
```
url: /create-tool
request:
{
    
}
response: 
{

}
```
- update tool by id (A/M) 
```
url: /update-tool/{id}
request:
{

}
response: 
{

}
```

- get all tools (A/M)
```
url: /tools
request:
{

}
response: 
{
    tools: [tools]
}

```
- get public metaData (A/M/U)
```


```


- get tool by id (A/M/U)
```
url: /tools/{id}
request:
{
    
}
response:
{
    tool: tool
}

```
- delete tool (A/M)
```
url: /tools/{id}
request:
{

}
response:
{
    message: "tool deleted"
}
```
- deactivate tool (A/M)
```


```

- comment on tool (A/M/U)
```


```

- get comments on tool (A/M/U)
```


```
- delete comment on tool (A/M/U)
```


```
- like on tool (A/M/U)
```
url: /tools/{id}/like
request:
{
    "status": "boolean" 
}
response:
{
    message: "like added"
}

```

- dislike on tool (A/M/U)
```
url: /tools/{id}/dislike
request:
{
    "status": "boolean" 
}
response:
{
    message: "dislike added"
}

```

**implement rabbitmq channel for messaging from web-scrapping to api moderation for create tools"

** after web scrapping it will send admin moderator for approval**



## web-scraping-service
**automatic web scrapping from a website and save result on mongodb atlas**

**fast api or js server**
- create automatic trigger 


## recommendation-service
**suggest recommendated tools based on user preferences** 

**need to write a ml model or simple recommendation enginee**

- gerecommendations
```
url: /recommendations/:useId
request:
{

}
response: 
{
    "recommendedTools": [tools]
}

```

## prompt-parsing-service 

**build own prompt parsing service using nlp**

- parse prompt
```
url: /prompt
request:
{
    
}
response:
{
    "response based on pompt and ai api call"
}
```


## notification-and-feedback-service - later
**inbox message and email message service** 
**every event and admin message will be send on indox and email**
- send message (A/M)



## frontend



