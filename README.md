
# Shorter Url

This project is an API made to shorten urls, using **Java, Java Spring, MongoDb with database**.




## Installation

- Clone the repository

- Install dependences with maven

- Install MongoDb server





#### Create Shorter Url

```http
  POST localhost:8080/urlShorter
```

| Parameter | Return     | Description                |
| :-------- | :------- | :------------------------- |
| `url` | `UrlModelResponse and 201 created or 400 bad request` | Create a shorter url |

#### Retrieve Original Url

```http
  GET localhost:8080/urlShorter/{shortUrl}
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| ``      | `UrlModelResponse and 200 ok or 404 not found ` | Retrieve the original url from a short url |

#### Update Url

```http
  PUT localhost:8080/urlShorter/{shortUrl}
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `New Url` | `UrlModelResponse and 200 ok or 400 bad request` | Update an existing short url |

#### Delete Short Url

```http
  DELETE localhost:8080/urlShorter/{shortUrl}
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| ``   | `204 no content or 404 not found` |Delete an existing short url|

#### Show Url Statistics 

```http
  GET localhost:8080/urlShorter/{shortUrl}/stats
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| ``   | `UrlModel and 200 ok or 404 not found` |Get statistics for a short url |




## Authors

- [@dmarqss](https://github.com/dmarqss)

