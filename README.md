# Alicia

Alicia er vefkerfi sem leyfir innsendingu nemanda og yfirferð kennara á heimaverkefnum í formi frumkóða.

Aðal inntak verkefnisins er að leyfa skilvirkari og einfaldari yfirferð á verkefnum en núverandi kerfi leyfa. 
Það er gert með samanburði á nemendalausnum og sýnislausn og er lausnunum raðað upp með tilliti til fjarlægð þeirra frá sýnislausn.

### Installing

The backend is a Spring webserver.
```
git clone https://github.com/steina1989/Alicia.git
cd Alicia
mvn spring-boot:run
```
The path to it's data is 
```
localhost:8080/api
```

For front end development, open another terminal in the root directory. 
```
cd front/
npm install
npm start
```
A proxy has been configured to communicate with the Spring server.
