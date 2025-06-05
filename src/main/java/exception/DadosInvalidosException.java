package exception;

public class DadosInvalidosException {
    public static void main(String[] args) {
        try {
            throw new DadosInvalidosException("Dados inválidos fornecidos.");
        } catch (DadosInvalidosException e) {
            System.out.println(e.getMensagem());
        }
        
    } String mensagem;

    public DadosInvalidosException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        if (mensagem == null || mensagem.isEmpty()) {
            return "Nenhuma mensagem de erro fornecida.";
        }
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        if (mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia.");
        }
        this.mensagem = mensagem;
    }
}
