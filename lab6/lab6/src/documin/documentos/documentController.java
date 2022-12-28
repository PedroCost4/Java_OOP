package documin.documentos;

public class documentController {
    
    private documentRepository documentRepository;

    public documentController() {
        documentRepository = new documentRepository();
    }

    public boolean createDocument(String titulo) {
        document documento = new document(titulo);
        documentRepository.addDocument(documento);

        return true;
    }

    public boolean createDocument(String titulo, Integer tamanho) {
        document documento = new document(titulo, tamanho);
        documentRepository.addDocument(documento);

        return true;
    }

    public void removeDocument(String titulo) {
        documentRepository.removeDocument(titulo);
    }
    

}
