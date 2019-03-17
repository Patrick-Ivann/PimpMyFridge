#include "DHT.h"
#define DHTPIN 2
#define DHTTYPE DHT22
DHT dht(DHTPIN,DHTTYPE);

// déclaration des variables
    // Peltier
    float tensionTermiPeltier = 0;
    float resistanceTermiPeltier = 0;
    // Externe
    float tensionTermiExterne = 0;
    float resistanceTermiExterne = 0;
    // Interne
    float humidite = 0;
    float temperatureInterne = 0;
    // Resistance systeme
    float resistanceSysteme = 10000;
    // Sortie arduino
    int sortieRegulation = 5;

void setup() {
    Serial.begin(9600);
    dht.begin();
}

void loop() {
    //Récupération données
    tensionTermiPeltier = analogRead(A0);
    tensionTermiExterne = analogRead(A3);
    humidite = dht.readHumidity();
    temperatureInterne = dht.readTemperature();

    //calcule des résistances
    resistanceTermiPeltier = resistanceSysteme/((1023/tensionTermiPeltier)-1);
    resistanceTermiExterne = resistanceSysteme/((1023/tensionTermiExterne)-1);

    //conversion des données
    String donnees = String(temperatureInterne) + ';' + String(humidite) + ';' + String(resistanceTermiPeltier) + ';' + String(resistanceTermiExterne);
    //envoie des données 
    Serial.println(donnees);


    if (Serial.available() > 0) {
        sortieRegulation = Serial.read();
        analogWrite(A2, sortieRegulation);
    }

        delay(2000);

}
