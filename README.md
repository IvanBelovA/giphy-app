## Описание

Данный сервис, обращается к сервису курсов валют, и отображает gif:<br>
             • если курс по отношению к USD за сегодня стал выше вчерашнего, то на экране отображается гифка с тегом "rich"<br>
               • если ниже - то с тегом "no money"<br>
Сервис доступен по адресу: http://localhost:9000/giphy-app/<br>
<br>
Также доступен API. EndPoint для получения gif: <br>
GET: http://localhost:9000/giphy-app/api/random-gif?currency=COMPARED_CURRENCY<br>
COMPARED_CURRENCY = RUB, EUR, CNY или INR

## Стек

Используемые технологии:

- Java
- Spring boot
- JavaScript
- Twitter Bootstrap
- HTML
- Thymeleaf
- Maven
- Spring Cloud OpenFeign
