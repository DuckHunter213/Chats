package Cliente.cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

public class ListaCustomizada extends AbstractListModel {

    private final List<String> listaUsuariosConectados;
    
    public ListaCustomizada(){
        listaUsuariosConectados = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listaUsuariosConectados.size();
    }

    @Override
    public Object getElementAt(int index) {
        String usuario = listaUsuariosConectados.get(index);
        return usuario;
    }

    public void addUsuario(String nombreUsuario) {
        listaUsuariosConectados.add(nombreUsuario);
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }

    public void eliminarUsuario(int index0) {
        listaUsuariosConectados.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize() + 1);
    }

    public String getUsuario(int index) {
        return listaUsuariosConectados.get(index);
    }
}
