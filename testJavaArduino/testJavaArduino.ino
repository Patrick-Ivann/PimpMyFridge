// Initialisation variables
    float RTP = 0; 
    float RTPO = 0;
    float RTA = 0;
    float RTAO = 0;
    float R = 10000;
    float TS = 2.5;
    double Read;

    String ReadToSend;

void setup() {
    Serial.begin(9600);
}

void loop() {
// lecture port A0 RTP
    RTP = analogRead(A0);
// calcule RTPO
    RTPO = R/((1023/RTP)-1);
// lecture port A1 RTA
    RTA = analogRead(A1);
// calcule RTAO
    RTAO = R/((1023/RTA)-1);

// Envoie de la valeur de la resistance du peltier
String Donnees = String(RTPO);
String DonneesDeux = String(RTAO);
String DonneesEnvoie = Donnees + ';' + DonneesDeux;

//Serial.println(DonneesEnvoie);
   delay(3500);

// Reception de la tension a envoyer dans le systeme
if (Serial.available() > 0) {
           
              //charRead = char(Serial.read());
                      //TS = Serial.read();
                      Read = Serial.read();
                      
    }
//Serial.println(DonneesEnvoie + '----' + TS);
/*if(Read > 200){
Serial.println("on a plus de 200;" + String(Read) +";" + DonneesEnvoie);
  
}else{
  Serial.println("moins de 200");

}*/
Serial.println("10000;"+ String("210") +";" + String("150"));


analogWrite(A2, TS);
}
