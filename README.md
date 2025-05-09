
# 🎮 SindromedoPcGamer.api

Este é um projeto backend em **Java + Spring Boot**, desenvolvido como parte de um sistema de recomendação de jogos.  
A aplicação oferece endpoints RESTful para **manipulação e consulta de jogos**, incluindo recomendações baseadas em palavras-chave e integração com uma API externa gratuita de jogos.

---

## 👤 Integrante

- **Hian Rick Francesconi Macedo**

---

## 📦 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven

---

## 🌐 API Externa Utilizada

### 🆓 FreeToGame API

> Access programmatically the best free-to-play games and MMOs!  
Welcome to the FreeToGame API – a free and open REST API providing access to a comprehensive database of free PC and browser games, including genre, platform, developer, and much more.

📎 [Documentação oficial da FreeToGame](https://www.freetogame.com/api)

**Exemplo de dados fornecidos:**

```json
{
  "id": 582,
  "title": "Tarisland",
  "short_description": "A cross-platform MMORPG developed by Level Infinite and Published by Tencent.",
  "developer": "Level Infinite",
  "release_date": "2024-06-22"
}
```

---


### 🎮 Entidade `Jogos`

```java
public class Jogos {
    private Long id;
    private String title;
    private String short_description;
    private String developer;
    private String release_date;
    private List<String> palavrasChave; // campo adicional interno
}
```

---

## 📚 Documentação da API

### 🔍 1. Listar todos os jogos  
**GET** `/jogos`

**Resposta:**

```json
{
  "id": 582,
  "title": "Tarisland",
  "short_description": "A cross-platform MMORPG developed by Level Infinite and Published by Tencent.",
  "developer": "Level Infinite",
  "release_date": "2024-06-22"
}
```

---

### 🔎 2. Buscar jogos por desenvolvedor  
**GET** `/jogos/developer/{nome}`

**Exemplo:** `/jogos/developer/Gaijin Entertainment`

**Resposta:**

```json
{
  "id": 12,
  "title": "War Thunder",
  "short_description": "A MMO shooter that puts you in command of hundreds of the finest combat vehicles of World War II.",
  "developer": "Gaijin Entertainment",
  "release_date": "2013-08-15"
}
```

---

### 📅 3. Buscar jogos por ano de lançamento  
**GET** `/jogos/ano/{ano}`

**Exemplo:** `/jogos/ano/2009`

**Resposta:**

```json
{
  "id": 281,
  "title": "Grand Fantasia",
  "short_description": "A free to play anime inspired 3D MMORPG with customizable characters and companions.",
  "developer": "X-Legend Entertainment",
  "release_date": "2009-12-01"
}
```

---

### ➕ 4. Adicionar novo jogo  
**POST** `/jogos`

**Body (JSON):**

```json
{
  "id": 1000,
  "title": "The Saboteur",
  "short_description": "The Saboteur is an action-adventure game set in an open world environment and played from a third-person perspective.",
  "developer": "Pandemic Studios",
  "release_date": "2009-12-09"
}
```

**Resposta:** Código 201 Created com o jogo salvo.

---

### 💡 5. Recomendação por palavras-chave  
**POST** `/jogos/recomendar`

**Body (JSON):**

```json
["open-world"]
```

**Resposta:**

```json
{
  "id": 475,
  "title": "Genshin Impact",
  "short_description": "If you’ve been looking for a game to scratch that open-world action RPG itch, one with perhaps a bit of Asian flair, then you’re going to want to check out miHoYo’s Genshin Impact.",
  "developer": "miHoYo",
  "release_date": "2020-09-28"
}
```

---

### 📝 6. Informações sobre o projeto  
**GET** `/sobre`

**Resposta:**

```json
{
  "integrantes": ["Hian Rick Francesconi Macedo"],
  "nome_projeto": "SindromedoPcGamer.api"
}
```

---

## 📄 Licença

Este projeto é de uso **acadêmico**, sem fins lucrativos ou comerciais.

