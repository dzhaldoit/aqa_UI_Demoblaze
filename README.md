<p align="center">
  <a href="https://demoblaze.com">
  <picture>
<img alt="Demoblaze" src="https://demoblaze.com/favicon.ico" width="70" height="70">
    </picture>
  </a>
</p>
<h1 align="center">
  Demoblaze tests
</h1>

## :pushpin: Содержание:
___
+ [Стек технологий](#briefcase-стек-технологий)
+ [Запуск автотестов](#bow_and_arrow-запуск-автотестов)
+ [Сборка в Jenkins](#-сборка-в-jenkins)

____
## :briefcase: Стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/icons/intellij-original.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/icons/github-original.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/icons/java-original.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/icons/gradle-original.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/icons/junit-original.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/icons/selenide-logo-big.png" width="50"/></a>
<a href="https://rest-assured.io/"> <img src="images/icons/restAssured.png" title="REST-assured" alt="REST-assured" width="50" height="50"/> </a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/icons/jenkins-original.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/icons/allureReports.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/icons/telegram.webp" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" title="Selenoid" src="images/icons/selenoid.svg"/></a>
</p>

___
+ IntelliJ IDEA - Интегрированная среда разработки программного обеспечения
+ Java - язык программирования, который был использован для написания автотестов
+ Selenide - фреймворк для написания автотестов
+ Selenoid - приложение, использованное для удаленного запуска браузеров
+ Allure Report - для формирования отчетов
+ Gradle - сборщик кода
+ JUnit - фреймворк для автоматического тестирования программ
+ GitHub - удаленный репозиторий для хранения кода
+ Jenkins - сервер для удаленного запуска тестов
+ Telegram - платформа для обмена сообщениями, куда будут приходить отчеты запуска тестов

___
**Содержание Allure-отчета:**
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :bow_and_arrow: Запуск автотестов
___
**Команда запуска тестов локально, из терминала**
```
gradle clean test -Dbrowser="Chrome100" -DbaseUrl="https://www.demoblaze.com"
```
---
**Для локального запуска необходимо**
+ Создать в папке <code>src/test/resources</code> auth.properties и remoteauth.properties
+ В auth.properties указать:
  + token=значение из cookie "tokenp_"
  + username=имя пользователя сайта
  + password=пароль от сайта
+ В remoteauth.properties указать:
  + remoteUser=логин от Selenoid
  + remotePass=пароль от Selenoid

## <a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/icons/jenkins-original.svg" width="50"/></a> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/aqa_UI_Demoblaze/)
**Шаги для запуска тестов:**
1. Зайти в сборку
2. Перейти в раздел <code>Собрать с параметрами</code>
3. Выбрать необходимые параметры
4. Нажать кнопку <code>Собрать</code>

<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkins-screen.png">
</p>

___
## <a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/icons/allureReports.png" width="50"/></a> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/aqa_UI_Demoblaze/1/allure/#)


<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReports-graphs.png">
</p>

<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReports-tests.png">
</p>

___

### <a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/icons/telegram.webp" width="50"/></a> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/telegram-screen.png">
</p>

### <a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" title="Selenoid" src="images/icons/selenoid.svg"/></a> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/video.gif">
</p>