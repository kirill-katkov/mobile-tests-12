# Дипломный проект по автоматизации тестирования мобильного приложения Wikipedia. 

<img title="Main Gage" src="images/screen/wiki.jpg">

## :memo: Содержание:

- [Реализованные проверки](#boom-Реализованные-проверки)
- [Технологии](#classical_building-Технологии)
- [Сборка в Jenkins](#electron-Сборка-в-Jenkins)
- [Параметры запуска из jenkins](#electron-Параметры-запуска-из-jenkins)
- [Запуск из терминала](#electron-Запуск-тестов-из-терминала)
- [Allure отчет](#bar_chart-Allure-отчет)
- [Allure TestOps отчет](#bar_chart-Allure-TestOps)
- [Видео пример](#video_camera-Видео)

## :boom: Реализованные проверки

- ✓ Проверка текста на стартовом экране
- ✓ Проверка поля ввода BrowserStack
- ✓ Проверка поля ввода Microsoft и проверка Description
- ✓ Проверка экрана Настроить ленту
- ✓ Проверка онбординга


## :classical_building: Технологии

<p align="center">
<img width="6%" title="Idea" src="images/logo/Idea.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/Junit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Browserstack" src="images/logo/browserstack-icon.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">
<img width="6%" title="Allure Report" src="images/logo/AllureTestOps.png">
</p>

## :electron: Сборка в Jenkins
<img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>  <a target="_blank" href="https://jenkins.autotests.cloud/job/wiki-mobile_tests_katkov/">Jenkins job</a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/wiki-mobile_tests_katkov/"><img src="images/screen/jenkins-1.png" alt="Jenkins"/></a>
</p>

## :electron: Параметры запуска из jenkins

```
clean wikipedia "-DdeviceHost=browserstack"
```

## :electron: Запуск тестов из терминала

```
gradle clean wikipedia "-DdeviceHost=localhost"
```

## :bar_chart: Allure-отчет
<img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/wiki-mobile_tests_katkov/27/allure/">Allure report</a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/wiki-mobile_tests_katkov/27/allure/"><img src="images/screen/allure-1.png" alt="Jenkins"/></a>
</p>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/wiki-mobile_tests_katkov/27/allure/"><img src="images/screen/allure-2.png" alt="Jenkins"/></a>
</p>


## :bar_chart: Allure TestOps
<img src="images/logo/AllureTestOps.png" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://allure.autotests.cloud/project/1452/dashboards">Allure TestOps report</a>
<p align="center">
<a href="https://allure.autotests.cloud/project/1452/dashboards"><img src="images/screen/testops-1.png" alt="Jenkins"/></a>
</p>
<p align="center">
<a href="https://allure.autotests.cloud/project/1452/launches"><img src="images/screen/testops-2.png" alt="Jenkins"/></a>
</p>

## :video_camera: Видео
<p align="center">
<img src="/images/screen/video.gif" alt="video"/></a>
</p>
