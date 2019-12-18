package javamqtt;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://[ip a ser escutado]", null, null);
        clienteMQTT.iniciar();

        new Ouvinte(clienteMQTT, "TempDHT", 0);

        while (true) {
            Thread.sleep(1000);
            String mensagem = "Mensagem enviada em " /*+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()) + " - Teste de MQTT"*/;

            clienteMQTT.publicar("VTRValorUni", mensagem.getBytes(), 0);
        }

    }

}
