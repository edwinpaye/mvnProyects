package pract.firstWebService.demo.dto;

public class Usuario {
    private int id;
    private String nombre;
    private byte edad;
    private String lastName;

    public Usuario(int id, String nombre, byte edad, String lastName) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
