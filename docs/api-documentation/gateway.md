
# API documentation
1. microservices and each services with layered architecture



**short form**
- A - admin
- M - moderator
- U - user

## api gateway


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


## notification-service - later
**inbox message and email message service** 
**every event and admin message will be send on indox and email**
- send message (A/M)



## frontend



