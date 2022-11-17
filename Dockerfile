FROM openjdk:11

COPY . .

RUN ./mvnw clean package

EXPOSE 8090


CMD ./mvnw exec:java