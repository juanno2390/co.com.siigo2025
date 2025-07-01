package config.frontend.pom_pattern.utils;

import com.google.common.base.Function;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Utilities {

    private Timer temporizador = new Timer();
    private int segundos = 0;
    private static final Random aleatorio = new Random();

    public void iniciarContadorTiempo() {
        this.segundos = 0;
        temporizador = new Timer();
        temporizador.schedule(new Contador(), 0, 1000);
    }

    public void detenerContadorTiempo() {
        temporizador.cancel();
    }

    public int getSegundos() {
        return this.segundos;
    }

    public static boolean compararDatosLista(String[] arrLista, String valorFiltro) {
        if (arrLista.length > 0) {
            for (String n : arrLista) {
                if (valorFiltro.trim().equals(n.trim())) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean validarNumero(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static String codificarCadenaUTF8(String cadena) {
        String salida = null;
        salida = new String(cadena.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return salida;
    }

    public static String quitarSignosPuntuacion(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
    texto = texto.replaceAll("\\p{Punct}", "");
        return texto;
    }

    public static String eliminarTildesCadena(String cadena) {
        return StringUtils.stripAccents(cadena);
    }

    /*08/01/2020: analizar cual de los dos siguientes métodos debe ser eliminado*/
    public static int generarNumeroAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static String generarAleatoriosNumeros(int longitudSerie) {
        StringBuilder serieNros = new StringBuilder();
        for (int i = 1; i <= longitudSerie; i++) {
            serieNros.append(aleatorio.nextInt(10));
        }
        return serieNros.toString();
    }

    public String generarLetrasAleatorias(int longitudSerie) {
        StringBuilder serieLetras = new StringBuilder();
        String[] abecedario = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S",
                "T", "U", "V", "W", "X", "Y", "Z"
        };
        for (int i = 1; i <= longitudSerie; i++) {
            serieLetras.append(abecedario[aleatorio.nextInt(26)]);
        }
        return serieLetras.toString();
    }

    public static List<String> obtenerListaRegistrosNoComunes(
            List<String> primeraListaComparar, List<String> segundaListaComparar) {
        return primeraListaComparar
                .stream()
                .filter(registro -> !segundaListaComparar.contains(registro))
                .collect(Collectors.toList());
    }

    public String transformarVacioNulo(String parametro) {
        if (parametro == null || parametro.isEmpty()) {
            return null;
        } else {
            return parametro;
        }
    }

    public static Boolean transformarCadenaValorlogico(String parametro) {
        Boolean valor;
        switch (parametro.toLowerCase()) {
            case "si":
            case "true":
                valor = true;
                break;
            case "no":
            case "false":
                valor = false;
                break;
            default:
                valor = null;
        }
        return valor;
    }

    public static String obtenerDatoCadena(String cadena, int posicion, String delimitadorCadena) {
        String[] cadenaPartes = cadena.split(delimitadorCadena);
        return cadenaPartes[posicion];
    }

    public static String buscarResponse(String etiqueta, String response) {
        String inicioEtiqueta = "<%s>";
        String finalEtiqueta = "</%s>";
        String[] busquedaParcial = response.split(String.format(inicioEtiqueta, etiqueta));
        String[] busquedaFinal = busquedaParcial[1].split(String.format(finalEtiqueta, etiqueta));

        return busquedaFinal[0];
    }

    private class Contador extends TimerTask {
        public void run() {
            segundos++;
        }
    }

    public static class IntegerBooleanFunction implements Function<Integer, Boolean> {
        public Boolean apply(Integer i) {
            return false;
        }
    }
}
