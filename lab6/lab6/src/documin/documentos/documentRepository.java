package documin.documentos;

import java.util.HashMap;

public class documentRepository {
    
    private HashMap<String, document> documentos;

    public documentRepository() {
        this.documentos = new HashMap<>();
    }

    public void addDocument(document documento) {   
        this.documentos.put(documento.getTitulo(), documento);
    }

    public document getDocument(String titulo) {
        return this.documentos.get(titulo);
    }

    public void removeDocument(String titulo) {
        this.documentos.remove(titulo);
    }

}
