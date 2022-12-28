package documin.Controllers;

import documin.models.document;
import documin.Repositories.documentRepository;

public class documentController {
    
    private documentRepository documentRepository;

    public documentController() {
        documentRepository = new documentRepository();
    }

    
    /** 
     * @param titulo
     * @return boolean
     */
    public boolean createDocument(String titulo) {
        document documento = new document(titulo);
        documentRepository.addDocument(documento);

        return true;
    }

    
    /** 
     * @param titulo
     * @param tamanho
     * @return boolean
     */
    public boolean createDocument(String titulo, Integer tamanho) {
        document documento = new document(titulo, tamanho);
        documentRepository.addDocument(documento);

        return true;
    }

    
    /** 
     * @param titulo
     */
    public void removeDocument(String titulo) {
        documentRepository.removeDocument(titulo);
    }
    

}

