/**
 * 
 */
package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import interfaces.IModel;

/**
 * @author ivann VVV CESI Toulouse 3 déc. 2018
 *
 */
public class Communication implements SerialPortEventListener, Icommunication {

	CommPortIdentifier portId;
	private BufferedReader bufRead;
	private SerialPort port;
	SerialPort commPort;
	private String stringArduino;
	private OutputStream out;
	private String[] traitedStringArduino;
	private IModel modele;

	public Communication(IModel modele) {

		this.publ();
		this.modele = modele;

	}

	public void publ() {

		try {
			portId = CommPortIdentifier.getPortIdentifier("COM11");

		} catch (NoSuchPortException ex) {

			System.out.println(ex);
		}
		try {
			port = (SerialPort) portId.open("FridgeTest", 10000);
		} catch (PortInUseException ex) {
			// traitement de l'exception on a pas dd'arduino

			System.out.println(ex);
		}

		if (port instanceof SerialPort) {
			SerialPort serialPort = (SerialPort) port;
			try {
				serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);
			} catch (UnsupportedCommOperationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				port.addEventListener((SerialPortEventListener) this);
				port.notifyOnDataAvailable(true);

			} catch (TooManyListenersException e) {
			}

			// récupération du flux
			try {
				bufRead = new BufferedReader(new InputStreamReader(port.getInputStream()));
			} catch (IOException e) {
			}

			try {
				out = port.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Error: Only serial ports are handled by this example.");
		}

	}

	public void serialEvent(SerialPortEvent event) {

		if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {

			try {

				
				this.out.write(this.modele.regulation()); // on peut pas envoyer plus de 256

				stringArduino = (String) bufRead.readLine();
				// System.out.println(stringArduino);

				traitedStringArduino = (String[]) stringArduino.split(";");
				System.out.println("humidité"+ traitedStringArduino[1]+ " tempInt " + traitedStringArduino[0] + " resistance " + traitedStringArduino[2] + " résistance " + traitedStringArduino[3]   + "on écout Arduino");

				this.modele.setTempCurrent( Integer.parseInt(traitedStringArduino[0]));
				this.modele.setTempCurrentExt(Integer.parseInt(traitedStringArduino[3]));
				this.modele.setHumidite(Integer.parseInt(traitedStringArduino[1]));
				this.modele.setTempPelletier(Integer.parseInt(traitedStringArduino[2]));

			} catch (IOException e) {
			}

		}
	}

}
