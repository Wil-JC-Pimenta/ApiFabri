# Projeto FullStack - Aplicação de Consulta de Clima
## Este é um projeto fullstack que consulta a previsão do tempo para cidades utilizando uma API externa (Watherbit) e exibe os resultados em uma interface web desenvolvida com React. O backend foi construído com Spring Boot, enquanto o frontend foi implementado em React.

### Funcionalidades
* Exibe inicialmente informações do clima para a cidade de Coronel Fabriciano-MG.
* Consultar a previsão do tempo para qualquer cidade.
* Exibir dados climáticos como temperatura, umidade e velocidade do vento.
* Exibir sugestões de vestimenta com base na temperatura.

### Tecnologias Utilizadas

* Backend
  Java 17
  Spring Boot
  Maven
  OpenWeather API

* Frontend
  React
  Axios para fazer chamadas HTTP.
  CSS para estilização da interface.
*
Pré-requisitos:
Java 17 ou superior.
Node.js e npm (ou yarn) instalados.
Uma chave de API.


## Configuração do Backend
Clone o Repositório
git clone https://github.com/Wil-JC-Pimenta/ApiFabri.git

Entre no Diretório do Backend

Configure a Chave da API

Execute a Aplicação

Use o Maven para compilar e iniciar o backend:

mvn spring-boot:run

O backend estará disponível em: http://localhost:8080.

Endpoints
GET /weather?city={nomeDaCidade}: Retorna informações climáticas da cidade solicitada.

**********


## Configuração do Frontend

* Clone o Repositório

git clone https://github.com/Wil-JC-Pimenta/ApiFabri-Front-End.git

* Entre no Diretório do Frontend

* Instale as Dependências

npm install

* Inicie o Servidor de Desenvolvimento

npm start


### Exemplo de arquitetura de pastas:

projeto-fullstack-clima/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── br/com/fabriclima/apiFabri/
│   │   │   │       ├── controller/      # Controladores REST
│   │   │   │       ├── service/          # Serviços
│   │   │   └── resources/
│   │       └── application.properties   # Configurações de API
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   └── Weather.js               # Componente de clima
│   │   ├── App.js                       # Componente principal
│   ├── public/
│   │   └── index.html                   # Arquivo HTML principal
├── README.md




#### No arquivo src/main/resources/application.properties, adicione sua chave da API
