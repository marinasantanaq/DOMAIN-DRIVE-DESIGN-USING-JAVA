public class transporte {
    private String modal;
    private String placa;
    private int capacidadeemKG;
    private int capacidadeemL;

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa + "-";
    }

    public int getCapacidadeemKG() {
        return capacidadeemKG;
    }

    public void setCapacidadeemKG(int capacidadeemKG) {
        this.capacidadeemKG = capacidadeemKG;
    }

    public int getCapacidadeemL() {
        return capacidadeemL;
    }

    public void setCapacidadeemL(int capacidadeemL) {
        this.capacidadeemL = capacidadeemL;
    }

    public transporte(String modal, String placa, int capacidadeemKG, int capacidadeemL) {

        if (capacidadeemKG < 0 || capacidadeemL > 0)
            this.modal = modal;
        this.placa = placa;
        this.capacidadeemKG = capacidadeemKG;
        this.capacidadeemL = capacidadeemL;

    }

    @Override
    public String toString() {
        return "transporte{" +
                "modal='" + modal + '\'' +
                ", placa='" + placa + '\'' +
                ", capacidadeemKG=" + capacidadeemKG +
                ", capacidadeemL=" + capacidadeemL +
                '}';
    }
}
