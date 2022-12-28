package documin.Repositories;

import documin.models.document;
import java.util.HashMap;

public class documentRepository {
    
    private HashMap<String, document> documentos;

    public documentRepository() {
        this.documentos = new HashMap<>();
    }

    
    /** 
     * @param documento
     */
    public void addDocument(document documento) {   
        this.documentos.put(documento.getTitulo(), documento);
    }

    
    /** 
     * @param titulo
     * @return document
     */
    public document getDocument(String titulo) {
        return this.documentos.get(titulo);
    }

    
    /** 
     * @param titulo
     */
    public void removeDocument(String titulo) {
        this.documentos.remove(titulo);
    }

}
