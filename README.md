> >Proje ilk calıştıştıgında 1 defalık olarak database'e : identity nosu **"17838043128"** ve birthdate **"1998-04-18"** olan bir user ve buna ait kredi skor tablosu oluşturur.

#DOCKER-COMPOSE ile Çalıştırılması:
1. Ana dizinde bulunan docker-compose dosyasının bulundugu klosörde terminal acıp
```shell
docker-compose -p "yunussen-n11-app" up
```
komutunu calıştır.

> **⚠ WARNING:**  
> Port cakışmalarında console da yazan hataları takip edin.
# Swagger support:
>http://localhost:8080/swagger-ui.html

#PostgreSQL connection info:
<ul>
  <li>Maintenance database: n11_graduation</li>
  <li>Port: 5532</li>
  <li>host: localhost</li>
  <li>user: admin</li>
  <li>password: 123456</li>
</ul>

#Ide Üzerinden Proje Calıştırılması:
1. Postgre databasenin de ***n11_gradution*** adında db oluşturup application.yml dosyasında user ve password configuration yapılmalı.

#Ide üzerinden Test Case Calıştırılması

> **⚠ WARNING:**  
> intelijj file-> Project Structure-> Project PROJECT SDK 11 versiyon olarak ayarlanmalıdır.
    




