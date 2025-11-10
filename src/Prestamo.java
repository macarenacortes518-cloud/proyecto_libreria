import java.util.Scanner;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private int diasPrestamo;
    private String fechaDevolucion;

    // 3.1.1: campo para almacenar el ISBN capturado por consola
    private String isbnLibro;

    public Prestamo(Usuario usuario, Libro libro, String fechaPrestamo, int diasPrestamo, String fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.diasPrestamo = diasPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // 3.1.1: getter del ISBN capturado
    public String getIsbnLibro() { // <<< nuevo 3.1.1
        return isbnLibro;
    }

    // 3.1.1: captura por consola del ISBN (solo formato, sin validar existencia)
    public void ingresarIsbnDesdeConsola(Scanner sc) { // <<< nuevo 3.1.1
        System.out.print("Ingrese ISBN del libro a prestar: ");
        String input = sc.nextLine().trim();

        // Validación básica de formato (ISBN-10 o ISBN-13, con o sin guiones)
        while (input.isEmpty() || !formatoIsbnBasicoValido(input)) {
            System.out.println("ISBN vacío o con formato incorrecto. Intente nuevamente.");
            System.out.println("Ejemplos: 978-956-123456-7 | 9789561234567 | 956123456X");
            System.out.print("Ingrese ISBN del libro a prestar: ");
            input = sc.nextLine().trim();
        }

        this.isbnLibro = input;
    }

    // Método auxiliar: valida estructura del ISBN (no verifica existencia en el sistema)
    private boolean formatoIsbnBasicoValido(String s) {
        String clean = s.replaceAll("-", "").toUpperCase();
        // ISBN-13: 13 dígitos; ISBN-10: 9 dígitos + (dígito o 'X')
        return clean.matches("\\d{13}") || clean.matches("\\d{9}[\\dX]");
    }
}
