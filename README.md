# Приложение «Мобильный хоспис»

## Порядок запуска автотестов
* Если у вас уже есть локальный репозиторий с Приложением «Мобильный хоспис», для избежания возможных проблем с совместимостью версий приложения и автотестов, возможных проблем с локальными изменениями в исходниках, и конфигурациях запуска, рекомендуется склонировать данный проект с автотестами в новую рабочую папку.
* Автотесты написаны под предоставленный исхдный код приложения, и прохождение автотестов на других сборках не гарантируется.
* Для провердения автотестирования необходимо наличия настроенного интернета на рабочей машине и тестовом устройстве.
* Во время проведения тестирования не рекоментуется проводить на устройстве другие работы, это может приводить к задержкам и паденям тестов.
### 1. Склонируйте проект в новую раочую папку
Android studio -> Menu-> File-> New-> Project from version control
### 2. Откройте Проект
### 3. Настройка тестовой среды
* Обновите (Установите) зависимости с помощью Gradle. Дождитесь окончания загрузки иконфигурации.  
* Запустите эмулятор Pixel 4 API 29 или подключите реальное устройство к Android studio.
При использовании реального устройства после подлючения устройства к рабочей станции с запущеным Android Studio на устройстве необходимо разрешить отладку по USB (если при подключении автоматически не появился попап с разрешением, можно включиьт вручную в меню разработчика)
* На устройстве (реальном или эмуляторе) необходимо установить русский язык (в соответствии с тест планом тестируется русскоязычная версия приложения)
Для телефона Huawei: Настройки телефона -> Система -> Язык и ввод -> Язык и регион -> Русский (Должен быть выбран)
Для эмулятора Pixel 4 API 29: главный экран -> свайп вверх -> Настройки -> Система -> Язык и ввод -> Перетянуть на первое место Русский, если его нет в списке, Добавить -> выбрать русский -> перетянуть на первое место

### 4. Запустите автотесты из пакета 
Путь в проекте: app/src/androidTest/java/ru/iteco/fmhandroid/ui/Tests
В панели навигатора во вкладке Project развернуть папки по указанному пути, правой кнопкой по папке Tests, вырбать пункт Run 'Tests in ru.iteco.f...'

### 5. Сбор Allure отчета о проходжении автотестов
* открыть Device File Explorer, выбрать устройство на котором выполнялись автотесты 
* из папки data/data/ru.iteco.fmhandroid/files/allure-results скопироавть в папку отчетов все имеющиеся файлы

### 6. Просмотр Allure отчета
Просмотр отчета из репозитория - распаковать архив и в папке с каталогом allure-results выполнить комманду: 
allure serve
