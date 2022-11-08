package main;

public class EntradasInvalidasExceptions {
    
    public static void entradasInvalidasComitivas (Comitiva[] comitivas, int id, String descricaoComitiva, int numIntegrantes, String contato) {
        if (id < 0 || id > 99) {
            throw new IndexOutOfBoundsException("ID inválido");
        }

        if (comitivas[id] != null) {
            throw new IllegalArgumentException("Comitiva já cadastrada");
        }

        if (numIntegrantes < 0) {
            throw new IllegalArgumentException("Número de integrantes inválido");
        }

        if (descricaoComitiva.isBlank() || contato.isBlank()) {
            throw new IllegalArgumentException("Descrição ou contato inválidos");
        }
    }

    public static void entradasInvalidasLocais (LocalVisitacao[] locais, String idUnico, String local, String ramal) {
        if (local.isBlank() || ramal.isBlank()) {
            throw new IllegalArgumentException("Local ou ramal inválidos");
        }

        if (hasLocal(locais, idUnico)){
            throw new IllegalArgumentException("Local já cadastrado");
        }
    }

    public static void entradasInvalidasExibeLocais(LocalVisitacao[] locais, String idUnico) {
        if (idUnico.isBlank()) {
            throw new IllegalArgumentException("ID inválido");
        }

        if(!hasLocal(locais, idUnico)) {
            throw new IllegalArgumentException("Local não cadastrado");
        }

    }

    public static void entradasInvalidasExibeComitivas(Comitiva[] comitivas, int id) {
        if (id < 0 || id > 99 || comitivas[id] == null) {
            throw new IndexOutOfBoundsException("Comitiva não cadastrada");
        }
    }

    private static boolean hasLocal(LocalVisitacao[] locais, String idUnico) {
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdUnico().equals(idUnico)) {
                return true;
            }
        }
        return false;
    }

}
