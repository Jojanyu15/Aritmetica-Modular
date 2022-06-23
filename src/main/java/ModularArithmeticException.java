public class ModularArithmeticException extends ArithmeticException {
    public ModularArithmeticException(String mensaje) {
        this.mensaje = mensaje;
    }
    protected String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
