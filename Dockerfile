# Используем базовый образ OpenJDK для Java 11
FROM openjdk:17-jdk-slim

# Устанавливаем переменные окружения для токена VK API и версии VK API
ENV VK_API_TOKEN="your_vk_api_token" \
    VK_API_VERSION="5.236"

# Устанавливаем переменную окружения для указания на директорию приложения
ENV APP_HOME /app

# Создаем директорию для приложения
RUN mkdir $APP_HOME

# Копируем JAR файл в директорию приложения внутри образа
COPY target/SimpleVkBotForJustAl-0.0.1-SNAPSHOT.jar $APP_HOME/SimpleVkBotForJustAl-0.0.1-SNAPSHOT.jar

# Указываем рабочую директорию
WORKDIR $APP_HOME

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "SimpleVkBotForJustAl-0.0.1-SNAPSHOT.jar"]
