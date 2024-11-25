#[URL-Shortener](https://roadmap.sh/projects/url-shortening-service)
Provide the transformed short URL from a Long URL

## Example

- Original URL: `https://stackoverflow.com/questions/79223726/google-oauth2-retrieve-custom-user-parameters`
- Shortened URL: `http://localhost:8080/shorten/U349FN`

## Installation and Running

1. Clone the repository
2. Create a Database in MYSQL using "CREATE SCHEMA `urlshorteneru` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci; "
3. Run in Intellij

Exposed API's
1. (POST) http://localhost:8080/shorten --- Create Short URL
2. (GET) http://localhost:8080/shorten/{shortcode} -- Get Original Link
3. (PUT) http://localhost:8080/shorten/{shortcode} -- Update URL
4. (DEL) http://localhost:8080/shorten/{shortcode} -- Delete URL
5. (GET) http://localhost:8080/shorten/{shortcode}/stats -- Get access count of that URL
