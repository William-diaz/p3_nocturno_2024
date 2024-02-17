package co.edu.uniquindio.almacen.almacenuq.almacenuq.Model;
import javafx.scene.control.Alert;
import java.util.ArrayList;

// Se crea la clase Almacen
public class Almacen {

    // la clase recibe dos listas, una de los productos y otra de los clientes
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;

    public Almacen(){

        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }


    // Funciones para busacr clientes y productos de las listas
    public Cliente buscarCliente (int id) throws Exception {

        try {
            return listaClientes.stream().filter(cliente -> cliente.getId()==id).findFirst().get();
        } catch (Exception e) {

            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("MENSAJE");
            mensaje.setHeaderText("Cliente no encontrado!!");
            mensaje.show();
            throw new Exception(e);
        }

    }
    public Producto buscarProducto (int idProducto) throws Exception {
        try {
            return listaProductos.stream().filter(producto -> producto.getIdProducto()== idProducto).
                    findFirst().get();
        } catch (Exception e) {

            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("MENSAJE");
            mensaje.setHeaderText("Producto no encontrado!!");
            mensaje.show();
            throw new Exception(e);
        }

    }

    // Funciones para eliminar clientes y productos de las listas
    public void eliminarCliente (Cliente persona){

        listaClientes.remove(persona.getId());

    }
    public void eliminarProducto (Producto unidad){

        listaClientes.remove(unidad.getIdProducto());

    }

    // Funciones para agregar clientes y productos de las listas
    public void agregarCliente (Cliente cliente){

        listaClientes.add(cliente);

    }

    public void agregarProducto (Producto producto){

        listaProductos.add(producto);

    }
}
